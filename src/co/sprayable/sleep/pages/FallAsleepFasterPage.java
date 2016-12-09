package co.sprayable.sleep.pages;

import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;

import java.awt.*;

public class FallAsleepFasterPage extends BasePage {

    protected FallAsleepFasterPage() {}

    private Locator addToCart = new Locator(LocatorTypes.XPATH, "//div[@class='action-wrapper']//span[contains(@class,'button')]");
    private Locator yesPlease = new Locator(LocatorTypes.XPATH, "//div[@class='modalContent']//a[contains(@class,'btn-danger')]");
    private Locator noThanks = new Locator(LocatorTypes.XPATH, "//div[contains(@class,'improve-sleep')]//span[contains(@class,'refuse-offer')]");
    private Locator trialConfirm = new Locator(LocatorTypes.XPATH, "//div[@class='modalContent']//span[contains(@class,'btn-danger')]");
    private Locator addOneTime = new Locator(LocatorTypes.XPATH, "//div[@id='modalStep2']//a[contains(@class,'btn-danger')]");

    public void clickAddToCart() {
        waitToBeClickable("Waiting for 'Add to Cart' button become clickable", addToCart);
        click("Clicking 'Add to Cart' button", addToCart);
    }

    public void clickYesPleaseButton() {
        waitToBeClickable("Waiting for Yes, please' button become clickable", yesPlease);
        click("Clicking Yes, Please button", yesPlease);
    }

    public void clickNoThanksButton() throws InterruptedException, AWTException {
//        clickEmptyPlace();
        waitToBeClickable("Waiting for 'No, Thanks' link become clickable", noThanks);
        clickJS("Clicking No, Thanks link", noThanks);
    }

    public void clickSetMonthTrial(){
        waitToBeClickable("Waiting for 'set month trial' button become clickable", trialConfirm);
        click("Clicking Set month trial button", trialConfirm);
    }

    public void clickAddOneTime(){
        waitToBeClickable("Waiting for 'Add one time special' button become clickable", addOneTime);
        click("Clicking Add one time special button", addOneTime);
    }
}