package co.sprayable.sleep.actions;

import co.sprayable.sleep.pages.Pages;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import qa.util.Constants;
import qa.util.base.BaseActions;

public class SubscriberOfferActions extends BaseActions {

    public SubscriberOfferActions() {}

    public void checkPageScrolling() {
        JavascriptExecutor executor = (JavascriptExecutor) driver();
        Long startOffset = (Long) executor.executeScript("return window.pageYOffset;");

        Pages.subscriberOfferPage().moveToReadyToTrySprayable();
        Long afterScrollToReadyToTrySprayableOffset = (Long) executor.executeScript("return window.pageYOffset;");

        Pages.subscriberOfferPage().clickReadyToTrySprayable();
        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);
        Long afterClickOnReadyToTrySprayableOffset = (Long) executor.executeScript("return window.pageYOffset;");

        Pages.subscriberOfferPage().moveToOrderSprayableNow();
        Long afterScrollToOrderSprayableNowOffset = (Long) executor.executeScript("return window.pageYOffset;");

        Pages.subscriberOfferPage().clickOrderSprayableNow();
        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);
        Long afterClickOnOrderSprayableNowOffset = (Long) executor.executeScript("return window.pageYOffset;");

        Assert.assertTrue(startOffset.compareTo(afterClickOnOrderSprayableNowOffset) <= 0 && startOffset.compareTo(afterClickOnReadyToTrySprayableOffset) <= 0, "Expected startOffset = " + startOffset + " is less than or equal to afterClickOnOrderSprayableNowOffset = " + afterClickOnOrderSprayableNowOffset + " and less than or equal to afterClickOnReadyToTrySprayableOffset = " + afterClickOnReadyToTrySprayableOffset);
        Assert.assertFalse(startOffset.equals(afterScrollToReadyToTrySprayableOffset) && startOffset.equals(afterScrollToOrderSprayableNowOffset), "Expected startOffset = " + startOffset + " is not equal to afterScrollToReadyToTrySprayableOffset = " + afterScrollToReadyToTrySprayableOffset + " and not equal to afterScrollToOrderSprayableNowOffset = " + afterScrollToOrderSprayableNowOffset);
    }
}
