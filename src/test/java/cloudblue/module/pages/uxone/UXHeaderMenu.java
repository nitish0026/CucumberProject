package cloudblue.module.pages.uxone;

import cloudblue.utility.Pages;
import cloudblue.utility.browser.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UXHeaderMenu extends Pages
{

    /**
     * This class will have all elements and methods related to UX1 homepage
     * @param browser
     */
    public UXHeaderMenu(Browser browser) {
        super(browser);
    }

    @FindBy(id = "ccp-expert-menu-link") private WebElement classicPanelLink;
    @FindBy(id = "ccp-help-menu") private WebElement helpMenuLink;
    @FindBy(id = "account-name-id") private WebElement accountIconLink;
    @FindBy(id = "ccp-notify-warnings") private WebElement warningIconLink;
    @FindBy(id = "ccp-notify-activities") private WebElement notificationIconLink;

    /**
     * Method to click classic panel
     */
    public void clickClassicPanel()
    {
        classicPanelLink.click();
        waitForPageLoaded();
    }

    /**
     * Method to click help menu
     */
    public void clickHelpMenu()
    {
        helpMenuLink.click();
    }
    /**
     * Method to click account icon
     */
    public void clickAccountIcon()
    {
        accountIconLink.click();
    }
    /**
     * Method to click warning icon
     */
    public void clickWarningIcon()
    {
        warningIconLink.click();
        waitForPageLoaded();
    }
    /**
     * Method to click notification icon
     */
    public void clickNotificationIcon()
    {
        notificationIconLink.click();
    }
}
