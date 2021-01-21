package cloudblue.stepDefinitions.uxone;

import cloudblue.module.pages.uxone.UXCustomerHomePage;
import cloudblue.utility.Steps;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CustomerHomePageSteps extends Steps {
    UXCustomerHomePage uXCustomerHomePage;

    @Then("Validate UxOne Home Page Title {string}")
    public void validate_UxOne_Home_Page_Title(String title) {
        uXCustomerHomePage = new UXCustomerHomePage(browser);
        String validateTitle = uXCustomerHomePage.readTitle();
        Assert.assertEquals(title, validateTitle);
    }
}
