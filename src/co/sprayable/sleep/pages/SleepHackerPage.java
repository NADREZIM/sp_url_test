package co.sprayable.sleep.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;
import qa.util.reporting.Reporter;

public class SleepHackerPage extends BasePage {

    private Locator linkAddToCartFirst = new Locator(LocatorTypes.XPATH, "//div[@id='le_body_row_46_col_1_el_5']//a");
    private Locator linkAddToCartSecond = new Locator(LocatorTypes.XPATH, "//div[@id='le_body_row_46_col_1_el_8']//a");
    private Locator linkAddToCartThird = new Locator(LocatorTypes.XPATH, "//div[@id='le_body_row_46_col_1_el_10']//a");
    private Locator linkAddToCartToCheckout = new Locator(LocatorTypes.XPATH, "//div[@id='le_body_row_45_col_1_el_1']//a");


    public void moveToFirstAddToCartLink() {
        Reporter.logAction("Scrolling page to first 'Add To Cart' link");

        JavascriptExecutor je = (JavascriptExecutor) driver();
        je.executeScript("arguments[0].scrollIntoView(true);", driver().findElement(linkAddToCartFirst.getLocator()));
    }

    public void clickFirstAddToCartLink() {
        click("click first 'Add To Cart' link", linkAddToCartFirst);
    }

    public void moveToSecondAddToCartLink() {
        Reporter.logAction("Scrolling page to second 'Add To Cart' link");
        JavascriptExecutor je = (JavascriptExecutor) driver();
        je.executeScript("arguments[0].scrollIntoView(true);", driver().findElement(linkAddToCartSecond.getLocator()));
    }

    public void clickSecondAddToCartLink() {
        click("click second 'Add To Cart' link", linkAddToCartSecond);
    }

    public void moveToThirdAddToCartLink() {
        Reporter.logAction("Scrolling page to third 'Add To Cart' link");

        JavascriptExecutor je = (JavascriptExecutor) driver();
        je.executeScript("arguments[0].scrollIntoView(true);", driver().findElement(linkAddToCartThird.getLocator()));
    }

    public void clickThirdAddToCartLink() {
        click("click third 'Add To Cart' link", linkAddToCartThird);
    }

    public void scrollUpThePage() {
        ((JavascriptExecutor) driver()).executeScript("scroll(0, -250);");
    }

    public void clickLinkAddToCartToCheckout() {
        click("click link 'Add To Cart' before checkout", linkAddToCartToCheckout);
    }

    public void waitLinkAddToCartToCheckoutDisappear() {
        waitForInvisibility("waiting for link 'Add To Cart' before checkout disappear", linkAddToCartToCheckout);
    }
}