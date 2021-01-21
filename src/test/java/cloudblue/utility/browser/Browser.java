package cloudblue.utility.browser;

import cloudblue.utility.listeners.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import cloudblue.utility.ReadConfig;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Browser  {
    private static boolean created = false;
    private static Browser browser;
    private static String baseURL;
    private static String browserName = null;
    private final String defaultBrowser = "chrome";
    protected ReadConfig readConfig;
    protected WebDriverListener driverListener = new WebDriverListener();
    private static WebDriver driver;
    public static EventFiringWebDriver e_driver;
    private WebDriverWait wait;



    private void createInstance(String browser ) {
        //check our browser
        switch (browser.toLowerCase()) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver",readConfig.getDriver());
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver",readConfig.getDriver());
                driver = new ChromeDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                driver = new ChromeDriver();
        }

        e_driver=new EventFiringWebDriver(driver);
        e_driver.register(driverListener);
        e_driver.manage().window().maximize();
    }

    public Browser(){
        readConfig = new ReadConfig();
        baseURL = readConfig.getApplicationUrl();
        browserName = readConfig.getBrowser();
        created = true;
    }
    public static Browser getBrowserInstance() {
        if ( ! created ) {
            browser = new Browser();
            browser.create();
        }
        return browser;
    }

    public Browser create() {
        createInstance(browserName);
        wait = new WebDriverWait(driver, 15);
        return this;
    }

    public void navigateTo() {
    	getDriver().get( baseURL );
    }

    public void navigateTo(String url) {
        driver.get( url );
    }

	public static WebDriver getDriver() {
		if ( driver == null)
			throw new NullPointerException("WebDriver is not instantiated. Please create Object of Browser Class first");
		else
			return driver;
	}
	public static EventFiringWebDriver getEventDriver() {
        return e_driver;
    }

    public WebDriver driver() {
        return driver;
    }
    public Browser switchToFrame(WebElement frame) {
        driver.switchTo().parentFrame();
        driver.switchTo().frame(frame);
        return this;
    }
    public Browser switchToFrame(String name_or_id) {
        driver.switchTo().parentFrame();
        driver.switchTo().frame(name_or_id);
        return this;
    }
    public Browser switchToFrame(By by) {
        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(by));
        return this;
    }
    public Browser waitForVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    /**
     * Switching to the Last Tab
     * @return {@link Browser}
     */
    public Browser switchToLastTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get( tabs.size() -1 ));
        return this;
    }

    /**
     * Switching to the Fast Tab
     * @return {@link Browser}
     */
    public Browser switchToFastTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get( 0 ));
        return this;
    }

    /**
     *  Switch to Next Tab of the Current Tab
     * @return {@link Browser}
     */
    public Browser switchToNextTab() {
        String currentTab = driver().getWindowHandle();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (int i = 0; i < tabs.size(); i++) {
            String tab = tabs.get(i);
            String movetoTab = "";
            if (currentTab.equalsIgnoreCase(tab)) {
                try {
                    movetoTab = tabs.get(i+1);
                }catch (Exception e) {
                    throw new NotFoundException("Tab Not Exists");
                }
                driver.switchTo().window(movetoTab);
                break;
            }
        }
        return this;
    }

    /**
     *  Switch to Previous Tab of the Current Tab
     * @return {@link Browser}
     */
    public Browser switchToPreviousTab() {
        String currentTab = driver().getWindowHandle();
        String movetoTab = "";
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (int i = 0; i < tabs.size(); i++) {
            String tab = tabs.get(i);
            if (currentTab.equalsIgnoreCase(tab)) {
                try {
                    movetoTab = tabs.get(i-1);
                }catch (Exception e) {
                    throw new NotFoundException("Tab Not Exists");
                }
                driver.switchTo().window(movetoTab);
                break;
            }
        }
        return this;
    }
}
