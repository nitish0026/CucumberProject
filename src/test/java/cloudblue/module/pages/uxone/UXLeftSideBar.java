package cloudblue.module.pages.uxone;

import cloudblue.utility.Pages;
import cloudblue.utility.browser.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UXLeftSideBar extends Pages {
    public UXLeftSideBar(Browser browser) {
        super (browser);
    }

    @FindBy(xpath = "//strong[text()='Marketplace']") private WebElement UX1Marketplace;
    @FindBy(xpath = "//a[@id='nav-link-accountList']") private WebElement UX1customers;
    @FindBy(xpath = "//strong[text()='Users']") private WebElement UX1Users;
    @FindBy(xpath = "//strong[text()='Account']") private WebElement UX1Account;



    public void clickUX1Customer() throws Exception {
        untilJqueryIsDone(browser.driver());
        UX1customers.click ();
    }
    public void clickUX1marketplace() throws Exception {
        wait(Pages.MID_WAIT_TIME);
        UX1Marketplace.click ();
    }
    public void clickUX1users() throws Exception {
        Thread.sleep (5000);
        UX1Users.click ();
    }

    /*Click on Accounts from Ux1 Sidebar
    * */
    public void clickUX1Accounts() throws Exception {
        Thread.sleep (5000);
        UX1Account.click ();
    }



}

