package co.sprayable.sleep.actions;

import co.sprayable.sleep.pages.Pages;
import org.testng.Assert;
import qa.util.Constants;
import qa.util.base.BaseActions;

public class SleepSprayableVslActions extends BaseActions {

    public SleepSprayableVslActions() {}

    public void checkVideoPlaying() {
        Pages.sleepSprayableVslPage().waitDivVideoContainer();
        String firstScreenshotPath = Pages.sleepSprayableVslPage().makeAScreenShot();
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Pages.sleepSprayableVslPage().clickDivVideoContainer();
        String secondScreenshotPath = Pages.sleepSprayableVslPage().makeAScreenShot();
        Assert.assertFalse(Pages.sleepSprayableVslPage().compareImages(firstScreenshotPath, secondScreenshotPath));
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        String controlScreenshotPath = Pages.sleepSprayableVslPage().makeAScreenShot();
        Assert.assertTrue(Pages.sleepSprayableVslPage().compareImages(secondScreenshotPath, controlScreenshotPath));
        Pages.sleepSprayableVslPage().deleteFile(firstScreenshotPath);
        Pages.sleepSprayableVslPage().deleteFile(secondScreenshotPath);
        Pages.sleepSprayableVslPage().deleteFile(controlScreenshotPath);
    }
}