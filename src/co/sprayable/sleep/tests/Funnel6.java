package co.sprayable.sleep.tests;

import co.sprayable.sleep.actions.Actions;
import co.sprayable.sleep.data.QuizData;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.util.Constants;
import qa.util.base.BaseTest;

public class Funnel6 extends BaseTest {

    private QuizData quizData = new QuizData();

    @BeforeClass
    private void genTestData() {
        quizData = quizData.generateQuizData();
    }

    @Test
    public void funnelTestSix() {
        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.SPRAYABLE_SLEEP_WHAT_IS_YOUR_SLEEP_TYPE_SLEEP_QUIZ_4_URL);
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);

        Actions.takeSleepTypeQuizAction().takeSleepTypeQuiz(quizData, false);

        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.RESULT_URL), "Expected URL: " + Constants.RESULT_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
    }
}