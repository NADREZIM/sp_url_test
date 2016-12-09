package co.sprayable.sleep.pages;

import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;

public class FreeTrialPage extends BasePage {

    private Locator linkOrderNow = new Locator(LocatorTypes.XPATH, "//div[contains(@class, 'vsl-lower-button')]/div[contains(@class, 'btnBuy')]");

    public void clickLinkOrderNow() {
        waitToBeClickable("wait for button 'Order Now' become clickable", linkOrderNow);
        click("click button 'Order Now'", linkOrderNow);
    }

    public void waitLinkOrderNowDisappear() {
        waitForInvisibility("wait until 'Order Now' button disappears", linkOrderNow);
    }
}