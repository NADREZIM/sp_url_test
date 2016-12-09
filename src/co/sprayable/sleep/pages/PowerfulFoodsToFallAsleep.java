package co.sprayable.sleep.pages;

import co.sprayable.sleep.actions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qa.util.Constants;
import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;
import qa.util.reporting.Reporter;

import java.awt.*;

import static qa.util.Constants.Y_SHIFT;

public class PowerfulFoodsToFallAsleep extends BasePage {

    private Locator body = new Locator(LocatorTypes.XPATH, "//body");
    private Locator linkCloseModal = new Locator(LocatorTypes.XPATH, "//div[@id='emailFormPopup']//a[@id='closeModal']");
    private Locator inputFirstName = new Locator(LocatorTypes.XPATH, "//form[@id='cheatSheetDownloadForm']//input[@id='inf_field_FirstName']");
    private Locator inputEmail = new Locator(LocatorTypes.XPATH, "//form[@id='cheatSheetDownloadForm']//input[@id='inf_field_Email']");
    private Locator inputEmailMeNow = new Locator(LocatorTypes.XPATH, "//input[@id='download']");
    private Locator imgDownloadButton = new Locator(LocatorTypes.XPATH, "//img[@class='download-button']");
    private Locator imgLearnMoreButton = new Locator(LocatorTypes.XPATH, "//section[@class='banner_sidebar']//img[@alt='One Weird Trick to Stay Asleep']");
    private Locator imgLearnMoreBelowButton = new Locator(LocatorTypes.XPATH, "//section[@class='banner_bottom']//img");
    private Locator linkIWantToTryItNow = new Locator(LocatorTypes.XPATH, "//div[@class='insomnia-video']/a");

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
            new Robot().mouseMove(driver().manage().window().getPosition().getX() + xShift, driver().manage().window().getPosition().getY() + Y_SHIFT);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void clickLinkCloseModal() {
        waitForVisibility("waiting for 'or close this modal' link become visible", linkCloseModal);
        click("click on 'or close this modal'", linkCloseModal);
        waitForInvisibility("waiting for 'or close this modal' link become invisible", linkCloseModal);
    }

    public boolean isCheatSheetModalPresent() {
        return driver().findElement(By.xpath("//div[@id='emailFormPopup']//a[@id='closeModal']")).isDisplayed();
    }

    public void enterFirstName(String firstName) {
        waitForVisibility("waiting for input 'First Name' become visible", inputFirstName);
        type("typing in 'First Name' input", firstName , inputFirstName);
    }

    public void enterEmail(String email) {
        type("typing in '...Your Email...' input", email , inputEmail);
    }

    public void clickInputEmailMeNow() {
        click("click on 'Email Me Now Button'", inputEmailMeNow);
    }

    public void clickImgDownloadButton() {
        waitToBeClickable("waiting for 'Download Now' button become clickable", imgDownloadButton);
        click("click 'Download Now' button", imgDownloadButton);
    }

    public void clickImgLearnMoreButton() {
        waitToBeClickable("waiting for 'Learn More' button become clickable", imgLearnMoreButton);
        click("click 'Learn More' button", imgLearnMoreButton);
    }

    public void waitForInvisibilityImgLearnMoreButton() {
        waitForInvisibility("waiting for 'Learn More' button become invisible", imgLearnMoreButton);
    }

    public void clickImgLearnMoreBelowButton() {
        waitToBeClickable("waiting for 'Learn More' button in the bottom of page become clickable", imgLearnMoreBelowButton);
        click("click 'Learn More' button in the bottom of page", imgLearnMoreBelowButton);
    }

    public void clickLinkIWantToTryItNow() {
        waitToBeClickable("waiting for 'I Want To Try It Now' link become clickable", linkIWantToTryItNow);
        click("click 'I Want To Try It Now' link", linkIWantToTryItNow);
    }
}