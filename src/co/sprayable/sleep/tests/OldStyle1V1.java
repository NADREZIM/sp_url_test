package co.sprayable.sleep.tests;

import co.sprayable.sleep.actions.Actions;
import co.sprayable.sleep.data.OrderData;
import co.sprayable.sleep.pages.Pages;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.util.Constants;
import qa.util.base.BaseTest;

public class OldStyle1V1 extends BaseTest {

    private OrderData orderData = new OrderData();

    @BeforeClass
    private void genTestData() {
        orderData = orderData.generateOrderData();
    }

    @Test
    public void testFirstOldStyle1V1 () {
        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.GETS_SLEEP_SAVE_URL);

        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);

        Actions.getsSleepAction().checkPageScrolling();

        Pages.getsSleepPage().clickClaimSampleSecondButton();

        Pages.getsSleepPage().waitClaimSampleButtonDisappear();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.ORDER_GETS_SLEEP_SAVE_URL), "Expected URL: " + Constants.ORDER_GETS_SLEEP_SAVE_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);
        Actions.orderGetSleepActions().checkPageScrolling();

        //Pages.orderGetSleepPage().waitSelectProduct(Constants.FREE_TRIAL_SUPPLY);
        Pages.orderGetSleepPage().selectProductBySupplyType(Constants.FREE_TRIAL_SUPPLY);

        Pages.orderGetSleepPage().waitReadyToTrySprayableDisappear();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.CHECKOUT_URL), "Expected URL: " + Constants.CHECKOUT_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Actions.checkoutAction().checkOutOrder(orderData);
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.SPECIAL_OFFERS_URL), "Expected URL: " + Constants.SPECIAL_OFFERS_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Pages.specialOffersPage().clickAddToMyOrderButton();
        Assert.assertTrue(Pages.thankyouPage().isConfirmOrderMessagePressent(), "Thank you page is not opened.");
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.THANK_YOU_URL), "Expected URL: " + Constants.THANK_YOU_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
    }

    @Test
    public void testSecondOldStyle1V1 () {
        orderData = orderData.generateOrderData();
        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.GETS_SLEEP_SAVE_URL);

        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);

        Actions.getsSleepAction().checkPageScrolling();

        Pages.getsSleepPage().clickClaimSampleSecondButton();

        Pages.getsSleepPage().waitClaimSampleButtonDisappear();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.ORDER_GETS_SLEEP_SAVE_URL), "Expected URL: " + Constants.ORDER_GETS_SLEEP_SAVE_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);
        Actions.orderGetSleepActions().checkPageScrolling();

        //Pages.orderGetSleepPage().waitSelectProduct(Constants.FREE_TRIAL_SUPPLY);
        Pages.orderGetSleepPage().selectProductBySupplyTypeAtFooter(Constants.FREE_TRIAL_SUPPLY);

        Pages.orderGetSleepPage().waitReadyToTrySprayableDisappear();

        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.CHECKOUT_URL), "Expected URL: " + Constants.CHECKOUT_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Actions.checkoutAction().checkOutOrder(orderData);
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.SPECIAL_OFFERS_URL), "Expected URL: " + Constants.SPECIAL_OFFERS_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Pages.specialOffersPage().clickAddToMyOrderButton();
        Assert.assertTrue(Pages.thankyouPage().isConfirmOrderMessagePressent(), "Thank you page is not opened.");
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.THANK_YOU_URL), "Expected URL: " + Constants.THANK_YOU_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
    }
}