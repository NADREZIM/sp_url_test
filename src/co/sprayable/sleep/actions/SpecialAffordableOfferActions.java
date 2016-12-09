package co.sprayable.sleep.actions;

import co.sprayable.sleep.pages.Pages;
import org.testng.Assert;
import qa.util.Constants;
import qa.util.base.BaseActions;

public class SpecialAffordableOfferActions extends BaseActions {

    public SpecialAffordableOfferActions() {}

    public void checkVideoPlaying() {
        driver().switchTo().defaultContent();
        Pages.specialAffordableOfferPage().clickLargePlay();
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);

        driver().switchTo().defaultContent();
        Assert.assertTrue(Pages.specialAffordableOfferPage().isVideoPlaying());

        driver().switchTo().defaultContent();
        Pages.specialAffordableOfferPage().clickPause();

        driver().switchTo().defaultContent();
        Assert.assertTrue(Pages.specialAffordableOfferPage().isVideoNotPlaying());
    }

    public void performAddressLineHovering() {
        driver().switchTo().defaultContent();
        Pages.specialAffordableOfferPage().waitBody();
        Pages.specialAffordableOfferPage().moveToPage();
        Pages.specialAffordableOfferPage().moveToAddressLine();
        Pages.specialAffordableOfferPage().clickLinkGetMyDiscount();
    }
}