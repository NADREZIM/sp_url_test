package co.sprayable.sleep.pages;

import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;

public class CureYourInsomniaPage extends BasePage {

    private Locator cureYourInsomniaQuizButton = new Locator(LocatorTypes.XPATH, "//*[@id='tve_editor']/div[3]/span/a/img");

    protected CureYourInsomniaPage() {}

    public void clickCureYourInsomniaButton() {
        waitForVisibility("Wait for 'Click Here to Take the Quiz' button", cureYourInsomniaQuizButton);
        click("Click 'Click Here to Take the Quiz' button", cureYourInsomniaQuizButton);
    }
}