package co.sprayable.sleep.tests;

import co.sprayable.sleep.actions.Actions;
import co.sprayable.sleep.data.OrderData;
import co.sprayable.sleep.data.QuizData;
import co.sprayable.sleep.pages.Pages;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.util.Constants;
import qa.util.base.BaseTest;

public class Funnel5 extends BaseTest {

    private QuizData quizData = new QuizData();
    private OrderData orderData = new OrderData();

    @BeforeClass
    private void genTestData() {
        quizData = quizData.generateQuizData();
        orderData = orderData.generateOrderData();
    }

    @Test
    public void funnelTestFive() {
        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.SLEEP_QUIZ_HELP_CURE_YOUR_INSOMNIA_URL);
        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);

        //TODO create Action for using
        Pages.cureYourInsomniaPage().clickCureYourInsomniaButton();

        for(String winHandle : driver().getWindowHandles()){
            driver().switchTo().window(winHandle);
        }

        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.THE_ULTIMATE_SLEEP_QUIZ_4U_SAFE_URL), "Expected URL: " + Constants.THE_ULTIMATE_SLEEP_QUIZ_4U_SAFE_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Actions.takeSleepTypeQuizAction().takeSleepTypeQuiz(quizData, true);

        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.THE_QUIZ_RESULT_4U_URL), "Expected URL: " + Constants.THE_QUIZ_RESULT_4U_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Pages.sleepTypeDiscountOfferPage().clickLearnMoreButton();

        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.GETS_SLEEP_SAVE_URL), "Expected URL: " + Constants.GETS_SLEEP_SAVE_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Actions.getsSleepAction().getSleepQuiz(quizData);

        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.ORDER_GETS_SLEEP_SAVE_URL), "Expected URL: " + Constants.ORDER_GETS_SLEEP_SAVE_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Pages.orderGetSleepPage().selectProductBySupplyType(Constants.FREE_TRIAL_SUPPLY);

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