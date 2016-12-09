package co.sprayable.sleep.actions;

import co.sprayable.sleep.pages.Pages;
import org.testng.Assert;
import qa.util.Constants;
import qa.util.base.BaseActions;

public class CheatSheetThankYouActions extends BaseActions {

    public CheatSheetThankYouActions() {}

    public void downloadAndOpenFile() {
        Pages.cheatSheetThankYouPage().waitLinkDownloadNow();
        Pages.cheatSheetThankYouPage().mimicOpeningFile();
        Pages.cheatSheetThankYouPage().deleteFile();
    }

    public void performGetItNowLinking() {
        Pages.cheatSheetThankYouPage().clickLinkGetItNow();
    }

    public void checkVideoPlaying() {
        Pages.cheatSheetThankYouPage().waitLinkDownloadNow();
        String firstScreenshotPath = Pages.cheatSheetThankYouPage().makeAScreenShot();
        Pages.cheatSheetThankYouPage().clickPlayButton();         //playing
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        String secondScreenshotPath = Pages.cheatSheetThankYouPage().makeAScreenShot();
        Assert.assertFalse(Pages.cheatSheetThankYouPage().compareImages(firstScreenshotPath, secondScreenshotPath));
        Pages.cheatSheetThankYouPage().clickPauseButton();     //paused
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        String firstControlScreenshotPath = Pages.cheatSheetThankYouPage().makeAScreenShot();
        String secondControlScreenshotPath = Pages.cheatSheetThankYouPage().makeAScreenShot();
        Assert.assertTrue(Pages.cheatSheetThankYouPage().compareImages(firstControlScreenshotPath, secondControlScreenshotPath));
        Pages.cheatSheetThankYouPage().deleteFile(firstScreenshotPath);
        Pages.cheatSheetThankYouPage().deleteFile(secondScreenshotPath);
        Pages.cheatSheetThankYouPage().deleteFile(firstControlScreenshotPath);
        Pages.cheatSheetThankYouPage().deleteFile(secondControlScreenshotPath);
    }
}