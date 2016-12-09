package co.sprayable.sleep.data;

import qa.util.Constants;
import qa.util.Random;

public class OrderData {

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getDayTimePhone() {
        return dayTimePhone;
    }

    public void setDayTimePhone(String dayTimePhone) {
        this.dayTimePhone = dayTimePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCrediteCard() {
        return crediteCard;
    }

    public void setCrediteCard(String crediteCard) {
        this.crediteCard = crediteCard;
    }

    public int getExprMonth() {
        return exprMonth;
    }

    public void setExprMonth(int exprMonth) {
        this.exprMonth = exprMonth;
    }

    public int getExprYear() {
        return exprYear;
    }

    public void setExprYear(int exprYear) {
        this.exprYear = exprYear;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String dayTimePhone;
    private String email;
    private String crediteCard;
    private int exprMonth;
    private int exprYear;
    private int cvv;

    public OrderData generateOrderData() {
        OrderData orderData = new OrderData();
        orderData.setFirstName(Constants.ORDER_NAME);
        orderData.setLastName(Constants.ORDER_NAME);
        orderData.setAddress(Random.genAddress());
        orderData.setCity(Constants.CITY);
        orderData.setState(Constants.STATE);
        orderData.setCountry(Constants.COUNTRY);
        orderData.setZipCode(Constants.POSTAL_CODE);
        orderData.setDayTimePhone(Random.genPhone());
        orderData.setEmail(Random.genEmail());
        orderData.setCrediteCard(Constants.CREDIT_CARD);
        orderData.setExprMonth(2 + (int)(Math.random() * ((13 - 2) + 1)));
        orderData.setExprYear(5 + (int)(Math.random() * ((25 - 5) + 1)));
        orderData.setCvv(101 + (int)(Math.random() * ((999 - 101) + 1)));
        return orderData;
    }
}
