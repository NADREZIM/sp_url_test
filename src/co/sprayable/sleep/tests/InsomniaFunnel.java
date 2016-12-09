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

public class InsomniaFunnel extends BaseTest {

    private QuizData quizData = new QuizData();
    private OrderData orderData = new OrderData();

    @BeforeClass
    private void genTestData() {
        quizData = quizData.generateQuizData();
        orderData = orderData.generateOrderData();
    }

    @Test
    public void insomniaFunnelTest() {
        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.POWERFUL_FOODS_TO_FALL_ASLEEP_URL);
        Actions.powerfulFoodsActions().enableAndCloseModalEmailWindow();
        Assert.assertFalse(Pages.powerfulFoodsToFallAsleep().isCheatSheetModalPresent(), "Modal window 'Want our Insomnia Cheat Sheet...' is still present");

        Actions.mainActions().refreshPage();
        //Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);
        Actions.powerfulFoodsActions().fillModalEmailWindow(orderData);
        Pages.cheatSheetThankYouPage().waitLinkDownloadNow();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.INSOMNIA_CHEAT_SHEET_THANK_YOU_URL), "Expected URL: " + Constants.INSOMNIA_CHEAT_SHEET_THANK_YOU_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Actions.mainActions().openPage(Constants.POWERFUL_FOODS_TO_FALL_ASLEEP_URL);
        Actions.powerfulFoodsActions().clickDownloadNow();
        Pages.cheatSheetPage().waitLinkDownloadCheatSheet();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.DOWNLOAD_INSOMNIA_CHEAT_SHEET_URL), "Expected URL: " + Constants.DOWNLOAD_INSOMNIA_CHEAT_SHEET_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Actions.mainActions().openPage(Constants.POWERFUL_FOODS_TO_FALL_ASLEEP_URL);
        Actions.powerfulFoodsActions().clickLearnMore();
        Pages.powerfulFoodsToFallAsleep().waitForInvisibilityImgLearnMoreButton();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.SPRAYABLE_SLEEP_ULTIMATE_OFFER_URL), "Expected URL: " + Constants.SPRAYABLE_SLEEP_ULTIMATE_OFFER_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        //open href in a new window
        Actions.mainActions().openPage(Constants.POWERFUL_FOODS_TO_FALL_ASLEEP_URL);
        Actions.powerfulFoodsActions().clickLearnMoreBelowButton();
        Actions.mainActions().switchToNewWindow();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.SPRAYABLE_SLEEP_ULTIMATE_OFFER_URL), "Expected URL: " + Constants.SPRAYABLE_SLEEP_ULTIMATE_OFFER_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Actions.mainActions().openPage(Constants.POWERFUL_FOODS_TO_FALL_ASLEEP_URL);
        Actions.powerfulFoodsActions().clickIWantToTryItNow();
        Pages.powerfulFoodsToFallAsleep().waitForInvisibilityImgLearnMoreButton();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.SPRAYABLE_SLEEP_ULTIMATE_OFFER_URL), "Expected URL: " + Constants.SPRAYABLE_SLEEP_ULTIMATE_OFFER_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Actions.mainActions().openPage(Constants.DOWNLOAD_INSOMNIA_CHEAT_SHEET_URL);
        Actions.cheatSheetActions().performDownload(orderData);
        Pages.cheatSheetThankYouPage().waitLinkDownloadNow();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.INSOMNIA_CHEAT_SHEET_THANK_YOU_URL), "Expected URL: " + Constants.INSOMNIA_CHEAT_SHEET_THANK_YOU_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

        Actions.mainActions().openPage(Constants.INSOMNIA_CHEAT_SHEET_THANK_YOU_URL);
        Actions.cheatSheetThankYouActions().checkVideoPlaying();

        Actions.mainActions().openPage(Constants.INSOMNIA_CHEAT_SHEET_THANK_YOU_URL);
        Actions.cheatSheetThankYouActions().downloadAndOpenFile();

        Actions.mainActions().openPage(Constants.INSOMNIA_CHEAT_SHEET_THANK_YOU_URL);
        Actions.cheatSheetThankYouActions().performGetItNowLinking();
        Pages.cheatSheetThankYouPage().waitForInvisibilityLinkDownloadNow();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.SPRAYABLE_SLEEP_SPECIAL_OFFER_SAVE_URL), "Expected URL: " + Constants.SPRAYABLE_SLEEP_SPECIAL_OFFER_SAVE_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
    }
}