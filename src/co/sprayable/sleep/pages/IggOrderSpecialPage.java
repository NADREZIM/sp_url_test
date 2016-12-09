package co.sprayable.sleep.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;
import qa.util.reporting.Reporter;

public class IggOrderSpecialPage extends BasePage {

    private Locator divReadyToTrySprayable = new Locator(LocatorTypes.XPATH, "//div[@class='buttons']/div[contains(@class, 'btnBuy ')]");
    private Locator linkOrderSprayableNow = new Locator(LocatorTypes.XPATH, "//a[contains(@class, 'btnBuy')]");
    private Locator linkBuyNow = new Locator(LocatorTypes.XPATH, "//a[contains(@class, 'js_orderButton')]");

    public void moveToReadyToTrySprayable() {
        Reporter.logAction("Scrolling page to 'Ready To Ready To Try Sprayable' link");

        JavascriptExecutor je = (JavascriptExecutor) driver();
        WebElement element = driver().findElement(divReadyToTrySprayable.getLocator());
        je.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickReadyToTrySprayable() {
        click("click div 'Im Ready To Try Sprayable'", divReadyToTrySprayable);
    }

    public void moveToOrderSprayableNow() {
        Reporter.logAction("Scrolling page to 'Order Sprayable Now' link");

        JavascriptExecutor je = (JavascriptExecutor) driver();
        WebElement element = driver().findElement(linkOrderSprayableNow.getLocator());
        je.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickOrderSprayableNow() {
        click("click link 'Order Sprayable Now'", linkOrderSprayableNow);
    }

    public void clickLinkBuyNow() {
        click("click link 'Order Now'", linkBuyNow);
    }

    public void waitLinkBuyNowDisappear() {
        waitForInvisibility("waiting for link 'Order Now' disappears", linkBuyNow);
    }
}