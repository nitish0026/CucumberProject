package cloudblue.module.pages.uxone;

import cloudblue.utility.Pages;
import cloudblue.utility.browser.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UXUsersPage extends Pages {
    Browser browser;
    public UXUsersPage(Browser browser)
    {
        super(browser);
        PageFactory.initElements(browser.getDriver(),this);
    }
    @FindBy(id="add-new-users-in-tile")
    private WebElement add_new_user_btn;
}
