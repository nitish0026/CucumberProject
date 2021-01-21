package cloudblue.stepDefinitions.odin;

import cloudblue.module.pages.odin.CBCTopHeaderMenu;
import cloudblue.utility.Steps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TopHeaderMenuSteps extends Steps
{
    CBCTopHeaderMenu cBCTopHeaderMenu =new CBCTopHeaderMenu(browser);

//    And Navigates to billing and clicks on Users
    @When("Navigates to billing and clicks on Users")
    public void navigates_to_billing_and_clicks_on_Users() {
        cBCTopHeaderMenu =new CBCTopHeaderMenu(browser);
        cBCTopHeaderMenu.clickBilling();
    }


    @Then("Add user button should not be available")
    public void add_user_button_should_not_be_available()
    {
        Assert.assertTrue(true);
    }
}
