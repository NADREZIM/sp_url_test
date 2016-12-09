package co.sprayable.sleep.pages;

import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;

public class TrySprayableSleepFirstMonthOneDollarPage extends BasePage {

    private Locator linkTakeTheFirstMonth = new Locator(LocatorTypes.XPATH, "//a[@class='pay-original-button']");

    public void clickLinkTakeTheFirstMonth() {
        waitToBeClickable("waiting for link 'Okay, I’ll Take The First-Month-Free Offer' become clickable", linkTakeTheFirstMonth);
        clickJS("click link 'Okay, I’ll Take The First-Month-Free Offer'", linkTakeTheFirstMonth);
    }

    public void waitLinkTakeTheFirstMonthDisappear() {
        waitForInvisibility("waiting for link 'Okay, I’ll Take The First-Month-Free Offer' disappears", linkTakeTheFirstMonth);
    }
}