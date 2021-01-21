package cloudblue.module.pages.odin;

import cloudblue.utility.Pages;
import cloudblue.utility.browser.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CBCUsersPage extends Pages {
    Browser browser;
    public CBCUsersPage(Browser browser)
    {
        super(browser);
        PageFactory.initElements(browser.getDriver(),this);
        browser.switchToFrame("mainFrame");
    }
    @FindBy(id="input___add")
    private WebElement add_new_user_btn;

    public boolean checkAddUserBtnExists() throws Exception {
        waitForPageLoaded();
        return add_new_user_btn.isDisplayed();
    }
}
