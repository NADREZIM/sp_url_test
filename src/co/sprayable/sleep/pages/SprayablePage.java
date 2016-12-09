package co.sprayable.sleep.pages;

import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;

public class SprayablePage extends BasePage {

    private Locator linkOrderNow = new Locator(LocatorTypes.XPATH, "//div[@class='frame']/a");
    private Locator linkOrderNowEnergy = new Locator(LocatorTypes.XPATH, "//section[@id='energy']//div[@class='btn-holder']/a");
    private Locator linkTrySprayableSleep = new Locator(LocatorTypes.XPATH, "//section[@id='sleep']//div[@class='btn-holder']//a");

    public void clickLinkOrderNow() {
        waitToBeClickable("waiting for link 'Order Now' become clickable", linkOrderNow);
        click("click link 'Order Now'", linkOrderNow);
    }

    public void clickLinkOrderNowEnergy() {
        waitToBeClickable("waiting for link 'Order Now' in energy section become clickable", linkOrderNowEnergy);
        click("click link 'Order Now' in energy section", linkOrderNowEnergy);
    }

    public void clickLinkTrySprayableSleep() {
        waitToBeClickable("waiting for link 'try sprayable sleep for just $1' become clickable", linkTrySprayableSleep);
        click("click link 'try sprayable sleep for just $1'", linkTrySprayableSleep);
    }

    public void waitLinkOrderNowDisappear() {
        waitForInvisibility("waiting for link 'Order Now' become invisible", linkOrderNow);
    }
}