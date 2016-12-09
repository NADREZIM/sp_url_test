package co.sprayable.sleep.actions;

import co.sprayable.sleep.pages.Pages;
import org.testng.Assert;
import qa.util.Constants;
import qa.util.base.BaseActions;

public class LimitedTimeOfferActions extends BaseActions {

    public LimitedTimeOfferActions() {}

    public void checkVideoPlaying() {
        driver().switchTo().defaultContent();
        Pages.limitedTimeOfferPage().clickLargePlay();
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);

        driver().switchTo().defaultContent();
        Assert.assertTrue(Pages.limitedTimeOfferPage().isVideoPlaying());

        driver().switchTo().defaultContent();
        Pages.limitedTimeOfferPage().clickPause();

        driver().switchTo().defaultContent();
        Assert.assertTrue(Pages.limitedTimeOfferPage().isVideoNotPlaying());
    }

    public void performAddressLineHovering() {
        driver().switchTo().defaultContent();
        Pages.limitedTimeOfferPage().waitBody();
        Pages.limitedTimeOfferPage().moveToPage();
        Pages.limitedTimeOfferPage().moveToAddressLine();
        Pages.limitedTimeOfferPage().clickLinkGetMyDiscount();
    }

    public void clickIWantMyFreeSample() {
        Pages.limitedTimeOfferPage().clickLinkIWantMyFreeSample();
    }
}