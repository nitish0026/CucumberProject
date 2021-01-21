package cloudblue.stepDefinitions.uxone;
import cloudblue.module.pages.odin.CBCCustomerPage;
import cloudblue.module.pages.odin.CBCLoginPage;
import cloudblue.module.pages.odin.CBCNavigationMenuPage;
import cloudblue.module.pages.uxone.UXHeaderMenu;
import cloudblue.module.pages.uxone.UXL2CustomersPage;
import cloudblue.module.pages.uxone.UXLeftSideBar;
import cloudblue.stepDefinitions.common.CommonMethods;
import cloudblue.utility.Pages;
import cloudblue.utility.Steps;
import cloudblue.utility.dataProvider.DataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Random;
import java.util.stream.IntStream;

public class CustomerCreationUxoneSteps extends Steps {

    CommonMethods commonMethods = new CommonMethods();
    String randomDigit = commonMethods.getRandomNum(4);

    @Given("^Login as L2 User$")
    public void Login_as_L2_User() throws Exception {
        browser.navigateTo(DataReader.get("loginUrl"));
//        CBCLoginPage cbcLoginPage = new CBCLoginPage(browser);
//        cbcLoginPage.login(DataReader.get("userName"),DataReader.get("password"));
    }
    @And("^Able to Create Customer$")
    public void It_can_create_customer() throws Exception {
        Pages pages = new Pages(browser);
        pages.waitForPageLoaded();
        UXLeftSideBar ux1LeftSideBar = new UXLeftSideBar(browser);
        ux1LeftSideBar.clickUX1Customer();
//        pages.waitForPageLoaded();
        //pages.wait(5);// Pa
        UXL2CustomersPage ux1L2CustomersPage = new UXL2CustomersPage(browser);
//        ux1L2CustomersPage.viewCustomers();
        ux1L2CustomersPage.addCustomerButton();
        ux1L2CustomersPage.selectBusinessAccount();
        ux1L2CustomersPage.enterFirstName(DataReader.get("firstName"));
        ux1L2CustomersPage.enterLastName(DataReader.get("lastName"));
        ux1L2CustomersPage.enterPhoneNo(DataReader.get("phoneNo"));
        ux1L2CustomersPage.enterEmailId(randomDigit+(DataReader.get("emailID")));
        ux1L2CustomersPage.enterCompanyName((DataReader.get("companyName"))+randomDigit);
        ux1L2CustomersPage.address(DataReader.get("address"));
        ux1L2CustomersPage.enterPostalCode(DataReader.get("postCode"));
        ux1L2CustomersPage.enterCity(DataReader.get("city"));
        ux1L2CustomersPage.selectCountry(DataReader.get("country"));
        ux1L2CustomersPage.selectstate(DataReader.get("state"));
        ux1L2CustomersPage.enterLoginName(DataReader.get(("loginName"))+randomDigit);
        ux1L2CustomersPage.enterLoginPassword(DataReader.get("loginPassword"));
        ux1L2CustomersPage.submitCustomerCreation();
    }
        @Then("^Created Customer can be validated$")
        public void It_can_validate_Created_Customer() throws Exception {
        UXHeaderMenu uxHeaderMenu = new UXHeaderMenu(browser);
        browser.driver().switchTo().parentFrame();
        uxHeaderMenu.clickClassicPanel();
        browser.switchToNextTab();
        Pages pages = new Pages(browser);
        pages.waitForPageLoaded();
        CBCNavigationMenuPage cbcNavigationMenuPage = new CBCNavigationMenuPage(browser);
        pages.waitForPageLoaded();
        pages.wait(3);
        cbcNavigationMenuPage.openCustomerPage();
        CBCCustomerPage cbcCustomerPage = new CBCCustomerPage(browser);
        cbcCustomerPage.searchWithCompanyName((DataReader.get("companyName"))+randomDigit);
        Assert.assertFalse("Customer is Not Created",cbcCustomerPage.readCustomerIds().isEmpty());

    }
}
