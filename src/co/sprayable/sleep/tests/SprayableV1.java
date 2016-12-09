package co.sprayable.sleep.tests;

import co.sprayable.sleep.actions.Actions;
import co.sprayable.sleep.data.OrderData;
import co.sprayable.sleep.pages.Pages;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.util.Constants;
import qa.util.base.BaseTest;

public class SprayableV1 extends BaseTest {

    private OrderData orderData = new OrderData();

    @BeforeClass
    private void genTestData() {
        orderData = orderData.generateOrderData();
    }

    @Test
    public void testSprayableV1 () {
        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.SPRAYABLE_URL);

        Pages.sprayablePage().clickLinkOrderNow();

        Pages.sprayablePage().waitLinkOrderNowDisappear();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.PRODUCTS_SPRAYABLE_SLEEP_URL), "Expected URL: " + Constants.PRODUCTS_SPRAYABLE_SLEEP_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Pages.productsSprayableSleepPage().clickLinkTrySprayableSleepTop();

        Pages.productsSprayableSleepPage().waitLinkTrySprayableSleepTopDisappear();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.ORDER_FREE_TRIAL_WITH_QUESTION_MARK_SAFE), "Expected URL: " + Constants.ORDER_FREE_TRIAL_WITH_QUESTION_MARK_SAFE + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Actions.mainActions().openPage(Constants.PRODUCTS_SPRAYABLE_SLEEP_URL);
        Pages.productsSprayableSleepPage().clickLinkTrySprayableSleepFooter();

        Pages.productsSprayableSleepPage().waitLinkTrySprayableSleepTopDisappear();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.ORDER_FREE_TRIAL_WITH_QUESTION_MARK), "Expected URL: " + Constants.ORDER_FREE_TRIAL_WITH_QUESTION_MARK + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Pages.orderFreeTrialWithQuestionMarkPage().selectProductBySupplyType(Constants.FREE_TRIAL_SUPPLY);

        Pages.orderFreeTrialWithQuestionMarkPage().waitSelectProductDisappear(Constants.FREE_TRIAL_SUPPLY);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.CHECKOUT_URL), "Expected URL: " + Constants.CHECKOUT_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Actions.checkoutAction().checkOutOrder(orderData);
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.SPECIAL_OFFERS_URL), "Expected URL: " + Constants.SPECIAL_OFFERS_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Pages.specialOffersPage().clickAddToMyOrderButton();
        Assert.assertTrue(Pages.thankyouPage().isConfirmOrderMessagePressent(), "Thank you page is not opened.");
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.THANK_YOU_URL), "Expected URL: " + Constants.THANK_YOU_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
    }
}