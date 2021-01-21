package cloudblue.stepDefinitions.common;

import cloudblue.utility.Steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonSteps extends Steps {
    @Given("Open The App Login Page.")
    public void open_The_App_Login_Page() {
        browser.navigateTo("http://www.google.com");
    }

    @Given("Open url {string}")
    public void open_url(String url) {
        browser.navigateTo(url);
    }

    //Steps to navigate to CBC url
    @Given("User is on CBC Login Page")
    public void user_is_on_CBC_Login_Page() {
        browser.navigateTo();
    }

}
