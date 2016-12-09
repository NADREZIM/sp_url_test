package co.sprayable.sleep.tests;

import co.sprayable.sleep.actions.Actions;
import co.sprayable.sleep.data.OrderData;
import co.sprayable.sleep.pages.Pages;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.util.Constants;
import qa.util.base.BaseTest;

public class OldStyle2V1 extends BaseTest {

    private OrderData orderData = new OrderData();

    @BeforeClass
    private void genTestData() {
        orderData = orderData.generateOrderData();
    }

    @Test
    public void testFirstOldStyle2V1 () {
        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.GET_SLEEP_TWO_URL);

        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);

        Actions.getSleepTwoActions().performShowMeFreeTrialActivity();

        Pages.getSleepTwoPage().waitLinkShowMeFreeTrialDisappear();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.ORDER_FREE_TRIAL_URL), "Expected URL: " + Constants.ORDER_FREE_TRIAL_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);
        Actions.orderFreeTrialActions().checkPageScrolling();

        //Pages.orderFreeTrialPage().waitSelectProduct(Constants.FREE_TRIAL_SUPPLY);
        Pages.orderFreeTrialPage().selectProductBySupplyType(Constants.FREE_TRIAL_SUPPLY);

        Pages.orderFreeTrialPage().waitReadyToTrySprayableDisappear();

        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.CHECKOUT_URL), "Expected URL: " + Constants.CHECKOUT_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Actions.checkoutAction().checkOutOrder(orderData);
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.SPECIAL_OFFERS_URL), "Expected URL: " + Constants.SPECIAL_OFFERS_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Pages.specialOffersPage().clickAddToMyOrderButton();
        Assert.assertTrue(Pages.thankyouPage().isConfirmOrderMessagePressent(), "Thank you page is not opened.");
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.THANK_YOU_URL), "Expected URL: " + Constants.THANK_YOU_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
    }

    @Test
    public void testSecondOldStyle2V1 () {
        orderData = orderData.generateOrderData();

        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.GET_SLEEP_TWO_URL);

        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);

        Actions.getSleepTwoActions().performShowMeFreeTrialActivity();

        Pages.getSleepTwoPage().waitLinkShowMeFreeTrialDisappear();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.ORDER_FREE_TRIAL_URL), "Expected URL: " + Constants.ORDER_FREE_TRIAL_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);
        Actions.orderFreeTrialActions().checkPageScrolling();

        //Pages.orderFreeTrialPage().waitSelectProduct(Constants.FREE_TRIAL_SUPPLY);
        Pages.orderFreeTrialPage().selectProductBySupplyTypeAtFooter(Constants.FREE_TRIAL_SUPPLY);

        Pages.orderFreeTrialPage().waitReadyToTrySprayableDisappear();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.CHECKOUT_URL), "Expected URL: " + Constants.CHECKOUT_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Actions.checkoutAction().checkOutOrder(orderData);
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.SPECIAL_OFFERS_URL), "Expected URL: " + Constants.SPECIAL_OFFERS_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Pages.specialOffersPage().clickAddToMyOrderButton();
        Assert.assertTrue(Pages.thankyouPage().isConfirmOrderMessagePressent(), "Thank you page is not opened.");
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.THANK_YOU_URL), "Expected URL: " + Constants.THANK_YOU_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
    }
}