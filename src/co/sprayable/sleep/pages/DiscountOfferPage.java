package co.sprayable.sleep.pages;

import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;

public class DiscountOfferPage extends BasePage {

    private Locator getMyFreeSampleButton = new Locator(LocatorTypes.XPATH, "//div[contains(@class, 'get-free-sample-wrapper')]/a");
    private Locator getSampleProduct = new Locator(LocatorTypes.XPATH, "//div[@id='products']//div[@class='product'][1]//div[@class='pay-button-wrapper-inner']");
//    private Locator sampleProducts = new Locator(LocatorTypes.XPATH, "//div[@class='product']['%s']//div[@class='pay-button-wrapper-inner']");

    protected DiscountOfferPage() {}

    public void clickGetMyFreeSampleButton() {
        waitForVisibility("Wait the 'GET MY FREE SAMPLE' button to be visible", getMyFreeSampleButton);
        click("Click the 'GET MY FREE SAMPLE' button", getMyFreeSampleButton);
    }

    public void clickGetSampleProduct(){
        waitToBeClickable("Wait the 'Get My Sample' button to be clickable", getSampleProduct);
        click("Click the 'Get My Sample' button", getSampleProduct);
    }

//    public int clickGetSampleProduct() {
//        waitForVisibility("Wait the 'Get MY SAMPLE' button to be visible", sampleProducts, rand);
//        click("Click the 'GET MY SAMPLE' button", sampleProducts, rand);
//        return rand;
//    }
}