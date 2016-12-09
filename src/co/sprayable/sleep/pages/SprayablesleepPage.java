package co.sprayable.sleep.pages;

import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;

public class SprayablesleepPage extends BasePage {

    private Locator linkTrySprayableSleep = new Locator(LocatorTypes.XPATH, "//section[@id='text-4']//a");

    public void clickLinkTrySprayableSleep() {
        waitToBeClickable("waiting for link 'Try Sprayable Sleep for $1' become clickable", linkTrySprayableSleep);
        click("click link 'Try Sprayable Sleep for $1'", linkTrySprayableSleep);
    }

    public void waitLinkTrySprayableSleepDisappear() {
        waitForInvisibility("waiting for link 'Try Sprayable Sleep for $1' disapppear", linkTrySprayableSleep);
    }
}