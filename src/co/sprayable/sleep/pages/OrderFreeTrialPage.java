package co.sprayable.sleep.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;
import qa.util.reporting.Reporter;

import java.util.ArrayList;

public class OrderFreeTrialPage extends BasePage {

    private Locator topListProduct = new Locator(LocatorTypes.XPATH,
            "//div[contains(@class, 'packages')][1]//div[div[@class='header']" +
                    "//div[contains(text(), '%s')]]//div[contains(@class, 'btnSelect ')]");

    private Locator genericTopListProduct = new Locator(LocatorTypes.XPATH,
            "//div[contains(@class, 'packages')][2]//div[div[@class='header']" +
                    "//div[contains(text(), '%s')]]//div[contains(@class, 'btnSelect ')]");

    private Locator divReadyToTrySprayable = new Locator(LocatorTypes.XPATH, "//div[@class='buttons']/div[contains(@class, 'btnBuy ')]");

//    public void waitSelectProduct(String supplyType) {
//        waitForVisibility("Wait for " + supplyType + "supply", topListProduct, supplyType);
//    }

    public void selectProductBySupplyType(String supplyType) {
        waitForVisibility("Wait for " + supplyType + "supply become visible", topListProduct, supplyType);
        clickJS("Select product with " + supplyType + " supply", topListProduct, supplyType);
    }

    public void waitSelectProductDisappear (String supplyType) {
        waitForInvisibility("Wait for " + supplyType + " disappear", topListProduct, supplyType);
    }

    public void selectProductBySupplyTypeAtFooter(String supplyType) {
        clickJS("click 'Free Trial' link at the bottom of page", genericTopListProduct, supplyType);
    }

    public void moveToReadyToTrySprayable() {
        Reporter.logAction("Scrolling page to link 'Ready To Try Sprayable'");

        JavascriptExecutor je = (JavascriptExecutor) driver();
        je.executeScript("arguments[0].scrollIntoView(true);", driver().findElement(divReadyToTrySprayable.getLocator()));
    }

    public void clickReadyToTrySprayable() {
        click("click div 'Im Ready To Try Sprayable'", divReadyToTrySprayable);
    }

    public void waitReadyToTrySprayableDisappear() {
        waitForInvisibility("waiting for div 'Im Ready To Try Sprayable' disappear", divReadyToTrySprayable);
    }
}