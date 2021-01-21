package cloudblue.module.pages.uxone;

import cloudblue.utility.Pages;
import cloudblue.utility.browser.Browser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static java.lang.Thread.sleep;
import static org.testng.Assert.*;

public class UXMarketplacePage extends Pages {
    private static WebDriver driver;
    @FindBy(name="react_http://www.parallels.com/marketplace")
    private WebElement top_frame;

    @FindBy(xpath = "react-select-2-input") private WebElement categorySearchTxtBox;
    //@FindBy(id = "categories") private WebElement categoryicon;

    public UXMarketplacePage(Browser browser) {
        super (browser);
    }

    public void categorySearch(String subCategoryName) throws InterruptedException {
        waitForPageLoaded();
        //Pages pages =new Pages (browser);
        sleep(15000);
        //categorySearchTxtBox.clear();
        //JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        //String currentFrame = (String) jsExecutor.executeScript("return self.name");
        //System.out.println ("current frame" +currentFrame);
        //driver.switchTo().frame("topFrame");

       browser.switchToFrame(top_frame);
        waitForExists(categorySearchTxtBox,Pages.MID_WAIT_TIME);
        categorySearchTxtBox.click ();
       // assertEquals(categorySearchTxtBox., true);
        categorySearchTxtBox.sendKeys(subCategoryName);
        categorySearchTxtBox.sendKeys(Keys.ENTER);

    }
}
