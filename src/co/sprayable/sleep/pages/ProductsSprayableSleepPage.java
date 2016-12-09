package co.sprayable.sleep.pages;

import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;

public class ProductsSprayableSleepPage extends BasePage {

    private Locator linkTrySprayableSleepTop = new Locator(LocatorTypes.XPATH, "//section[contains(@class, 'product-block')]//button[contains(@class, 'btn-danger')]");
    private Locator linkTrySprayableSleepFooter = new Locator(LocatorTypes.XPATH, "//section[@class='contact-block']//button[contains(@class, 'btn-danger')]");

    public void clickLinkTrySprayableSleepTop() {
        waitToBeClickable("waiting for link 'try sprayable sleep for just $1' at the top become clickable", linkTrySprayableSleepTop);
        click("click link 'try sprayable sleep for just $1' at the top", linkTrySprayableSleepTop);
    }

    public void waitLinkTrySprayableSleepTopDisappear() {
        waitForInvisibility("waiting for link 'try sprayable sleep for just $1' disappear", linkTrySprayableSleepTop);
    }

    public void clickLinkTrySprayableSleepFooter() {
        waitToBeClickable("waiting for link 'try sprayable sleep for just $1' at the footer become clickable", linkTrySprayableSleepFooter );
        click("click link 'try sprayable sleep for just $1' at the footer", linkTrySprayableSleepFooter );
    }
}