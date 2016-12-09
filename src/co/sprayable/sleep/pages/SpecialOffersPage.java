package co.sprayable.sleep.pages;

import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;

public class SpecialOffersPage extends BasePage {

    private Locator addToMyOrderButton = new Locator(LocatorTypes.XPATH, "//button[@id='ucUpsellYesButtonId']");
    private Locator confirmOriginalOrder = new Locator(LocatorTypes.XPATH, "//div[@class='pay-original-button']");

    protected SpecialOffersPage() {}

    public void clickAddToMyOrderButton() {
        waitToBeClickable("Wait the 'Add to my order button' to be clickable", addToMyOrderButton);
        clickJS("Click 'Add to my order button'", addToMyOrderButton);
    }

    public void clickConfirmMyOriginalOrder() {
        waitForVisibility("Wait for visibility Confirm my original order button", confirmOriginalOrder);
        click("Clicking Confirm my Original Order Button", confirmOriginalOrder);
    }
}