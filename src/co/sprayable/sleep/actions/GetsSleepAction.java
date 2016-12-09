package co.sprayable.sleep.actions;

import co.sprayable.sleep.data.QuizData;
import co.sprayable.sleep.pages.Pages;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;
import qa.util.Constants;
import qa.util.base.BaseActions;

public class GetsSleepAction extends BaseActions {

    public GetsSleepAction() {}

    public void getSleepQuiz(QuizData data) {
        //Pages.getsSleepPage().waitToBeLoaded();
        Pages.getsSleepPage().clickClaimSampleButton();
        Pages.getsSleepPage().clickClaimSampleSecondButton();
//        Pages.getsSleepPage().waitClaimForm();

//        Pages.getsSleepPage().setFirstName(data.getName());
//        //TODO
//        Pages.getsSleepPage().setGender("male");
//        Pages.getsSleepPage().setAge(data.getAge());
//        Pages.getsSleepPage().setZipCode(data.getZipCode());
//        Pages.getsSleepPage().clickClaimSampleSubmitFormButton();
    }

    public void checkPageScrolling() {
        JavascriptExecutor executor = (JavascriptExecutor) driver();
        Long startOffset = (Long) executor.executeScript("return window.pageYOffset;");

        //Pages.getsSleepPage().waitToBeLoaded();
        Pages.getsSleepPage().clickClaimSampleButton();

        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);

        Long afterScrollingDownOffset = (Long) executor.executeScript("return window.pageYOffset;");

        Reporter.log("startOffset = " + startOffset + "; afterScrollingDownOffset = " + afterScrollingDownOffset);

        Assert.assertFalse(startOffset == afterScrollingDownOffset, "Expected startOffset = " + startOffset + " is not equal to afterScrollingDownOffset = " + afterScrollingDownOffset);
    }

    public void performShowMeFreeTrialActivity() {
        Pages.getsSleepPage().waitBody();
        Pages.getsSleepPage().moveToPage();
        Pages.getsSleepPage().moveToAddressLine();
        Pages.getsSleepPage().clickLinkShowMeFreeTrial();
    }
}