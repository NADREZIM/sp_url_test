package co.sprayable.sleep.actions;

import co.sprayable.sleep.pages.Pages;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import qa.util.Constants;
import qa.util.base.BaseActions;

public class HomeNewActions extends BaseActions {

    public HomeNewActions() {}

    public void checkPageScrolling() {
        JavascriptExecutor executor = (JavascriptExecutor) driver();
        Long startOffset = (Long) executor.executeScript("return window.pageYOffset;");

        Pages.homeNewPage().clickLinkArrowDown();
        Long afterClickArrowDownOffset = (Long) executor.executeScript("return window.pageYOffset;");

        Assert.assertTrue(startOffset.compareTo(afterClickArrowDownOffset) < 0, "Expected startOffset = " + startOffset + " is less than afterClickArrowDownOffset = " + afterClickArrowDownOffset);
    }

    public void performShowMeFreeTrialActivity() {
        Pages.homeNewPage().waitBody();
        Pages.homeNewPage().moveToPage();
        Pages.homeNewPage().moveToAddressLine();
        Pages.homeNewPage().clickLinkShowMeFreeTrial();
    }
}