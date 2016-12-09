package co.sprayable.sleep.pages;

import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;

public class TakeSleepTypePage extends BasePage {

    private Locator takeQuizButton = new Locator(LocatorTypes.XPATH,
            "//div[@id='section_landing']//div[contains(@class, 'button-take-quiz')][1]");

    private Locator typeGenderRadioBox = new Locator(LocatorTypes.XPATH, "//label[@for='answer-%s']");
    private Locator ageRadioBox = new Locator(LocatorTypes.XPATH, "//label[@for='answer-%s']");
    private Locator noFallAsleep = new Locator(LocatorTypes.XPATH, "//label[@for='answer-no-fall-asleep']");
    private Locator nightOwls = new Locator(LocatorTypes.XPATH, "//label[@for='answer-night-owls']");
    private Locator time_0_4_Asleep = new Locator(LocatorTypes.XPATH, "//label[@for='answer-0-4-hours']");
    private Locator answerHighlyStressed = new Locator(LocatorTypes.XPATH, "//label[@for='answer-highly-stressed']");
    private Locator answerHeavilyLight = new Locator(LocatorTypes.XPATH, "//label[@for='answer-heavily-light']");

    private Locator answerFrequentTraveler = new Locator(LocatorTypes.XPATH,
            "//label[@for='answer-frequent-traveler']");

    private Locator progressBar = new Locator(LocatorTypes.XPATH, "//div[@class='progress-bar']");
    private Locator emailField = new Locator(LocatorTypes.XPATH, "//input[@id='txtEmail']");
    private Locator nameField = new Locator(LocatorTypes.XPATH, "//input[@name='inf_field_FirstName']");

    private Locator termsCheckBox = new Locator(LocatorTypes.XPATH,
            "//div[@class='email-form']//button[contains(@class, 'btnSubmit')]");

    private Locator showSleepTypeButton = new Locator(LocatorTypes.XPATH, "//div[@class='email-form']//button");

    protected TakeSleepTypePage() {}

    public void clickTakeYourSleepTypeQuizButton() {
        waitToBeClickable("Wait the 'TAKE YOUR SLEEP TYPE QUIZ NOW' button to be clickable", takeQuizButton);
        click("Click the 'TAKE YOUR SLEEP TYPE QUIZ NOW' button", takeQuizButton);
    }

    public void selectGender(String genderType) {
        waitForVisibility("Wait the '" + genderType + "' radio box to be clickable", typeGenderRadioBox, genderType);
        click("Select the '" + genderType + "' gender", typeGenderRadioBox, genderType);
    }

    public void selectAge(int age) {
        waitForVisibility("Wait the '" + age + "' radio box to be clickable", ageRadioBox, age);
        click("Select the '" + age + "' age", ageRadioBox, age);
    }

    public void selectCantFallAsleepTroubles() {
        waitForVisibility("Wait the 'Can't fall asleep' radio box to be clickable", noFallAsleep);
        click("Select the 'Can't fall asleep'", noFallAsleep);
    }

    public void selectNightOwlHabits() {
        waitForVisibility("Wait the 'Night owls' radio box to be clickable", nightOwls);
        click("Select the 'Night owls'", nightOwls);
    }

    public void selectTime_0_4_Asleep() {
        waitForVisibility("Wait the '0-4 hours' radio box to be clickable", time_0_4_Asleep);
        click("Select the '0-4 hours'", time_0_4_Asleep);
    }

    public void selectHighlyStressed() {
        waitForVisibility("Wait the 'Highly stressed' radio box to be clickable", answerHighlyStressed);
        click("Select the 'Highly stressed' age", answerHighlyStressed);
    }

    public void selectLotsLightExposure() {
        waitForVisibility("Wait the 'Lots of Light Exposure' radio box to be clickable", answerHeavilyLight);
        click("Select the 'Lots of Light Exposure' age", answerHeavilyLight);
    }

    public void selectFrequentTraveler() {
        waitForVisibility("Wait the 'Frequent Traveler' radio box to be clickable", answerFrequentTraveler);
        click("Select the 'Frequent Traveler' age", answerFrequentTraveler);
    }

    public void waitProgressBar() {
        waitForInvisibility("Wait for progress bar become invisible", progressBar);
    }

    public void setEmail(String email) {
        waitForVisibility("Wait for email input field visibility", emailField);
        type("Set email: " + email, email, emailField);
    }

    public void setName(String name) {
        waitForVisibility("Wait for name input field visibility", nameField);
        type("Set email: " + name, name, nameField);
    }

    public void markTermsCheckBox() {
        waitForVisibility("Wait for terms check box visibility", termsCheckBox);
        setCheckboxState("Check terms checkbox", true, termsCheckBox);
    }

    public void clickShowSleepTypeButton() {
        waitForVisibility("Wait the 'Yes, Show Me My Sleep Type' button to be clickable", showSleepTypeButton);
        click("Click the 'Yes, Show Me My Sleep Type' button", showSleepTypeButton);
    }
}