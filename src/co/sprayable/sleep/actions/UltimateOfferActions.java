package co.sprayable.sleep.actions;

import co.sprayable.sleep.pages.Pages;
import org.testng.Assert;
import qa.util.Constants;
import qa.util.base.BaseActions;

public class UltimateOfferActions extends BaseActions {

    public UltimateOfferActions() {}

    public void checkVideoPlaying() {
        driver().switchTo().defaultContent();
        Pages.ultimateOfferPage().clickLargePlay();
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);

        driver().switchTo().defaultContent();
        Assert.assertTrue(Pages.ultimateOfferPage().isVideoPlaying());

        driver().switchTo().defaultContent();
        Pages.ultimateOfferPage().clickPause();

        driver().switchTo().defaultContent();
        Assert.assertTrue(Pages.ultimateOfferPage().isVideoNotPlaying());
    }

    public void performAddressLineHovering() {
        driver().switchTo().defaultContent();
        Pages.ultimateOfferPage().waitBody();
        Pages.ultimateOfferPage().moveToPage();
        Pages.ultimateOfferPage().moveToAddressLine();
        Pages.ultimateOfferPage().clickLinkGetMyDiscount();
    }

    public void clickIWantMyFreeSample() {
        Pages.ultimateOfferPage().clickLinkIWantMyFreeSample();
    }
}