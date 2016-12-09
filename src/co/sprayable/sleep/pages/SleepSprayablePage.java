package co.sprayable.sleep.pages;

import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;

public class SleepSprayablePage extends BasePage {

    private Locator linkTryForJustOneDollar = new Locator(LocatorTypes.XPATH, "//div[@class='buttons-bar']//a");
    private Locator linkTrySprayableEnergy = new Locator(LocatorTypes.XPATH, "//div[@class='buttons-bar']//a[@title='Try Sprayable Energy']");

    public void clickLinkTryForJustOneDollar() {
        waitToBeClickable("wait for 'Try Sprayable Sleep for Just $1' button become clickable", linkTryForJustOneDollar);
        click("click 'Try Sprayable Sleep for Just $1' button", linkTryForJustOneDollar);
    }

    public void waitLinkTryForJustOneDollarDisappear() {
        waitForInvisibility("wait for 'Try Sprayable Sleep for Just $1' button become invisible", linkTryForJustOneDollar);
    }

    public void clickLinkTrySprayableEnergy() {
        waitToBeClickable("wait for 'Try Sprayable Energy' button become clickable", linkTrySprayableEnergy );
        click("click 'Try Sprayable Sleep for Just $1' button", linkTrySprayableEnergy );
    }
}