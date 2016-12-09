package co.sprayable.sleep.actions;

import co.sprayable.sleep.pages.Pages;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;
import qa.util.Constants;
import qa.util.base.BaseActions;

public class GetFreeTrialActions extends BaseActions {

    public GetFreeTrialActions() {}

    public void checkPageScrolling() {
        JavascriptExecutor executor = (JavascriptExecutor) driver();
        Long startOffset = (Long) executor.executeScript("return window.pageYOffset;");

        Pages.getFreeTrialPage().clickLinkClaimFreeSampleTop();

        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);

        Long afterScrollingDownOffset = (Long) executor.executeScript("return window.pageYOffset;");

        Reporter.log("startOffset = " + startOffset + "; afterScrollingDownOffset = " + afterScrollingDownOffset);

        Assert.assertFalse(startOffset.equals(afterScrollingDownOffset), "Expected startOffset = " + startOffset + " is not equal to afterScrollingDownOffset = " + afterScrollingDownOffset);
    }
}