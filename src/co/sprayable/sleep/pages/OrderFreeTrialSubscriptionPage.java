package co.sprayable.sleep.pages;

import org.openqa.selenium.JavascriptExecutor;
import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;
import qa.util.reporting.Reporter;

public class OrderFreeTrialSubscriptionPage extends BasePage {

    private Locator divReadyToTrySprayable = new Locator(LocatorTypes.XPATH, "//div[@class='buttons']/div[contains(@class, 'btnBuy ')]");
    private Locator linkBuyNow = new Locator(LocatorTypes.XPATH, "//div[@class='buttons']/a[contains(@class, 'js_orderButton')]");

    public void moveToReadyToTrySprayable() {
        Reporter.logAction("Scrolling page to 'Ready To Try Sprayable' link");

        JavascriptExecutor je = (JavascriptExecutor) driver();
        je.executeScript("arguments[0].scrollIntoView(true);", driver().findElement(divReadyToTrySprayable.getLocator()));
    }

    public void clickReadyToTrySprayable() {
        click("click div 'Im Ready To Try Sprayable'", divReadyToTrySprayable);
    }

    public void clickLinkBuyNow() {
        waitToBeClickable("waiting for link 'Buy Now' become clickable", linkBuyNow);
        click("click link 'Buy Now'", linkBuyNow);
    }

    public void waitReadyToTrySprayableDisappear() {
        waitForInvisibility("waiting for div 'Im Ready To Try Sprayable' disappears", divReadyToTrySprayable);
    }
}