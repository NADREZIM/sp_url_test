package co.sprayable.sleep.actions;

import qa.util.base.BaseActions;
import qa.util.base.BasePage;
import qa.util.reporting.Reporter;

public class MainActions extends BaseActions {

    protected MainActions() {}

    public void openHomePage() {
        Reporter.log("Open home page: " + BasePage.BASE_URL);
        driver().get(BasePage.BASE_URL);
    }

    public void openSecondHomePage() {
        Reporter.log("Open alternative home page: " + BasePage.BASE_URL + "2");
        driver().get(BasePage.BASE_URL + "2");
    }

    public void openPage(String url) {
        Reporter.log("Open page: " + url);
        driver().get(url);
    }

    public void refreshPage() {
        Reporter.log("Refreshing page");
        driver().navigate().refresh();
    }

    public String getPageTitle() {
        BaseActions.wait(2);
        String title = driver().getTitle();
        Reporter.log("Page title is " + title);
        return title;
    }

    public void switchToNewWindow() {
        for (String newWindow : driver().getWindowHandles())
            driver().switchTo().window(newWindow);
    }

    public void closeWindow() {
        driver().close();
    }
}