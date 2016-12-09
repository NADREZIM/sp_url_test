package co.sprayable.sleep.tests;

import co.sprayable.sleep.actions.Actions;
import co.sprayable.sleep.data.OrderData;
import co.sprayable.sleep.pages.Pages;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.util.Constants;
import qa.util.base.BaseTest;

public class NewHomepageV1 extends BaseTest {

    private OrderData orderData = new OrderData();

    @BeforeClass
    private void genTestData() {
        orderData = orderData.generateOrderData();
    }

    @Test
    public void testFirstNewHomepageV1 () {
        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.HOME_NEW_URL);

        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);

        Actions.homeNewActions().checkPageScrolling();

        Pages.homeNewPage().clickLinkShopSprayableSleep();
        Pages.homeNewPage().waitLinkShopSprayableSleepDisappear();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.PRODUCTS_SLEEP_URL), "Expected URL: " + Constants.PRODUCTS_SLEEP_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Actions.mainActions().openPage(Constants.HOME_NEW_URL);
        Pages.homeNewPage().clickLinkShopSprayableSleepFooter();
        Pages.homeNewPage().waitLinkShopSprayableSleepDisappear();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.PRODUCTS_SLEEP_URL), "Expected URL: " + Constants.PRODUCTS_SLEEP_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Actions.mainActions().openPage(Constants.HOME_NEW_URL);
        Pages.homeNewPage().clickLinkReadSprayableSleepReviews();
        Pages.homeNewPage().waitLinkShopSprayableSleepDisappear();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.PRODUCTS_SLEEP_URL), "Expected URL: " + Constants.PRODUCTS_SLEEP_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Pages.productsSleepPage().clickLinkAddToCart();

        Pages.productsSleepPage().waitLinkAddToCartDisappear();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.CHECKOUT_URL), "Expected URL: " + Constants.CHECKOUT_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Actions.checkoutAction().checkOutOrder(orderData);
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.SPECIAL_OFFERS_URL), "Expected URL: " + Constants.SPECIAL_OFFERS_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Pages.specialOffersPage().clickAddToMyOrderButton();
        Assert.assertTrue(Pages.thankyouPage().isConfirmOrderMessagePressent(), "Thank you page is not opened.");
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.THANK_YOU_URL), "Expected URL: " + Constants.THANK_YOU_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
    }
    @Test
    public void testSecondNewHomepageV1 () {
        orderData = orderData.generateOrderData();

        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.HOME_NEW_URL);

        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);

        Actions.homeNewActions().checkPageScrolling();

        Pages.homeNewPage().clickLinkShopSprayableEnergy();
        Pages.homeNewPage().waitLinkShopSprayableSleepDisappear();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.PRODUCTS_ENERGY_URL), "Expected URL: " + Constants.PRODUCTS_ENERGY_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Actions.mainActions().openPage(Constants.HOME_NEW_URL);
        Pages.homeNewPage().clickLinkShopSprayableEnergyFooter();
        Pages.homeNewPage().waitLinkShopSprayableSleepDisappear();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.PRODUCTS_ENERGY_URL), "Expected URL: " + Constants.PRODUCTS_ENERGY_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Actions.mainActions().openPage(Constants.HOME_NEW_URL);
        Pages.homeNewPage().clickLinkReadSprayableEnergyReviews();
        Pages.homeNewPage().waitLinkShopSprayableSleepDisappear();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.PRODUCTS_ENERGY_URL), "Expected URL: " + Constants.PRODUCTS_ENERGY_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Pages.productsEnergyPage().clickLinkAddToCart();

        Pages.productsEnergyPage().waitLinkAddToCartDisappear();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.CHECKOUT_URL), "Expected URL: " + Constants.CHECKOUT_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Actions.checkoutAction().checkOutOrder(orderData);
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
//        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.SPECIAL_OFFERS_URL), "Expected URL: " + Constants.SPECIAL_OFFERS_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
//        Pages.specialOffersPage().clickAddToMyOrderButton();
        Assert.assertTrue(Pages.thankyouPage().isConfirmOrderMessagePressent(), "Thank you page is not opened.");
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.THANK_YOU_URL), "Expected URL: " + Constants.THANK_YOU_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
    }
}