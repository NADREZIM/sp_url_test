package co.sprayable.sleep.tests;

import co.sprayable.sleep.actions.Actions;
import co.sprayable.sleep.data.OrderData;
import co.sprayable.sleep.pages.Pages;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.util.Constants;
import qa.util.base.BaseTest;

public class MainPageFunnel1 extends BaseTest {

    private OrderData orderData = new OrderData();

    @BeforeClass
    private void genTestData() {
        orderData = orderData.generateOrderData();
    }

    @Test
    public void testMainPageFunnel1() {
        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.SLEEP_SPRAYABLE_MAIN_PAGE_URL);

        Pages.sleepSprayablePage().clickLinkTryForJustOneDollar();
        Pages.sleepSprayablePage().waitLinkTryForJustOneDollarDisappear();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.SLEEP_SPRAYABLE_VSL_URL), "Expected URL: " + Constants.SLEEP_SPRAYABLE_VSL_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Actions.sleepSprayableVslActions().checkVideoPlaying();

        Pages.sleepSprayableVslPage().clickDivOrderNow();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.ORDER_GETS_SLEEP_SAVE_URL), "Expected URL: " + Constants.ORDER_GETS_SLEEP_SAVE_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Pages.orderGetSleepPage().selectProductBySupplyType(Constants.FREE_TRIAL_SUPPLY);
        Pages.orderGetSleepPage().waitSelectProductDisappear(Constants.FREE_TRIAL_SUPPLY);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.CHECKOUT_URL), "Expected URL: " + Constants.CHECKOUT_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Actions.checkoutAction().checkOutOrder(orderData);
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.SPECIAL_OFFERS_URL), "Expected URL: " + Constants.SPECIAL_OFFERS_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Pages.specialOffersPage().clickAddToMyOrderButton();
        Assert.assertTrue(Pages.thankyouPage().isConfirmOrderMessagePressent(), "Thank you page is not opened.");
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.THANK_YOU_URL), "Expected URL: " + Constants.THANK_YOU_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
    }
}