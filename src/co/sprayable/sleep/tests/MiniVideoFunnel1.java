package co.sprayable.sleep.tests;

import co.sprayable.sleep.actions.Actions;
import co.sprayable.sleep.data.OrderData;
import co.sprayable.sleep.pages.Pages;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.util.Constants;
import qa.util.base.BaseTest;

public class MiniVideoFunnel1 extends BaseTest {

    private OrderData orderData = new OrderData();

    @BeforeClass
    private void genTestData() {
        orderData = orderData.generateOrderData();
    }

    @Test
    public void testMiniVideoFunnel1() {
        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.SPRAYABLE_SLEEP_LIMITED_TIME_OFFER_URL);

        Actions.limitedTimeOfferActions().checkVideoPlaying();

        Actions.mainActions().openPage(Constants.SPRAYABLE_SLEEP_LIMITED_TIME_OFFER_URL);
        Actions.limitedTimeOfferActions().performAddressLineHovering();
        Pages.limitedTimeOfferPage().waitLinkGetMyDiscountDisappear();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.SLEEP_SPRAYABLE_VIP_URL), "Expected URL: " + Constants.SLEEP_SPRAYABLE_VIP_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Actions.mainActions().openPage(Constants.SPRAYABLE_SLEEP_LIMITED_TIME_OFFER_URL);
        Actions.limitedTimeOfferActions().clickIWantMyFreeSample();

        Pages.limitedTimeOfferPage().waitLinkGetMyDiscountDisappear();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.CHECKOUT_URL), "Expected URL: " + Constants.CHECKOUT_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Actions.checkoutAction().checkOutOrder(orderData);
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.SPECIAL_OFFERS_URL), "Expected URL: " + Constants.SPECIAL_OFFERS_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Pages.specialOffersPage().clickAddToMyOrderButton();
        Assert.assertTrue(Pages.thankyouPage().isConfirmOrderMessagePressent(), "Thank you page is not opened.");
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.THANK_YOU_URL), "Expected URL: " + Constants.THANK_YOU_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
    }
}