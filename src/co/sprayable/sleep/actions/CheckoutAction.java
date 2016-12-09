package co.sprayable.sleep.actions;

import co.sprayable.sleep.data.OrderData;
import co.sprayable.sleep.pages.Pages;
import qa.util.Random;
import qa.util.base.BaseActions;

public class CheckoutAction extends BaseActions {

    public CheckoutAction() {}

    public void checkOutOrder(OrderData data) {
        Pages.checkoutPage().waitToOrderSurvey();
        Pages.checkoutPage().setFirstName(data.getFirstName());
        Pages.checkoutPage().setLastName(data.getLastName());
        Pages.checkoutPage().setAddress(Random.genAddress());
        Pages.checkoutPage().setCity(data.getCity());
        Pages.checkoutPage().setState(data.getState());
        Pages.checkoutPage().setZipCode(data.getZipCode());
        Pages.checkoutPage().selectCountryByName(data.getCountry());
        Pages.checkoutPage().setDaytimePhone(Random.genPhone());
        Pages.checkoutPage().setEmail(Random.genEmail());

        Pages.checkoutPage().moveToBillingInfBlock();
        Pages.checkoutPage().setCardNumber(data.getCrediteCard());
        Pages.checkoutPage().selectExprMonth(data.getExprMonth());
        Pages.checkoutPage().selectExprYear(data.getExprYear());
        Pages.checkoutPage().setCVV(data.getCvv());

        wait(3);

        Pages.checkoutPage().clickPlaceOrderButton();
    }
}