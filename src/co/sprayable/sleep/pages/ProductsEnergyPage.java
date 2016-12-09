package co.sprayable.sleep.pages;

import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;

public class ProductsEnergyPage extends BasePage {

    private Locator linkAddToCart = new Locator(LocatorTypes.XPATH, "//a[contains(@class, 'btn-danger')]");

    public void clickLinkAddToCart() {
        waitToBeClickable("waiting for link 'Add To Cart' become clickable", linkAddToCart);
        click("click link 'Add To Cart'", linkAddToCart);
    }

    public void waitLinkAddToCartDisappear() {
        waitForInvisibility("waiting for link 'Add To Cart' disappear", linkAddToCart);
    }
}
