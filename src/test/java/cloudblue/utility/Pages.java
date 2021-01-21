package cloudblue.utility;

import cloudblue.utility.browser.Browser;
import com.google.common.base.Function;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import javax.lang.model.type.NullType;
import java.time.Duration;

import static junit.framework.Assert.assertTrue;

public class Pages {
    /**
     * This class will have all common functions related to any page
     */
    public static int MINIMUM_WAIT_TIME = 2000;
    public static int LONG_WAIT_TIME = 60 * 1000;
    public static int MAXIMUM_WAIT_TIME = 40000;
    public static int MID_WAIT_TIME = 5000;
    public static int EXPLICIT_WAIT_TIME = 10000;
    public static int LOOP_COUNT = 10;
    protected Actions actions;
    protected Browser browser;
    protected JavascriptExecutor javascriptExecutor;

    public Pages(Browser browser) {
        this.browser = browser;
        actions = new Actions(browser.driver());
        javascriptExecutor = (JavascriptExecutor) browser.driver();
        PageFactory.initElements(browser.driver(), this);
    }

    /**
     * method to pause for a set amount of time
     * @param seconds
     */
    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForElementDisplayed(WebElement element) throws Exception {
        waitForElementDisplayed(element, 5);
    }

    /**
     * Wait for element to be displayed
     * @param element
     * @param seconds
     * @throws Exception
     */
    public void waitForElementDisplayed(WebElement element, int seconds) throws Exception {
        //wait for up to XX seconds for our error message
        long end = System.currentTimeMillis() + (seconds * 1000);
        while (System.currentTimeMillis() < end) {
            // If results have been returned, the results are displayed in a drop down.
            if (element.isDisplayed()) {
                break;
            }
        }
    }

    /**
     * Assert if an element is displayed
     * @param element
     * @throws Exception
     */
    public void checkElementDisplayed(WebElement element) throws Exception {
        assertTrue(element.isDisplayed());
    }

    //our generic selenium click functionality implemented
    public void check(WebElement element) throws Exception {

    }

    /**
     * method to hover to an element and then click
     * @param element
     */
    public void click(WebElement element) {
        actions.moveToElement(element).click().build().perform();
    }

    /**
     * Method to hover to an specific element
     * @param element
     */
    public void hover(WebElement element) {
        actions.moveToElement(element).perform();
    }

    /**
     * Method to write in a textbox using actions class
     * @param element
     * @param text
     */
    public void type(WebElement element, String text) {
        actions.sendKeys(element, text).perform();
    }

    /**
     * Method to wait until a page is completely loaded using jquery
     * @return true/false
     */
    public boolean waitForReady() {
        int exceptionCount = 0;
        int maxExceptionCount = 10;
        waitForPageLoaded();
        for (int i = 0; i < LOOP_COUNT; i++) {
            try {
                if (exceptionCount == maxExceptionCount) {
                    break;
                }
                Boolean isAjaxFinished = javascriptExecutor.executeScript("return jQuery.active > 0").toString().equalsIgnoreCase("false");
                if (!isAjaxFinished) {
                    Thread.sleep(MINIMUM_WAIT_TIME);
                    continue;
                }
                return isAjaxFinished;

            } catch (Exception e) {
                exceptionCount++;
                try {
                    Thread.sleep(MINIMUM_WAIT_TIME);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                continue;
            }
        }
        return false;
    }

    /**
     *  Method to wait until a page is completely loaded using dom
     */
    public void waitForPageLoaded() {
        for (int i = 0; i < LOOP_COUNT; i++) {
            try {
                if (javascriptExecutor.executeScript("return document.readyState;").equals("complete")) {
                    return;
                }
                Thread.sleep(MINIMUM_WAIT_TIME);
            } catch (Exception e) {
                try {
                    Thread.sleep(MINIMUM_WAIT_TIME);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return;
    }


    private void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition){

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIME));
        try{
            webDriverWait.until(waitCondition);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void untilJqueryIsDone(WebDriver driver){
        until(driver, (d) ->
        {
            Boolean isJqueryCallDone = (Boolean)((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
            if (!isJqueryCallDone) System.out.println("JQuery call is in Progress");
            return isJqueryCallDone;
        });
    }

    /**
     * Method to wait until an element is visible
     * @param item
     * @param timeToWait
     * @return
     */
    public boolean waitForExists(WebElement item, int timeToWait) {
        boolean found = false;
        WebElement element = null;

        try {
            WebDriverWait driverWait = new WebDriverWait(browser.driver(), Duration.ofSeconds(timeToWait));
            element = (driverWait.until(ExpectedConditions.visibilityOf(item)));
        } catch (Exception e) {
        }

        if (element != null) {
            found = true;
        }

        return found;
    }

/*Explicit wait to Be used at required instances where loading takes time
* */
    public void ExplicitWebDriverWait(WebElement element){
        WebDriverWait wait = new WebDriverWait(browser.driver(), Duration.ofSeconds(EXPLICIT_WAIT_TIME));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

/*Fluent Wait Time
* */
    public void FluentWait(WebElement element){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(browser.driver())
                .withTimeout(Duration.ofMillis(EXPLICIT_WAIT_TIME))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>()
        {
            public WebElement apply(WebDriver driver) {
                driver = browser.driver();
                if(driver.findElement((By) element).isDisplayed()){
                    return driver.findElement((By) element);
                }
                else return null;
            }

        };
        wait.until(function);
    }


}
