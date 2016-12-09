package co.sprayable.sleep.actions;

import co.sprayable.sleep.pages.Pages;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import qa.util.Constants;
import qa.util.base.BaseActions;

public class SleepHackerActions extends BaseActions {

    public SleepHackerActions() {}

    public void checkPageScrolling() {
        Pages.sleepHackerPage().moveToFirstAddToCartLink();
        JavascriptExecutor executor = (JavascriptExecutor) driver();
        Long onFirstAddToCartLinkOffset = (Long) executor.executeScript("return window.pageYOffset;");

        Pages.sleepHackerPage().clickFirstAddToCartLink();
        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);
        Long afterClickOnFirstAddToCartLinkOffset = (Long) executor.executeScript("return window.pageYOffset;");

        Pages.sleepHackerPage().scrollUpThePage();

        Pages.sleepHackerPage().moveToSecondAddToCartLink();
        Long onSecondAddToCartLinkOffset = (Long) executor.executeScript("return window.pageYOffset;");

        Pages.sleepHackerPage().clickSecondAddToCartLink();
        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);
        Long afterClickOnSecondAddToCartLinkOffset = (Long) executor.executeScript("return window.pageYOffset;");

        Pages.sleepHackerPage().scrollUpThePage();

        Pages.sleepHackerPage().moveToThirdAddToCartLink();
        Long onThirdAddToCartLinkOffset = (Long) executor.executeScript("return window.pageYOffset;");

        Pages.sleepHackerPage().clickThirdAddToCartLink();
        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);
        Long afterClickOnThirdAddToCartLinkOffset = (Long) executor.executeScript("return window.pageYOffset;");

        Assert.assertTrue(afterClickOnFirstAddToCartLinkOffset.equals(afterClickOnSecondAddToCartLinkOffset) && afterClickOnSecondAddToCartLinkOffset.equals(afterClickOnThirdAddToCartLinkOffset), "Expected afterClickOnFirstAddToCartLinkOffset = " + afterClickOnFirstAddToCartLinkOffset + " is equal to afterClickOnSecondAddToCartLinkOffset = " + afterClickOnSecondAddToCartLinkOffset + " and equal to afterClickOnThirdAddToCartLinkOffset = " + afterClickOnThirdAddToCartLinkOffset);
        Assert.assertFalse(onFirstAddToCartLinkOffset.equals(onSecondAddToCartLinkOffset) && onSecondAddToCartLinkOffset.equals(onThirdAddToCartLinkOffset), "Expected onFirstAddToCartLinkOffset = " + onFirstAddToCartLinkOffset + " is not equal to onSecondAddToCartLinkOffset = " + onSecondAddToCartLinkOffset + " and not equal to onThirdAddToCartLinkOffset = " + onThirdAddToCartLinkOffset);
    }
}