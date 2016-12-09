package co.sprayable.sleep.pages;

import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;

public class CheatSheetPage extends BasePage {

    private Locator linkDownloadCheatSheet = new Locator(LocatorTypes.XPATH, "//section[@class='big_green_button']//a[@class='big-green']");
    private Locator inputFirstName = new Locator(LocatorTypes.XPATH, "//input[@id='inf_field_FirstName']");
    private Locator inputEmail = new Locator(LocatorTypes.XPATH, "//input[@id='inf_field_Email']");
    private Locator inputDownloadNow = new Locator(LocatorTypes.XPATH, "//input[@id='download']");

    public void waitLinkDownloadCheatSheet() {
        waitForVisibility("waiting for 'Download The Ultimate Insomnia Cheat Sheet' button become visible", linkDownloadCheatSheet);
    }

    public void clickLinkDownloadCheatSheet() {
        waitToBeClickable("waiting for 'Download The Ultimate Insomnia Cheat Sheet' button become clickable", linkDownloadCheatSheet);
        click("waiting for 'Download The Ultimate Insomnia Cheat Sheet' button become present", linkDownloadCheatSheet);
    }

    public void enterFirstName(String firstName) {
        type("type in 'first name' input", firstName, inputFirstName);
    }

    public void enterEmail(String email) {
        type("type in 'first name' input", email, inputEmail);
    }

    public void clickDownloadNow() {
        click("click on 'Download Now' button", inputDownloadNow);
    }
}