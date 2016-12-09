package co.sprayable.sleep.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
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

public class SleepSprayableVslPage extends BasePage {

    private BufferedImage image;
    private BufferedImage firstScreenshot;
    private BufferedImage secondScreenshot;

    private Locator divVideoContainer = new Locator(LocatorTypes.XPATH, "//div[@class='wistia_responsive_padding']");
    private Locator divOrderNow = new Locator(LocatorTypes.XPATH, "//div[contains(@class, 'btnBuy')]");

    public void waitDivVideoContainer() {
        waitToBeClickable("wait for div video container become clickable", divVideoContainer);
    }

    public void clickDivVideoContainer() {
        click("click on div video container", divVideoContainer);
    }

    public String makeAScreenShot() {
        Reporter.logAction("Making a screenshot");

        File scrFile = ((TakesScreenshot)driver()).getScreenshotAs(OutputType.FILE);

        WebElement webElement = driver().findElement(divVideoContainer.getLocator());

        try {
            image = ImageIO.read(scrFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Point point = webElement.getLocation();
        BufferedImage elementImage = image.getSubimage(point.getX(), point.getY(), webElement.getSize().getWidth(), webElement.getSize().getHeight() / Constants.HEIGHT_DIVIDER);

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

    public boolean deleteFile(String path) {
        Reporter.logAction("Deleting the file " + path);
        return new File(path).delete();
    }

    public boolean compareImages(String firstScreenshotPath, String secondScreenshotPath) {

        try {
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

    public void clickDivOrderNow() {
        waitToBeClickable("wait for 'Order Now' button become clickable", divOrderNow);
        click("click 'Order Now' button", divOrderNow);
    }
}