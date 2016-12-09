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

public class Funnel2 extends BaseTest {

    private QuizData quizData = new QuizData();
    private OrderData orderData = new OrderData();
    private int sampleType = 0;

    @BeforeClass
    private void genTestData() {
        quizData = quizData.generateQuizData();
        orderData = orderData.generateOrderData();
    }

    @Test
    public void funnelTestTwo() throws InterruptedException {
        Actions.mainActions().clearSession();
        Actions.mainActions().openSecondHomePage();
        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);

        Actions.takeSleepTypeQuizAction().takeSleepTypeQuiz(quizData, false);

        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.TYPE_OFFER_SAVE_URL), "Expected URL: " + Constants.TYPE_OFFER_SAVE_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Pages.sleepTypeDiscountOfferPage().clickLearnMoreButton();

        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.DISCOUNT_OFFER_URL), "Expected URL: " + Constants.DISCOUNT_OFFER_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Pages.discountOfferPage().clickGetMyFreeSampleButton();
//        sampleType = Pages.discountOfferPage().clickGetSampleProduct();
        Pages.discountOfferPage().clickGetSampleProduct();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.CHECKOUT_URL), "Expected URL: " + Constants.CHECKOUT_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);
        Actions.checkoutAction().checkOutOrder(orderData);

        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.SPECIAL_OFFERS_URL), "Expected URL: " + Constants.SPECIAL_OFFERS_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        if (sampleType > 1) {
            Pages.specialOffersPage().clickConfirmMyOriginalOrder();
        } else {
            Pages.specialOffersPage().clickAddToMyOrderButton();
//        }

            Assert.assertTrue(Pages.thankyouPage().isConfirmOrderMessagePressent(), "Thank you page is not opened.");
            Assert.assertTrue(driver().getCurrentUrl().contains(Constants.THANK_YOU_URL), "Expected URL: " + Constants.THANK_YOU_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        }
    }
}