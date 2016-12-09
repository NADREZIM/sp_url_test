package co.sprayable.sleep.pages;

import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;

public class GetFreeTrialPage extends BasePage {

    private Locator linkClaimFreeSampleTop = new Locator(LocatorTypes.XPATH, "//p[@class='center']/a");
    private Locator linkClaimFreeSampleBottom = new Locator(LocatorTypes.XPATH, "//div[contains(@class, 'submit-container')]/a");

    public void clickLinkClaimFreeSampleTop() {
        waitToBeClickable("waiting for link 'Claim Sample' in the top of page become clickable", linkClaimFreeSampleTop);
        click("click link 'Claim Sample' in th etop of page", linkClaimFreeSampleTop);
    }

    public void clickLinkClaimFreeSampleBottom() {
        click("click link 'Claim Sample' in the bottom of page", linkClaimFreeSampleBottom);
    }

    public void waitLinkClaimFreeSampleBottomDisappear() {
        waitForInvisibility("waiting for link 'Claim Sample' in the bottom of page disappears", linkClaimFreeSampleBottom);
    }
}