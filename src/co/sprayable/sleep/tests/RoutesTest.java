package co.sprayable.sleep.tests;

import org.testng.annotations.Test;
import qa.util.AllAddressCheck;
import qa.util.Constants;
import qa.util.base.BaseTest;
import qa.util.reporting.Reporter;

import java.io.IOException;

/**
 * Created by User on 09.12.2016.
 */
public class RoutesTest extends BaseTest {
    @Test
    public void setAllAddressCheckTest() throws IOException {
        AllAddressCheck allAddressCheck = new AllAddressCheck();
        Reporter.log("high Priority sites: ");
        allAddressCheck.testingAllRoutesAvailability(Constants.highPriority);
         Reporter.log("low Priority sites: ");
         allAddressCheck.testingAllRoutesAvailability(Constants.lowPriority);
    }

}
