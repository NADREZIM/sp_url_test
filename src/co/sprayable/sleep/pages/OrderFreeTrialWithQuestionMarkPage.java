package co.sprayable.sleep.pages;

import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;

public class OrderFreeTrialWithQuestionMarkPage extends BasePage {

    private Locator topListProduct = new Locator(LocatorTypes.XPATH,
            "//div[contains(@class, 'packages')][1]//div[div[@class='header']" +
                    "//div[contains(text(), '%s')]]//div[contains(@class, 'btnSelect ')]");

    public void selectProductBySupplyType(String supplyType) {
        waitForVisibility("Wait for " + supplyType + "supply become visible", topListProduct, supplyType);
        click("Select product with " + supplyType + " supply", topListProduct, supplyType);
    }

    public void waitSelectProductDisappear (String supplyType) {
        waitForInvisibility("Wait for " + supplyType + " disappear", topListProduct, supplyType);
    }
}