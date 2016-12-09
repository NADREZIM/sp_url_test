package co.sprayable.sleep.tests;

import co.sprayable.sleep.actions.Actions;
import co.sprayable.sleep.data.OrderData;
import co.sprayable.sleep.pages.Pages;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.util.Constants;
import qa.util.base.BaseTest;

import java.awt.*;

public class Funnel8 extends BaseTest {

    private OrderData orderData = new OrderData();

    @BeforeClass
    private void genTestData() {
        orderData = orderData.generateOrderData();
    }

    @Test
    public void funnelTestEight() {
        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.FALL_ASLEEP_FASTER_URL);
        Pages.fallAsleepFasterPage().clickAddToCart();
        Pages.fallAsleepFasterPage().clickYesPleaseButton();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.CHECKOUT_URL), "Expected URL: " + Constants.CHECKOUT_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);
        Actions.checkoutAction().checkOutOrder(orderData);
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.SPECIAL_OFFERS_URL), "Expected URL: " + Constants.SPECIAL_OFFERS_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Pages.specialOffersPage().clickAddToMyOrderButton();
        Assert.assertTrue(Pages.thankyouPage().isConfirmOrderMessagePressent(), "Thank you page is not opened.");
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.THANK_YOU_URL), "Expected URL: " + Constants.THANK_YOU_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
    }

    @Test
    public void funnelTestEightNoThanksV2() throws AWTException, InterruptedException {
        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.FALL_ASLEEP_FASTER_URL);
        Pages.fallAsleepFasterPage().clickNoThanksButton();
        Pages.fallAsleepFasterPage().clickSetMonthTrial();
        Pages.fallAsleepFasterPage().clickAddOneTime();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.CHECKOUT_URL), "Expected URL: " + Constants.CHECKOUT_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);
        Actions.checkoutAction().checkOutOrder(orderData);
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.SPECIAL_OFFERS_URL), "Expected URL: " + Constants.SPECIAL_OFFERS_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Pages.specialOffersPage().clickAddToMyOrderButton();
        Assert.assertTrue(Pages.thankyouPage().isConfirmOrderMessagePressent(), "Thank you page is not opened.");
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.THANK_YOU_URL), "Expected URL: " + Constants.THANK_YOU_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
    }
}