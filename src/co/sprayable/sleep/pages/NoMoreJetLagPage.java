package co.sprayable.sleep.pages;

import org.openqa.selenium.WebElement;
import qa.util.Constants;
import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;
import qa.util.reporting.Reporter;

import java.awt.*;

public class NoMoreJetLagPage extends BasePage {

    private Locator body = new Locator(LocatorTypes.XPATH, "//body");
    private Locator linkClaimSample = new Locator(LocatorTypes.XPATH, "//a[img[@alt='Claim Sample']]");
    private Locator linkClaimSampleSecond = new Locator(LocatorTypes.XPATH, "//input[contains(@src, 'claim-button2')]");
    private Locator linkShowMeFreeTrial = new Locator(LocatorTypes.XPATH, "//div[@class='modal-buttons']//a[contains(@class, 'btn-yellow')]");


    public void clickClaimSampleButton() {
        waitToBeClickable("waiting for 'Claim sample' link become clickable", linkClaimSample);
        click("Click 'Claim Sample' button", linkClaimSample);
    }

    public void clickClaimSampleSecondButton() {
        waitToBeClickable("waiting for 'Claim Sample' link become clickable", linkClaimSampleSecond);
        click("Click 'Claim Sample' button again", linkClaimSampleSecond);
    }

    public void waitClaimSampleButtonDisappear() {
        waitForInvisibility("waiting for button 'Claim You Free 10-Day Sample' disappear", linkClaimSampleSecond);
    }

    public void waitLinkShowMeFreeTrialDisappear() {
        waitForInvisibility("waiting for link 'Show me the FREE trial offer', disappear", linkShowMeFreeTrial);
    }

    public void clickLinkShowMeFreeTrial() {
        waitToBeClickable("waiting for link 'Show me the FREE trial offer' become clickable", linkShowMeFreeTrial);
        click("click link 'Show me the FREE trial offer'", linkShowMeFreeTrial);
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
}