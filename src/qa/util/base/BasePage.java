package qa.util.base;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.util.properties.Properties;
import qa.util.reporting.Reporter;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BasePage extends DriverContainer {
    public static int ELEMENT_MICRO_TIMEOUT_SECONDS = 1;
    public static int ELEMENT_EXTRASMALL_TIMEOUT_SECONDS = 5;
    public static int ELEMENT_SMALL_TIMEOUT_SECONDS = 15;
    public static int ELEMENT_TIMEOUT_SECONDS = 30;
    public static int ELEMENT_LONG_TIMEOUT_SECONDS = 60;
    public static int ELEMENT_EXTRALONG_TIMEOUT_SECONDS = 120;
    public static int ELEMENT_MEGA_EXTRALONG_TIMEOUT_SECONDS = 300;

    public static String BASE_URL = Properties.getBaseUrl();

    protected void click(String message, Locator locator, Object... args) {
        Reporter.log(message);
        WebElement element = driver().findElement(locator.getLocator(args));
        driver().switchTo().defaultContent();
        element.click();
    }

    protected void click(String message, WebElement element) {
        Reporter.log(message);
        element.click();
    }

    protected void clickJS(String message, Locator locator, Object... args) {
        Reporter.log(message);
        ((JavascriptExecutor) driver()).executeScript("arguments[0].click()", driver().findElement(locator.getLocator(args)));
    }

    protected void clickJS(String message, WebElement element) {
        Reporter.log(message);
        ((JavascriptExecutor) driver()).executeScript("arguments[0].click()", element);
    }

    protected void type(String message, String value, Locator locator, Object... args) {
        Reporter.log(message);
        WebElement input = driver().findElement(locator.getLocator(args));
        input.clear();
        input.sendKeys(value);
    }

    protected void typeNewline(String message, Locator locator, Object... args) {
        Reporter.log(message);
        WebElement input = driver().findElement(locator.getLocator(args));
        input.clear();
        input.sendKeys(Keys.ENTER);
    }

    protected Dimension getDimension(String message, Locator locator, Object... args) {
        Reporter.log(message);
        WebElement element = driver().findElement(locator.getLocator(args));
        return element.getSize();
    }

    protected List<WebElement> getElements(String message, Locator locator, Object... args) {
        Reporter.log(message);
        List<WebElement> elements = driver().findElements(locator.getLocator(args));
        return elements;
    }

    protected String getText(String message, Locator locator, Object... args) {
        Reporter.log(message);

        WebElement element = driver().findElement(locator.getLocator(args));
        String type = element.getTagName().toLowerCase();

        if (type.equals("input") || type.equals("textarea")) {
            String placeholder = element.getAttribute("placeholder");
            return (placeholder != null && placeholder.length() > 0)
                    ? element.getAttribute("value").replace(placeholder, "")
                    : element.getAttribute("value");
        }
        if (type.equals("select")) {
            return new Select(element).getFirstSelectedOption().getText();
        }
        return element.getText();
    }

    protected void waitForPresence(String message, Locator locator, Object... args) {
        waitForPresence(ELEMENT_TIMEOUT_SECONDS, message, locator, args);
    }

    protected void waitForPresence(int timeout, String message, Locator locator, Object... args) {
        Reporter.log(message);

        driver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver(), timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator.getLocator(args)));
        driver().manage().timeouts().implicitlyWait(ELEMENT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
    }

    protected void waitForVisibility(String message, Locator locator, Object... args) {
        waitForVisibility(ELEMENT_TIMEOUT_SECONDS, message, locator, args);
    }

    protected void waitForVisibility(int timeout, String message, Locator locator, Object... args) {
        Reporter.log(message);

        driver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver(), timeout);
        /*Workaround to IEDriver bug with WebDriverException*/
        if (BaseTest.isDriverIE) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator.getLocator(args)));
            } catch (WebDriverException e) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator.getLocator(args)));
            }
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator.getLocator(args)));
        }
        driver().manage().timeouts().implicitlyWait(ELEMENT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
    }

    protected void waitForInvisibility(String message, Locator locator, Object... args) {
        waitForInvisibility(ELEMENT_MICRO_TIMEOUT_SECONDS, ELEMENT_TIMEOUT_SECONDS, message, locator, args);
    }

    protected void waitForInvisibility(
            int waitElementTimeout, int timeout, String message,
            Locator locator, Object... args) {
        Reporter.log(message);

        driver().manage().timeouts().implicitlyWait(waitElementTimeout, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver(), timeout);
        /*Workaround to IEDriver bug with WebDriverException*/
        if (BaseTest.isDriverIE) {
            try {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(locator.getLocator(args)));
            } catch (WebDriverException e) {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(locator.getLocator(args)));
            }
        } else {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator.getLocator(args)));
        }
        driver().manage().timeouts().implicitlyWait(ELEMENT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
    }

    protected void waitToBeClickable(String message, Locator locator, Object... args) {
        waitToBeClickable(ELEMENT_TIMEOUT_SECONDS, message, locator, args);
    }

    protected void waitToBeClickable(int timeout, String message, Locator locator, Object... args) {
        Reporter.log(message);

        driver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver(), timeout);
        wait.until(ExpectedConditions.elementToBeClickable(locator.getLocator(args)));
        driver().manage().timeouts().implicitlyWait(ELEMENT_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        // wait until the element on the same place
        WebElement element = driver().findElement(locator.getLocator(args));
        Point location;
        do {
            location = element.getLocation();
            BaseActions.wait(0, 500);
        } while (!location.equals(element.getLocation()));
    }

    /*
    * Checkboxes
    */
    protected boolean isCheckboxChecked(Locator locator, Object... args) {
        return driver().findElement(locator.getLocator(args)).isSelected();
    }

    protected boolean isCheckboxChecked(WebElement element) {
        return element.isSelected();
    }

    protected void setCheckboxState(String message, boolean checked, Locator locator, Object... args) {
        if (checked ^ this.isCheckboxChecked(locator, args)) {
            this.click(message, locator, args);
        }
    }

    protected void setCheckboxStateForAll(String message, boolean checked, Locator locator, Object... args) {
        List<WebElement> elements = driver().findElements(locator.getLocator(args));
        for (WebElement element : elements) {
            if (checked && !isCheckboxChecked(element)) {
                //this.click(message, element);
                clickJS(message, element);
            }
        }
    }

    protected int getCount(String message, Locator locator, Object... args) {
        return this.getCount(0, message, locator, args);
    }

    protected int getCount(int waitInSeconds, String message, Locator locator, Object... args) {
        Reporter.log(message);

        driver().manage().timeouts().implicitlyWait(waitInSeconds, TimeUnit.SECONDS);
        int size = driver().findElements(locator.getLocator(args)).size();
        driver().manage().timeouts().implicitlyWait(ELEMENT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        return size;
    }

    protected boolean isPresent(String message, Locator locator, Object... args) {
        return getCount(message, locator, args) > 0;
    }

    protected boolean isPresent(int waitInSeconds, String message, Locator locator, Object... args) {
        return getCount(waitInSeconds, message, locator, args) > 0;
    }

    protected void executeJS(String message, String script, Locator locator, Object... args) {
        Reporter.log(message);
        ((JavascriptExecutor) driver()).executeScript(script, driver().findElement(locator.getLocator(args)));
    }

    protected void checkAlert(String message) {
        Reporter.log(message);
        WebDriverWait wait = new WebDriverWait(driver(), 10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver().switchTo().alert();
        alert.accept();
    }

    protected String getAttributeValue(String message, String attribute, Locator locator, Object... args) {
        WebElement element = driver().findElement(locator.getLocator(args));
        return getAttributeValue(message, attribute, element);
    }

    protected String getAttributeValue(String message, String attribute, WebElement element) {
        Reporter.log(message);
        String value = element.getAttribute(attribute);
        return value;
    }

    protected boolean isAttributePresent(String message, String attribute, Locator locator, Object... args) {
        Reporter.log(message);
        Boolean result = false;
        WebElement element = driver().findElement(locator.getLocator(args));
        String value = element.getAttribute(attribute);
        if (value != null)
            result = true;
        return result;
    }

    protected void pasteText(String message, Locator locator, Object... args) {
        Reporter.log(message);
        WebElement element = driver().findElement(locator.getLocator(args));
        element.sendKeys(Keys.CONTROL, "v");

    }

    protected void uploadFile(String message, String filePath, Locator locator, Object... args) {
        Reporter.log(message);
        WebElement fileInput = driver().findElement(locator.getLocator(args));
        fileInput.sendKeys(filePath);
    }

    protected void dragAndDrop(String message, Locator from, Locator to, Object... args) {
        Reporter.log(message);
        WebElement fromElement = driver().findElement(from.getLocator(args));
        WebElement toElement = driver().findElement(to.getLocator());
        (new Actions(driver()).dragAndDrop(fromElement, toElement)).perform();
    }

    protected void selectDropDownListOptionByText(String message, String selectItemText, Locator locator, Object... args) {
        Reporter.log(message);

        Select dropDownList = new Select(driver().findElement(locator.getLocator(args)));
        // if element has wrong value we can try select item only by text
        try {
            dropDownList.selectByValue(selectItemText);
        } catch (NoSuchElementException e) {
            dropDownList.selectByVisibleText(selectItemText);
        }
    }

    protected void selectDropDownListOptionByIndex(String message, int itemIndex, Locator locator, Object... args) {
        Reporter.log(message);
        if (itemIndex > 0) {
            Select dropDownList = new Select(driver().findElement(locator.getLocator(args)));
            dropDownList.selectByIndex(itemIndex - 1);
        }
    }

    protected String getSelectedOption(String message, Locator locator, Object... args) {

        Select listOptions = new Select(driver().findElement(locator.getLocator(args)));

        WebElement option = listOptions.getFirstSelectedOption();
        return option.getText();
    }

    protected boolean isEnabled(String message, Locator locator, Object... args) {
        Reporter.log(message);
        return driver().findElement(locator.getLocator(args)).isEnabled();
    }

    public void clickWithJS(String logMessage, Locator locator, Object... args) {
        Reporter.log(logMessage);
        final String javaScript = "if(document.createEvent){" +
                "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initEvent('click', true, false);" + "" +
                "arguments[0].dispatchEvent(evObj);" +
                "} else if(document.createEventObject){" +
                "arguments[0].fireEvent('onclick');" +
                "}";
        ((JavascriptExecutor) driver()).executeScript(javaScript, driver().findElement(locator.getLocator(args)));
    }

    protected Actions moveToElement(String logMessage, Locator locator, int xOffset, int yOffset) {
        Reporter.log(logMessage);
        WebElement element = driver().findElement(locator.getLocator());

        return new Actions(driver()).moveToElement(element, xOffset, yOffset);
    }

    protected void scrollToElement(String logMessage, Locator locator) {
        WebElement element = driver().findElement(locator.getLocator());
        ((JavascriptExecutor) driver()).executeScript("arguments[0].scrollIntoView();", element);
    }

    protected void clickEmptyPlace() throws AWTException {
        Robot robot = new Robot();
        robot.mouseMove(1,1);
        BaseActions.wait(1);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        BaseActions.wait(1);
    }
}
