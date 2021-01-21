package cloudblue.stepDefinitions;

import cloudblue.module.pages.odin.CBCCustomerPage;
import cloudblue.module.pages.odin.CBCLoginPage;
import cloudblue.module.pages.odin.CBCNavigationMenuPage;
import cloudblue.module.pages.uxone.UXHeaderMenu;
import cloudblue.module.pages.uxone.UXL2CustomersPage;
import cloudblue.module.pages.uxone.UXLeftSideBar;
import cloudblue.stepDefinitions.common.CommonMethods;
import cloudblue.utility.Pages;
import cloudblue.utility.dataProvider.DataReader;
import cloudblue.utility.dataProvider.RunTimeDataProvider;
import cloudblue.module.pages.Login;
import cloudblue.module.pages.LoginPageFactory;
import cloudblue.reports.ReportManager;
import cloudblue.utility.LogUtil;
import cloudblue.utility.Steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginTest extends Steps {
    LogUtil log = new LogUtil();
    private  Login login;
    @Given("The homepage")
    public void the_homepage() throws Exception {
        browser.navigateTo();
    }

    @When("User enters {string} and {string}")
    public void user_enters_and(String string, String string2) throws Throwable {
        login=new Login(browser);
        RunTimeDataProvider.store("customer_id", "CB001");
        System.out.println(RunTimeDataProvider.get("logintest_customer_id"));
        login.enterUsername(string);
        login.enterPassword(string2);
        login.clickLogin();
    }

    @Then("User should be in the homepage")
    public void user_should_be_in_the_homepage() throws Exception {
        // home page
    }

    @Given("^The user enters url \"([^\"]*)\"$")
    public void the_user_enters_url_something(String strArg1) throws Throwable {
        browser.navigateTo(strArg1);
        System.out.println(DataReader.get("order_id"));
//        driver=browser.getDriver();
    }

    @Then("^The word \"([^\"]*)\" should be displayed$")
    public void the_word_something_should_be_displayed(String strArg1) throws Throwable {
        LoginPageFactory loginPageFactory=new LoginPageFactory(browser);
        System.out.println(RunTimeDataProvider.get("logintest_customer_id"));
        loginPageFactory.clickOn();
    }

    @Given("^The Sp/L2 User able to login$")
    public  void The_homepage001() throws Exception {
        browser.navigateTo("http://cp.us.dev.na.cloud.im");
    }

    @Then("^It can create a customer$")
    public  void the_user_is_logged_in() throws Exception {

        Pages pages= new Pages(browser);
        CBCLoginPage cbcLoginPage = new CBCLoginPage(browser);
        cbcLoginPage.login("TestRnD31968","uBU1k=ZcXu");
        pages.waitForPageLoaded();
//        UXLeftSideBar ux1LeftSideBar = new UXLeftSideBar(browser);
//        ux1LeftSideBar.clickUX1Customer();
//        pages.waitForPageLoaded();
//        pages.wait(5);
//        UXL2CustomersPage ux1L2CustomersPage= new UXL2CustomersPage(browser);
//        ux1L2CustomersPage.viewCustomers();
//        ux1L2CustomersPage.addCustomerButton();
//        ux1L2CustomersPage.selectBusinessAccount();
//        ux1L2CustomersPage.enterFirstName("aaaaa");
//        ux1L2CustomersPage.enterLastName("bbbbbb");
//        ux1L2CustomersPage.enterCity("cccccc");
//        ux1L2CustomersPage.enterLoginName("xxxxxx");
//        ux1L2CustomersPage.enterLoginPassword("Independent12#");
//        ux1L2CustomersPage.selectCountry("India");
//        UXHeaderMenu uxHeaderMenu = new UXHeaderMenu(browser);
//        browser.driver().switchTo().parentFrame();
//        uxHeaderMenu.clickClassicPanel();
//        browser.switchToNextTab();
//        pages.waitForPageLoaded();
//        pages.wait(3);
//        CBCNavigationMenuPage cbcNavigationMenuPage = new CBCNavigationMenuPage(browser);
//        cbcNavigationMenuPage.openCustomerPage();
//        CBCCustomerPage cbcCustomerPage = new CBCCustomerPage(browser);
//        cbcCustomerPage.searchWithCompanyName("cccccc");
//        Assert.assertTrue(cbcCustomerPage.readCustomerIds().isEmpty(),"Customer is Not Created");
        CommonMethods commonMethods = new CommonMethods();
        commonMethods.subscriptionCancellation("1322580" , browser);





    }

}
