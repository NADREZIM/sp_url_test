package co.sprayable.sleep.pages;

import co.sprayable.sleep.actions.Actions;
import org.openqa.selenium.WebElement;
import qa.util.Constants;
import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;
import qa.util.reporting.Reporter;

import java.awt.*;

public class UltimateOfferPage extends BasePage {

    private final String PAUSE_CSS_CLASS = "paused-mode";
    private final String PLAYING_CSS_CLASS = "playing-mode";
    private final String UNSTARTED_CSS_CLASS = "unstarted-mode";

    private Locator body = new Locator(LocatorTypes.XPATH, "//body");
    private Locator iframeVideo = new Locator(LocatorTypes.XPATH, "//section[@class='video-cta']//iframe");
    private Locator buttonLargePlay = new Locator(LocatorTypes.XPATH, "//div[@id='player']//button[contains(@class, 'ytp-large-play-button')]");
    private Locator buttonPause = new Locator(LocatorTypes.XPATH, "//div[@class='ytp-left-controls']//button[contains(@class, 'ytp-play-button')]");
    private Locator divVideoContainer = new Locator(LocatorTypes.XPATH, "//div[@id='player']/div");
    private Locator linkGetMyDiscount = new Locator(LocatorTypes.XPATH, "//div[@class='modal-right']/a[contains(@class, 'btn')]");
    private Locator linkIWantMyFreeSample = new Locator(LocatorTypes.XPATH, "//section[@class='bottom-cta']//a[contains(@class, 'btn')]");

    public void clickLargePlay() {
        driver().switchTo().frame(driver().findElement(iframeVideo.getLocator()));

        waitToBeClickable("waiting for large 'Play' button become clickable", buttonLargePlay);

        try {
            WebElement buttonPlay = driver().findElement(buttonLargePlay.getLocator());
            buttonPlay.click();

            Reporter.logAction("click large 'Play' button");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement buttonPlay = driver().findElement(buttonLargePlay.getLocator());
            buttonPlay.click();

            Reporter.logAction("click large 'Play' button");
        }
    }

    public void clickPause() {
        driver().switchTo().frame(driver().findElement(iframeVideo.getLocator()));

        waitForPresence("waiting for 'Pause' button become present", buttonPause);

        try {
            WebElement buttonPlay = driver().findElement(buttonPause.getLocator());
            buttonPlay.click();

            Reporter.logAction("click 'Pause' button");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement buttonPlay = driver().findElement(buttonPause.getLocator());
            buttonPlay.click();

            Reporter.logAction("click 'Pause' button");
        }
    }

    public void waitBody() {
        waitForPresence("waiting for 'body' presents", body);
        Actions.mainActions().wait(Constants.MICRO_TIMEOUT_SECONDS);
    }

    public void moveToAddressLine() {
        Reporter.logAction("Moving cursor to address line");

        WebElement elemBody = driver().findElement(body.getLocator());

        int x = elemBody.getSize().getWidth() / Constants.BODY_WITH_DIVIDER;

        try {
            new Robot().mouseMove(x, 0);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void moveToPage() {
        Reporter.logAction("Moving cursor to page");

        WebElement elemBody = driver().findElement(body.getLocator());

        int xShift = elemBody.getSize().getWidth() / Constants.BODY_WITH_DIVIDER;

        try {
            new Robot().mouseMove(driver().manage().window().getPosition().getX() + xShift, driver().manage().window().getPosition().getY() + Constants.Y_SHIFT);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void clickLinkGetMyDiscount() {
        waitToBeClickable("wait for 'Get My 25% Sprayable Sleep Discount' button become clickable", linkGetMyDiscount);
        click("click 'Get My 25% Sprayable Sleep Discount' button", linkGetMyDiscount);
    }

    public void waitLinkGetMyDiscountDissapear() {
        waitForInvisibility("wait for 'Get My 25% Sprayable Sleep Discount' button become invisible", linkGetMyDiscount);
    }

    public void clickLinkIWantMyFreeSample() {
        waitToBeClickable("wait for 'I Want My Free Sample' button become clickable", linkIWantMyFreeSample);
        click("click 'I Want My Free Sample' button", linkIWantMyFreeSample);
    }

    public boolean isVideoPlaying(){
        driver().switchTo().frame(driver().findElement(iframeVideo.getLocator()));
        return getAttributeValue("Check player is playing", "class", divVideoContainer).contains(PLAYING_CSS_CLASS);

    }
    public boolean isVideoNotPlaying(){
        driver().switchTo().frame(driver().findElement(iframeVideo.getLocator()));
        return  getAttributeValue("Check player is stopped", "class", divVideoContainer).contains(PAUSE_CSS_CLASS)
                || getAttributeValue("Check player is stopped", "class", divVideoContainer).contains(UNSTARTED_CSS_CLASS) ;
    }
}