package cloudblue.module.pages;

import cloudblue.utility.Pages;
import cloudblue.utility.browser.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login extends Pages
{
    Browser browser;
    public Login(Browser browser)
    {
        super(browser);
        PageFactory.initElements(browser.getDriver(),this);
    }

    @FindBy(id="username")
    private WebElement login_username;

    @FindBy(id="password")
    private WebElement login_password;

    @FindBy(id="loginBtn")
    private WebElement login_loginbtn;

    //our basic login function
    public void loginAs(String user) throws Exception {
        enterUsername( user );
        enterPassword( user );
        clickLogin();
    }

    //entering in the username
    public void enterUsername(String user) throws Exception {
        //type the username using the selenium functionality
       login_username.sendKeys(user);
    }

    //entering in the password
    public void enterPassword(String password) throws Exception {
        //type the password using the selenium functionality
        login_password.sendKeys(password);
    }

    //click the login button
    public void clickLogin() throws Exception {
        login_loginbtn.click();
    }
}
