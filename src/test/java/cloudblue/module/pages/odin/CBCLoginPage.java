package cloudblue.module.pages.odin;

import cloudblue.utility.Pages;
import cloudblue.utility.browser.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class will have all the elements of login page of CBC platform
 * along with methods that are required to be performed from step definition
 */
public class CBCLoginPage extends Pages {

    @FindBy(id = "inp_user")
    private WebElement userNameField;
    @FindBy(id = "inp_password")
    private WebElement passwordField;
    @FindBy(id = "login")
    private WebElement loginButton;
    @FindBy(xpath = "//a[contains(text(),'Forgot')]")
    private WebElement forgotPasswordLink;

    public CBCLoginPage(Browser browser) {
        super(browser);
    }

    /**
     * method to login to cbc platform with username and password available
     *
     * @param userName
     * @param password
     */
    public void login(String userName, String password) {
        waitForPageLoaded();
        userNameField.clear();
        userNameField.sendKeys(userName);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
    }

    /**
     * Method to click on forgot password link
     */
    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }
}
