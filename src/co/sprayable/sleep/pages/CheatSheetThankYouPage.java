package co.sprayable.sleep.pages;

import co.sprayable.sleep.utils.FileDownloader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import qa.util.Constants;
import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;
import qa.util.reporting.Reporter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class CheatSheetThankYouPage extends BasePage {

    private final int HEIGHT_LOWER_SHIFT = 55;
    private final int Y_SHIFT = 16;
    private final int X_SHIFT = 16;

    private BufferedImage image;
    private BufferedImage firstScreenshot;
    private BufferedImage secondScreenshot;

    private Locator playButton = new Locator(LocatorTypes.XPATH, "//video[@id='my-video_html5_api']/../button");
    private Locator pauseButton = new Locator(LocatorTypes.XPATH, "//div[@class='vjs-control-bar']//button[contains(@class, 'vjs-playing')]");

    private Locator video = new Locator(LocatorTypes.XPATH, "//video[@id='my-video_html5_api']");
    //private Locator video = new Locator(LocatorTypes.XPATH, "//video[@id='my-video']");
    private Locator linkDownloadNow = new Locator(LocatorTypes.XPATH, "//a[@id='downloadInsomniaPdf']");
    private Locator linkGetItNow = new Locator(LocatorTypes.XPATH, "//section[@class='goodbye_insomnia']//a[@class='greenBtn']");

    //private Locator regionPlayer = new Locator(LocatorTypes.XPATH, "//div[@id='my-video']");

    private String downloadedFileAbsoluteLocation;

    public void clickPlayButton() {
        click("Click 'Play' button", playButton);
    }


    public void clickPauseButton(){
        click("Click 'Pause' button", pauseButton);
    }

    public String makeAScreenShot() {
        Reporter.logAction("Making a screenshot");

        File scrFile = ((TakesScreenshot)driver()).getScreenshotAs(OutputType.FILE);

        WebElement webElement = driver().findElement(video.getLocator());

        try {
            image = ImageIO.read(scrFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Point point = webElement.getLocation();
        BufferedImage elementImage = image.getSubimage(point.getX(), point.getY() + Y_SHIFT, webElement.getSize().getWidth(), webElement.getSize().getHeight() - HEIGHT_LOWER_SHIFT);

        try {
            ImageIO.write(elementImage, "png", scrFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String current =  Constants.PATH_IMAGE + "image" + "_" + new Date().getTime() + ".png";

        try {
            FileUtils.copyFile(scrFile, new File(current));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return current;
    }

    public boolean compareImages(String firstScreenshotPath, String secondScreenshotPath) {

        try{
            firstScreenshot = ImageIO.read(new File(firstScreenshotPath));
            secondScreenshot = ImageIO.read(new File(secondScreenshotPath));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        int firstScreenshotWidth = firstScreenshot.getWidth();
        int secondScreenshotWidth = secondScreenshot.getWidth();
        if (firstScreenshotWidth != secondScreenshotWidth) {
            Reporter.log("Widths are different: " + firstScreenshotWidth + " != " + secondScreenshotWidth);

            return false;
        }

        int firstScreenshotHeight = firstScreenshot.getHeight();
        int secondScreenshotHeight = secondScreenshot.getHeight();
        if (firstScreenshotHeight != secondScreenshotHeight) {
            Reporter.log("Heights are different: " + firstScreenshotHeight + " != " + secondScreenshotHeight);

            return false;
        }

        for (int x = 0; x < firstScreenshotWidth; x++) {
            for (int y = 0; y < firstScreenshotHeight; y++){
                int firstScreenshotPixelColorModel = firstScreenshot.getRGB(x, y);
                int secondScreenshotPixelColorModel = secondScreenshot.getRGB(x, y);
                if (firstScreenshotPixelColorModel != secondScreenshotPixelColorModel) {
                    Reporter.log("Pixel is different at x/y " + x + "/" + y + ": " + firstScreenshotPixelColorModel + " != " + secondScreenshotPixelColorModel);

                    return false;
                }
            }
        }

        return true;
    }

    public boolean deleteFile(String path) {
        Reporter.logAction("Deleting the file " + path);
        return new File(path).delete();
    }

    public void waitLinkDownloadNow() {
        waitForVisibility("waiting for 'Download Now' button become visible", linkDownloadNow);
    }

    public void waitForInvisibilityLinkDownloadNow() {
        waitForInvisibility("waiting for 'Download Now' button become invisible", linkDownloadNow);
    }

    public void clickLinkGetItNow() {
        waitForPresence("waiting for 'Get It Now' link become present", linkGetItNow);
        click("click on 'Get It Now' link", linkGetItNow);
    }

    //TODO
    public void mimicOpeningFile() {
        FileDownloader downloadInsomniaPdf = new FileDownloader(driver());

        WebElement downloadLink = driver().findElement(linkDownloadNow.getLocator());

        try {
            downloadedFileAbsoluteLocation = downloadInsomniaPdf.downloadFile(downloadLink);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertTrue(new File(downloadedFileAbsoluteLocation).exists(), "downloading was not performed");
    }

    public boolean deleteFile() {
        return new File(downloadedFileAbsoluteLocation).delete();
    }
}