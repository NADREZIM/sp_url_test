package co.sprayable.sleep.actions;

import co.sprayable.sleep.data.OrderData;
import co.sprayable.sleep.pages.Pages;
import qa.util.Random;
import qa.util.base.BaseActions;

public class CheatSheetActions extends BaseActions {

    public CheatSheetActions() {}

    public void performDownload(OrderData orderData) {
        Pages.cheatSheetPage().clickLinkDownloadCheatSheet();
        Pages.cheatSheetPage().enterFirstName(orderData.getFirstName().replaceFirst("t", "T"));
        Pages.cheatSheetPage().enterEmail(Random.genEmail());
        Pages.cheatSheetPage().clickDownloadNow();
    }
}