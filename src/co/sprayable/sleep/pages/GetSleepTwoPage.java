package co.sprayable.sleep.pages;

import org.openqa.selenium.WebElement;
import qa.util.Constants;
import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;
import qa.util.reporting.Reporter;

import java.awt.*;

public class GetSleepTwoPage extends BasePage {

//    private  final int BODY_WIDTH_DIVIDER = 3;
//    private final int Y_SHIFT = 150;
//
//    Robot robot;

    private Locator body = new Locator(LocatorTypes.XPATH, "//body");
    private Locator linkClaimFreeSampleTop = new Locator(LocatorTypes.XPATH, "//a[img[@alt='Claim Sample']]");
//    private Locator claimForm = new Locator(LocatorTypes.XPATH, "//div[@class='claim-form-container']/form");
    private Locator divReadyToTrySprayable = new Locator(LocatorTypes.XPATH, "//div[@class='buttons']/div[contains(@class, 'btnBuy ')]");
    private Locator linkShowMeFreeTrial = new Locator(LocatorTypes.XPATH, "//div[@class='modal-buttons']//a[contains(@class, 'btn-yellow')]");
    private Locator linkClaimFreeSampleBottom = new Locator(LocatorTypes.XPATH, "//input[contains(@src, 'claim-button2')]");

    public void clickClaimSampleButton() {
        waitToBeClickable("waiting for link 'Claim Sample' become clickable", linkClaimFreeSampleTop);
        click("Click 'Claim Sample' button", linkClaimFreeSampleTop);
    }

    public void clickClaimSampleSecondButton() {
        waitToBeClickable("Wait 'Claim Sample' button to be clickable", linkClaimFreeSampleBottom);
        click("Click 'Claim Sample' button again", linkClaimFreeSampleBottom);
    }

    public void waitClaimSampleButtonDisappear() {
        waitForInvisibility("waiting for button 'Claim You Free 10-Day Sample' disappear", linkClaimFreeSampleTop);
    }

    public void waitBody() {
        waitForPresence("waiting for 'body' presents", body);
        co.sprayable.sleep.actions.Actions.mainActions().wait(Constants.MICRO_TIMEOUT_SECONDS);
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

    public void waitReadyToTrySprayableDisappear() {
        waitForInvisibility("waiting for div 'Im Ready To Try Sprayable' disappear", divReadyToTrySprayable);
    }

    public void waitLinkShowMeFreeTrialDisappear() {
        waitForInvisibility("waiting for link 'Show me the FREE trial offer', disappear", linkShowMeFreeTrial);
    }

    public void clickLinkShowMeFreeTrial() {
        waitToBeClickable("waiting for link 'Show me the FREE trial offer' become clickable", linkShowMeFreeTrial);
        click("click link 'Show me the FREE trial offer'", linkShowMeFreeTrial);
    }
}