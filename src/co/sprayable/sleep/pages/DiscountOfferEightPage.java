package co.sprayable.sleep.pages;

import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;

public class DiscountOfferEightPage extends BasePage {

    private Locator linkGetMyBottle = new Locator(LocatorTypes.XPATH, "//div[@class='container']//div[@class='get-free-sample-wrapper']/a[@alt='GET MY $10 BOTTLE']");
    private Locator linkGetMyBottleNow = new Locator(LocatorTypes.XPATH, "//div[@class='pay-button-wrapper']/a[contains(@class, 'pay-button')]");

    public void clickLinkGetMyBottle() {
        waitToBeClickable("waiting for link 'CLICK HERE TO GET YOUR $10 BOTTLE NOW' become clickable", linkGetMyBottle);
        click("click link 'CLICK HERE TO GET YOUR $10 BOTTLE NOW'", linkGetMyBottle);
    }

    public void clickLinkGetMyBottleNow() {
        click("click link 'Get My $10 Bottle Now'", linkGetMyBottleNow);
    }

    public void waitLinkGetMyBottleDisappear() {
        waitForInvisibility("waiting for link 'CLICK HERE TO GET YOUR $10 BOTTLE NOW' become invisible'", linkGetMyBottle);
    }
}