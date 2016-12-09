package co.sprayable.sleep.pages;

import co.sprayable.sleep.actions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import qa.util.Constants;
import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;
import qa.util.reporting.Reporter;

import java.awt.*;

public class OrderPage extends BasePage {

    private Locator body = new Locator(LocatorTypes.XPATH, "//body");
    private Locator linkShowMeFreeTrial = new Locator(LocatorTypes.XPATH, "//div[@class='modal-buttons']//a[contains(@class, 'btn-yellow')]");
    private Locator divReadyToTrySprayable = new Locator(LocatorTypes.XPATH, "//div[@class='buttons']/div[contains(@class, 'btnBuy ')]");
    private Locator linkBuyNow = new Locator(LocatorTypes.XPATH, "//div[@class='buttons']/a[contains(@class, 'js_orderButton')]");

    public void clickLinkShowMeFreeTrial() {
        waitToBeClickable("waiting for link 'Show me the FREE trial offer' become clickable", linkShowMeFreeTrial);
        click("click link 'Show me the FREE trial offer'", linkShowMeFreeTrial);
    }

    public void moveToReadyToTrySprayable() {
        Reporter.logAction("Scrolling page to 'Ready To Try Sprayable' link");

        JavascriptExecutor je = (JavascriptExecutor) driver();
        je.executeScript("arguments[0].scrollIntoView(true);", driver().findElement(divReadyToTrySprayable.getLocator()));
    }

    public void clickLinkBuyNow() {
        waitToBeClickable("waiting for link 'Buy Now' become clickable", linkBuyNow);
        click("click link 'Buy Now'", linkBuyNow);
    }

    public void clickReadyToTrySprayable() {
        click("click div 'Im Ready To Try Sprayable'", divReadyToTrySprayable);
    }

    public void waitLinkShowMeFreeTrialDisappear() {
        waitForInvisibility("waiting for link 'Show me the FREE trial offer', disappear", linkShowMeFreeTrial);
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
}