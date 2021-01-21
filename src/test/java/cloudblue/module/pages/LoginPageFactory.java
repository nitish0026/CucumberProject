package cloudblue.module.pages;

import cloudblue.utility.Pages;
import cloudblue.utility.browser.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends Pages
{
    Browser browser;
    public LoginPageFactory(Browser browser)
    {
        super(browser);
        PageFactory.initElements(browser.getDriver(),this);
    }

    @FindBy(id="username")
    private WebElement login_username;

    @FindBy(how = How.ID, using="password")
    private WebElement login_password;

    @FindBy(how = How.ID, using="loginBtn")
    private WebElement login_loginBtn;

    public void clickOn()
    {
        login_username.sendKeys("admin");
        login_password.sendKeys("123qwe");
        login_loginBtn.click();
    }
    public void read()
    {
        hover(login_loginBtn);
    }

}
