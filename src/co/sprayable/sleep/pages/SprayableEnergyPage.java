package co.sprayable.sleep.pages;

import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;

public class SprayableEnergyPage extends BasePage {

    private Locator linkAddToCart = new Locator(LocatorTypes.XPATH, "//a[contains(@class, 'btnQuantityAdd')]");
    private Locator linkAOrderNow = new Locator(LocatorTypes.XPATH, "//section[@class='contact-block']//a");

    public void clickLinkAddToCart() {
        waitToBeClickable("waiting for 'Add To Cart' button become clickable", linkAddToCart);
        click("click 'Add To Cart' button", linkAddToCart);
    }

    public void waitLinkAddToCartDisappear() {
        waitForInvisibility("wait for 'Add To Cart' disappear", linkAddToCart);
    }

    public void clickLinkOrderNow() {
        waitToBeClickable("waiting for 'Order Now' link become clickable", linkAOrderNow);
        click("click link 'Order Now'", linkAOrderNow);
    }
}