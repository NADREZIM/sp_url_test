package co.sprayable.sleep.tests;

import co.sprayable.sleep.actions.Actions;
import co.sprayable.sleep.data.OrderData;
import co.sprayable.sleep.data.QuizData;
import co.sprayable.sleep.pages.Pages;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.util.Constants;
import qa.util.base.BaseTest;

public class Funnel1 extends BaseTest {

    private QuizData quizData = new QuizData();
    private OrderData orderData = new OrderData();

    @BeforeClass
    private void genTestData() {
        quizData = quizData.generateQuizData();
        orderData = orderData.generateOrderData();
    }

    @Test
    public void funnelTestOne() {
        Actions.mainActions().clearSession();
        Actions.mainActions().openHomePage();
        Actions.mainActions().wait(10);

        Actions.takeSleepTypeQuizAction().takeSleepTypeQuiz(quizData, true);

        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.TYPE_OFFER_URL), "Expected URL: " + Constants.TYPE_OFFER_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Pages.sleepTypeDiscountOfferPage().clickLearnMoreButton();

        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.DISCOUNT_OFFER_URL), "Expected URL: " + Constants.DISCOUNT_OFFER_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Pages.discountOfferPage().clickGetMyFreeSampleButton();
        Pages.discountOfferPage().clickGetSampleProduct();
        Pages.checkoutPage().waitToOrderSurvey();
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