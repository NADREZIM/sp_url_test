package co.sprayable.sleep.pages;

import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;

public class EnergyTrialPage extends BasePage {

    private Locator linkOrderNow = new Locator(LocatorTypes.XPATH, "//div[@class='inner-box']/a");
    private Locator linkGetMyFreeTrial = new Locator(LocatorTypes.XPATH, "//div[@class='col-lg-12']/a");

    public void clickLinkOrderNow() {
        waitToBeClickable("waiting for link 'Order Now' bicome clickable", linkOrderNow);
        click("click link 'Order Now'", linkOrderNow);
    }

    public void waitLinkOrderNowDisappear() {
        waitForInvisibility("waiting for link 'Order Now' become invisible", linkOrderNow);
    }

    public void clickLinkGetMyFreeTrial() {
        waitToBeClickable("waiting for link 'Get My FREE Trial' bicome clickable", linkGetMyFreeTrial);
        click("click link 'Get My FREE Trial'", linkGetMyFreeTrial);
    }
}