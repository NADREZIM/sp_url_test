package co.sprayable.sleep.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import qa.util.Constants;
import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;
import qa.util.reporting.Reporter;

import java.awt.*;

public class GetsSleepPage extends BasePage {

    private Locator body = new Locator(LocatorTypes.XPATH, "//body");
    private Locator linkClaimSampleTop = new Locator(LocatorTypes.XPATH, "//a[img[@alt='Claim Sample']]");
    private Locator claimForm = new Locator(LocatorTypes.XPATH, "//div[@class='claim-form-container']/form");
    private Locator divReadyToTrySprayable = new Locator(LocatorTypes.XPATH, "//div[@class='buttons']/div[contains(@class, 'btnBuy ')]");
    private Locator linkShowMeFreeTrial = new Locator(LocatorTypes.XPATH, "//div[@class='modal-buttons']//a[contains(@class, 'btn-yellow')]");
    private Locator firstNameField = claimForm.concat(new Locator(LocatorTypes.XPATH, "//input[@name='first_name']"));
    private Locator genderSelector = claimForm.concat(new Locator(LocatorTypes.XPATH, "//select[@name='gender']"));
    private Locator ageSelector = claimForm.concat(new Locator(LocatorTypes.XPATH, "//select[@name='age']"));
    private Locator zipCodeField = claimForm.concat(new Locator(LocatorTypes.XPATH, "//input[@name='zip_code']"));

    private Locator linkClaimSampleBottom = new Locator(LocatorTypes.XPATH, "//input[contains(@src, 'claim-button2')]");
    private Locator claimSampleSubmitFormButton = claimForm.concat(new Locator(LocatorTypes.XPATH,
            "//div[contains(@class, 'submit-container')]//input"));
    private Locator oneMonthSupply = new Locator(LocatorTypes.XPATH, "//div[div[@class='header']//div[contains(.,'1 Month')]]//a");

    protected GetsSleepPage() {}

//    public void waitToBeLoaded() {
//        waitForVisibility("Wait 'Claim Sample' become visible", claimSampleButton);
//    }

    public void clickClaimSampleButton() {
        waitToBeClickable("waiting for 'Claim Sample' link become clickable", linkClaimSampleTop);
        click("Click 'Claim Sample' button", linkClaimSampleTop);
    }

    public void clickClaimSampleSecondButton() {
        waitToBeClickable("Wait 'Claim Sample' button to be clickable", linkClaimSampleBottom);
        clickJS("Click 'Claim Sample' button again", linkClaimSampleBottom);
    }

    public void waitClaimSampleButtonDisappear() {
        waitForInvisibility("waiting for button 'Claim You Free 10-Day Sample' disappear", linkClaimSampleTop);
    }

    public void waitBody() {
        waitForPresence("waiting for 'body' presents", body);
        co.sprayable.sleep.actions.Actions.mainActions().wait(Constants.MICRO_TIMEOUT_SECONDS);
    }

    public void moveToAddressLine() {
        Reporter.logAction("Moving cursor to address line");

        WebElement elemBody = driver().findElement(body.getLocator());

        int x = elemBody.getSize().getWidth() / Constants.BODY_WITH_DIVIDER;

        try {
            new Robot().mouseMove(x, 0);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void moveToPage() {
        Reporter.logAction("Moving cursor to page");

        WebElement elemBody = driver().findElement(body.getLocator());

        int xShift = elemBody.getSize().getWidth() / Constants.BODY_WITH_DIVIDER;

        try {
            new Robot().mouseMove(driver().manage().window().getPosition().getX() + xShift, driver().manage().window().getPosition().getY() + Constants.Y_SHIFT);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void waitReadyToTrySprayableDisappear() {
        waitForInvisibility("waiting for div 'Im Ready To Try Sprayable' disappear", divReadyToTrySprayable);
    }

    public void waitLinkShowMeFreeTrialDisappear() {
        waitForInvisibility("waiting for link 'Show me the FREE trial offer', disappear", linkShowMeFreeTrial);
    }

    public void clickLinkShowMeFreeTrial() {
        waitToBeClickable("waiting for link 'Show me the FREE trial offer' become clickable", linkShowMeFreeTrial);
        click("click link 'Show me the FREE trial offer'", linkShowMeFreeTrial);
    }

//    public void clickOneMonthSupply(){
//        click("Clicking One Month Supply button", oneMonthSupply);
//    }
//
//    public void waitClaimForm() {
//        waitForVisibility("Wait 'Claim form' to be loading", claimForm);
//    }
//
//    public void setFirstName(String firstName) {
//        type("Set 'First Name' " + firstName, firstName, firstNameField);
//    }
//
//    public void setGender(String genderType) {
//        selectDropDownListOptionByText("Set gender " + genderType, genderType, genderSelector);
//    }
//
//    public void setAge(int age) {
//        selectDropDownListOptionByText("Set gender " + age, String.valueOf(age), ageSelector);
//    }
//
//    public void setZipCode(int zipCode) {
//        type("Set 'Zip Code' " + zipCode, String.valueOf(zipCode), zipCodeField);
//    }
//
//    public void clickClaimSampleSubmitFormButton() {
//        click("Click 'Claim Sample' button (submit form)", claimSampleSubmitFormButton);
//    }
}