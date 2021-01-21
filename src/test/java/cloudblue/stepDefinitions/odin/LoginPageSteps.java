package cloudblue.stepDefinitions.odin;

import cloudblue.module.pages.odin.CBCLoginPage;
import cloudblue.utility.Steps;
import cloudblue.utility.dataProvider.DataReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginPageSteps extends Steps {
    CBCLoginPage cbcLoginPage;

    @Given("Open the Odin Login Page")
    public void open_the_Odin_Login_Page() {
        browser.navigateTo();
        cbcLoginPage = new CBCLoginPage(browser);
    }

    @When("Login in Odin with {string} and {string}")
    public void login_in_Odin_with_and(String username, String password) {
        cbcLoginPage.login(username,password);
    }

    @When("The user login with reseller credentials")
    public void the_user_login_with_reseller_credentials()
    {
        cbcLoginPage = new CBCLoginPage(browser);
        cbcLoginPage.login(DataReader.get("username"),DataReader.get("password"));
    }
}
