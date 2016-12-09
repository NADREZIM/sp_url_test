package co.sprayable.sleep.pages;

import org.openqa.selenium.NoAlertPresentException;
import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;

public class ThankyouPage extends BasePage {

    private Locator firstNameField = new Locator(LocatorTypes.XPATH,
            "//div[@class='content-container']//*[contains(text(), 'Thank You! Your Order is Complete')]");

    protected ThankyouPage() {}

    public boolean isConfirmOrderMessagePressent() {
        try {
            driver().switchTo().alert().dismiss();
        } catch (NoAlertPresentException e){
            e.printStackTrace();
        }
        return isPresent(ELEMENT_TIMEOUT_SECONDS, "Wait confirm order message", firstNameField);
    }
}