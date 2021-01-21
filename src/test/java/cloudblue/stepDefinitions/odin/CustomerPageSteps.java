package cloudblue.stepDefinitions.odin;

import cloudblue.module.pages.odin.CBCCustomerDetailsPage;
import cloudblue.module.pages.odin.CBCCustomerPage;
import cloudblue.module.pages.odin.CBCNavigationMenuPage;
import cloudblue.utility.Steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;

public class CustomerPageSteps extends Steps {
    CBCCustomerPage cBCCustomerPage;
    CBCCustomerDetailsPage cBCCustomerDetailsPage;

    @Given("Open Customer Page")
    public void open_Customer_Page() {
        CBCNavigationMenuPage cBCNavigationMenuPage = new CBCNavigationMenuPage(browser);
        cBCCustomerPage = cBCNavigationMenuPage
                .load()
                .openCustomerPage()
                .load();
    }

    @Then("Search Customer By Id {string}")
    public void search_Customer_By_Id(String id) {
        cBCCustomerPage
            .searchWithId(id)
            .readCustomerIds();
    }

    @Then("Search Customer By Company {string}")
    public void search_Customer_By_Company(String string) {
        List<String> customerIds = cBCCustomerPage.searchWithId("").readCustomerIds();
        customerIds.contains("454");
    }

    @Then("Search Customer By Id {string} And Goto Details Page")
    public void search_Customer_By_Id_And_Goto_Details_Page(String id) {
        cBCCustomerDetailsPage = cBCCustomerPage
                .searchWithId(id)
                .openDetailsPage();
    }

    @Then("Search Customer By Company {string} And Goto Details Page")
    public void search_Customer_By_Company_And_Goto_Details_Page(String string) {
        cBCCustomerPage.searchWithId("").openDetailsPageById("");
    }

    @Then("Customer Details Page Validate Customer ID {string}")
    public void customer_details_page_validate_customer_id_something(String id) {
        String validateId = cBCCustomerDetailsPage.readCustomerId();
        Assert.assertEquals(id, validateId);
    }

    @Then("Search Customer By Id {string} And Login As Customer")
    public void search_Customer_By_Id_And_Login_As_Customer(String id) {
        cBCCustomerPage
            .searchWithId(id)
            .loginAsCustomer();
    }
}
