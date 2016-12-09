package co.sprayable.sleep.pages;

import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;

public class SleepTypeDiscountOfferPage extends BasePage {

    private Locator learnMoreButton = new Locator(LocatorTypes.XPATH, "//div[@class='btnLearnMore']/a");

    protected SleepTypeDiscountOfferPage() {}

    public void clickLearnMoreButton() {
        waitToBeClickable("Wait the 'Learn More About Our Custom Fix' button to be clickable", learnMoreButton);
        clickJS("Click the 'Learn More About Our Custom Fix' button", learnMoreButton);
    }
}