package co.sprayable.sleep.actions;

import co.sprayable.sleep.data.QuizData;
import co.sprayable.sleep.pages.Pages;
import qa.util.Random;
import qa.util.base.BaseActions;

public class TakeSleepTypeQuizAction extends BaseActions {

    public TakeSleepTypeQuizAction() {}

    public void takeSleepTypeQuiz(QuizData data, boolean isNameRequired) {
        Pages.takeSleepTypePage().clickTakeYourSleepTypeQuizButton();
        Pages.takeSleepTypePage().selectGender(data.getGender());
        Pages.takeSleepTypePage().selectAge(data.getAge());
        Pages.takeSleepTypePage().selectCantFallAsleepTroubles();
        Pages.takeSleepTypePage().selectNightOwlHabits();
        Pages.takeSleepTypePage().selectTime_0_4_Asleep();
        Pages.takeSleepTypePage().selectHighlyStressed();
        Pages.takeSleepTypePage().selectLotsLightExposure();
        Pages.takeSleepTypePage().selectFrequentTraveler();
        Pages.takeSleepTypePage().waitProgressBar();
        Pages.takeSleepTypePage().setEmail(Random.genEmail());
        if (isNameRequired) {
            Pages.takeSleepTypePage().setName(data.getName());
            Pages.takeSleepTypePage().markTermsCheckBox();
        }
        Pages.takeSleepTypePage().clickShowSleepTypeButton();
    }
}