package co.sprayable.sleep.pages;

import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;

public class CheckoutPage extends BasePage {

    private Locator firstNameField = new Locator(LocatorTypes.XPATH, "//input[@id='shippingFirstName']");
    private Locator lastNameField = new Locator(LocatorTypes.XPATH, "//input[@id='shippingLastName']");
    private Locator addressField = new Locator(LocatorTypes.XPATH, "//input[@id='shippingAddress1']");
    private Locator cityField = new Locator(LocatorTypes.XPATH, "//input[@id='shippingCity']");
    private Locator stateField = new Locator(LocatorTypes.XPATH, "//input[@id='ucShippingStateFieldId']");
    private Locator zipCodeField = new Locator(LocatorTypes.XPATH, "//input[@id='shippingZip']");
    private Locator listCountries = new Locator(LocatorTypes.XPATH, "//select[@id='ucFieldShippingCountry']");
    private Locator daytimePhoneField = new Locator(LocatorTypes.XPATH, "//input[@name='shippingPhone']");
    private Locator billingInfoBlock = new Locator(LocatorTypes.XPATH, "//div[contains(@class, ' credit-card-section')]");
    private Locator emailField = new Locator(LocatorTypes.XPATH, "//input[@class='js-store-email']");
    private Locator cardNumberField = new Locator(LocatorTypes.XPATH, "//input[@id='creditCardNumber']");
    private Locator cardIframe = new Locator(LocatorTypes.XPATH, "//div[@id='creditCardNumberOverlay']//iframe");
    private Locator listMonthsExprField = new Locator(LocatorTypes.XPATH, "//select[@id='creditCardExpMonth']");
    private Locator listYearsExpr = new Locator(LocatorTypes.XPATH, "//select[@id='creditCardExpYear']");
    private Locator cvvIframe = new Locator(LocatorTypes.XPATH, "//div[@id='creditCardCvv2Overlay']/iframe");
    private Locator cvvField = new Locator(LocatorTypes.XPATH, "//input[@id='creditCardCvv2']");
    private Locator placeOrderButton = new Locator(LocatorTypes.XPATH, "//button[@id='FINALIZEORDER']");
    private Locator orderSurveyForm = new Locator(LocatorTypes.XPATH, "//div[contains(@class, 'orderSurvey')]");
    private Locator removeButton = new Locator(LocatorTypes.XPATH, "//button[contains(@class, 'remove')]");

    protected CheckoutPage() {}

    public void waitToOrderSurvey() {
        waitForVisibility("Wait for order survey", orderSurveyForm);
        scrollToElement("Move to order survey block", orderSurveyForm);
    }

    public void setFirstName(String firstName) {
        type("Set '" + firstName + "' in 'First Name' field", firstName, firstNameField);
    }

    public void setLastName(String lastName) {
        type("Set '" + lastName + "' in 'Last Name' field", lastName, lastNameField);
    }

    public void setAddress(String address) {
        type("Set '" + address + "' in 'Address' field", address, addressField);
    }

    public void setCity(String city) {
        type("Set '" + city + "' in 'City' field", city, cityField);
    }

    public void setState(String state) {
        type("Set '" + state + "' in 'State' field", state, stateField);
    }

    public void setZipCode(String zipCode) {
        type("Set '" + zipCode + "' in 'Zip Code' field", zipCode, zipCodeField);
    }

    public void selectCountryByName(String countryName) {
        selectDropDownListOptionByText("Select '" + countryName + "'", countryName, listCountries);
    }

    public void setDaytimePhone(String phone) {
        type("Set " + phone +  " in 'Daytime phone'" , phone, daytimePhoneField);
    }

    public void setEmail(String email) {
        type("Set '" + email + "' in 'Email Address' field", email, emailField);
    }

    public void moveToBillingInfBlock() {
        scrollToElement("Move to 'BILLING INFORMATION' block", billingInfoBlock);
    }

    public void setCardNumber(String cardNumber) {
        driver().switchTo().frame(driver().findElement(cardIframe.getLocator()));
        type("Set '" + cardNumber + "' in 'CARD NUMBER' field", cardNumber, cardNumberField);
        driver().switchTo().defaultContent();
    }

    public void selectExprMonth(int month) {
        selectDropDownListOptionByIndex("Select '" + month + "'", month, listMonthsExprField);
    }

    public void selectExprYear(int year) {
        selectDropDownListOptionByIndex("Select '" + year + "'", year, listYearsExpr);
    }

    public void setCVV(int cvv) {
        driver().switchTo().frame(driver().findElement(cvvIframe.getLocator()));
        type("Set '" + cvv + "' in 'CVV' field", String.valueOf(cvv), cvvField);
        driver().switchTo().defaultContent();
    }

    public void clickPlaceOrderButton() {
        waitForVisibility("Wait the 'Place Order' button to be clickable", placeOrderButton);
        click("Click the 'Place Order' button", placeOrderButton);
    }

    public void clickRemoveButton() {
        click("Clicking Remove button", removeButton);
    }
}