package co.sprayable.sleep.utils;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.protocol.BasicHttpContext;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.util.reporting.Reporter;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;


public class FileDownloader {

    private WebDriver driver;
    private String localDownloadPath = System.getProperty("java.io.tmpdir");
    private boolean followRedirects = true;
    private boolean mimicWebDriverCookieState = true;
    private int httpStatusOfLastDownloadAttempt = 0;

    public FileDownloader(WebDriver driverObject) {
        driver = driverObject;
    }

    /**
     * Specify if the FileDownloader class should follow redirects when trying to download a file
     *
     * @param value
     */
    public void followRedirectsWhenDownloading(boolean value) {
        followRedirects = value;
    }

    /**
     * Get the current location that files will be downloaded to.
     *
     * @return The filepath that the file will be downloaded to.
     */
    public String localDownloadPath() {
        return localDownloadPath;
    }

    /**
     * Download the file specified in the href attribute of a WebElement
     *
     * @param element
     * @return
     * @throws Exception
     */
    public String downloadFile(WebElement element) throws Exception {
        return downloader(element, "href");
    }

    /**
     * Download the image specified in the src attribute of a WebElement
     *
     * @param element
     * @return
     * @throws Exception
     */
    public String downloadImage(WebElement element) throws Exception {
        return downloader(element, "src");
    }

    /**
     * Gets the HTTP status code of the last download file attempt
     *
     * @return
     */
    public int getHTTPStatusOfLastDownloadAttempt() {
        return httpStatusOfLastDownloadAttempt;
    }

    /**
     * Mimic the cookie state of WebDriver (Defaults to true)
     * This will enable you to access files that are only available when logged in.
     * If set to false the connection will be made as an anonymous user
     *
     * @param value
     */
    public void mimicWebDriverCookieState(boolean value) {
        mimicWebDriverCookieState = value;
    }

    /**
     * Load in all the cookies WebDriver currently knows about so that we can mimic the browser cookie state
     *
     * @param seleniumCookieSet
     * @return
     */
    private BasicCookieStore mimicCookieState(Set seleniumCookieSet) {
        BasicCookieStore mimicWebDriverCookieStore = new BasicCookieStore();

        Iterator<Cookie> iterator = seleniumCookieSet.iterator();

        while(iterator.hasNext()) {
            Cookie element = iterator.next();
            BasicClientCookie duplicateCookie = new BasicClientCookie(element.getName(), element.getValue());
            duplicateCookie.setDomain(element.getDomain());
            duplicateCookie.setSecure(element.isSecure());
            duplicateCookie.setExpiryDate(element.getExpiry());
            duplicateCookie.setPath(element.getPath());
            mimicWebDriverCookieStore.addCookie(duplicateCookie);
        }

        return mimicWebDriverCookieStore;
    }

    /**
     * Perform the file/image download.
     *
     * @param element
     * @param attribute
     * @return
     * @throws IOException
     * @throws NullPointerException
     */
    private String downloader(WebElement element, String attribute) throws IOException, NullPointerException, URISyntaxException {
        String fileToDownloadLocation = element.getAttribute(attribute);
        if (fileToDownloadLocation.trim().equals("")) {
            throw new NullPointerException("The element you have specified does not link to anything!");
        }



        URL fileToDownload = new URL(fileToDownloadLocation);
        File downloadedFile = new File(localDownloadPath + fileToDownload.getFile().replaceFirst("/|\\\\", ""));
        if (downloadedFile.canWrite() == false) {
            downloadedFile.setWritable(true);
        }

        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(1000).setConnectTimeout(1000).setSocketTimeout(1000).setRedirectsEnabled(followRedirects).build();

        HttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();

        BasicHttpContext localContext = new BasicHttpContext();

        Reporter.logAction("Mimic WebDriver cookie state: " + mimicWebDriverCookieState);
        if (this.mimicWebDriverCookieState) {
            localContext.setAttribute(HttpClientContext.COOKIE_STORE, mimicCookieState(this.driver.manage().getCookies()));
        }

        HttpGet httpget = new HttpGet(fileToDownload.toURI());

        Reporter.logAction("Sending GET request for: " + httpget.getURI());
        HttpResponse response = client.execute(httpget, localContext);
        httpStatusOfLastDownloadAttempt = response.getStatusLine().getStatusCode();
        Reporter.logAction("HTTP GET request status: " + httpStatusOfLastDownloadAttempt);
        Reporter.logAction("Downloading file: " + downloadedFile.getName());
        FileUtils.copyInputStreamToFile(response.getEntity().getContent(), downloadedFile);
        response.getEntity().getContent().close();

        String downloadedFileAbsolutePath = downloadedFile.getAbsolutePath();
        Reporter.logAction("File downloaded to '" + downloadedFileAbsolutePath + "'");

        return downloadedFileAbsolutePath;
    }
}