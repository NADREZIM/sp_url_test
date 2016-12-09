package co.sprayable.sleep.actions;

import co.sprayable.sleep.data.OrderData;
import co.sprayable.sleep.pages.Pages;
import qa.util.Random;
import qa.util.base.BaseActions;

public class PowerfulFoodsActions extends BaseActions {

    public PowerfulFoodsActions() {}

    public void enableAndCloseModalEmailWindow() {
        Pages.powerfulFoodsToFallAsleep().waitBody();
        Pages.powerfulFoodsToFallAsleep().moveToPage();
        Pages.powerfulFoodsToFallAsleep().moveToAddressLine();
        Pages.powerfulFoodsToFallAsleep().clickLinkCloseModal();
    }

    public void fillModalEmailWindow(OrderData orderData) {
        Pages.powerfulFoodsToFallAsleep().waitBody();
        Pages.powerfulFoodsToFallAsleep().moveToPage();
        Pages.powerfulFoodsToFallAsleep().moveToAddressLine();
        Pages.powerfulFoodsToFallAsleep().enterFirstName(orderData.getFirstName().replaceFirst("t", "T"));
        Pages.powerfulFoodsToFallAsleep().enterEmail(Random.genEmail());
        Pages.powerfulFoodsToFallAsleep().clickInputEmailMeNow();
    }

    public void clickDownloadNow() {
        Pages.powerfulFoodsToFallAsleep().clickImgDownloadButton();
    }

    public void clickLearnMore() {
        Pages.powerfulFoodsToFallAsleep().clickImgLearnMoreButton();
    }

    public void clickLearnMoreBelowButton() {
        Pages.powerfulFoodsToFallAsleep().clickImgLearnMoreBelowButton();
    }

    public void clickIWantToTryItNow() {
        Pages.powerfulFoodsToFallAsleep().clickLinkIWantToTryItNow();
    }
}