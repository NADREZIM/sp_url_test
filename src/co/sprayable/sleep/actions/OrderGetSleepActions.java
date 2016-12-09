package co.sprayable.sleep.actions;

import co.sprayable.sleep.pages.Pages;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;
import qa.util.Constants;
import qa.util.base.BaseActions;

public class OrderGetSleepActions extends BaseActions {

    OrderGetSleepActions() {}

    public void checkPageScrolling() {
        JavascriptExecutor executor = (JavascriptExecutor) driver();
        Long startOffset = (Long) executor.executeScript("return window.pageYOffset;");

        Pages.orderGetSleepPage().moveToReadyToTrySprayable();
        Long afterScrollingDownOffset = (Long) executor.executeScript("return window.pageYOffset;");

        Pages.orderGetSleepPage().clickReadyToTrySprayable();
        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);

        Long afterScrollingUpOffset = (Long) executor.executeScript("return window.pageYOffset;");

        Reporter.log("startOffset = " + startOffset + "; afterScrollingDownOffset = " + afterScrollingDownOffset + "; afterScrollingUpOffset = " + afterScrollingUpOffset);

        Assert.assertTrue(afterScrollingDownOffset > afterScrollingUpOffset, "Expected startOffset = " + startOffset + " is equal to afterScrollingUpOffset = " + afterScrollingUpOffset);
        Assert.assertFalse(startOffset.equals(afterScrollingDownOffset), "Expected startOffset = " + startOffset + " is not equal to afterScrollingDownOffset = " + afterScrollingDownOffset);
    }
}
