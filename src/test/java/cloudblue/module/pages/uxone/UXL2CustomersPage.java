package cloudblue.module.pages.uxone;

import cloudblue.utility.Pages;
import cloudblue.utility.browser.Browser;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UXL2CustomersPage extends Pages {
    public UXL2CustomersPage(Browser browser) {
        super(browser);
    }

    @FindBy(xpath = "//span[@class='list-group-item-text'][text()='Customers']") private WebElement customers;
//    @FindBy(xpath = "//span[text()='Add New Customer']") private WebElement addCustomer;
    @FindBy(xpath = "//div[contains(text(),'Add account')]") private WebElement addCustomer;
    @FindBy(xpath = "//div[@ccp-container='true']//iframe[@name='http://www.parallels.com/ccp-billing']")private WebElement contentFrame ;
    @FindBy(xpath = "//span[text()='Personal Account']") private WebElement selectPersonalAccount;
    @FindBy(xpath = "//span[text()='Business Account']") private WebElement selectBusinessAccount;
    @FindBy(xpath = "//input[@id='ux1AddCustomer_adminFirstName']") private WebElement firstName;
    @FindBy(xpath = "//input[@id='ux1AddCustomer_adminLastName']") private WebElement lastName;
    @FindBy(xpath = "//input[@id='ux1AddCustomer_adminPhone']") private WebElement phoneNo;
    @FindBy(xpath = "//input[@id='ux1AddCustomer_adminEmail']") private WebElement emailId;
    @FindBy(xpath = "//input[@id='ux1AddCustomer_streetAddress']") private WebElement streetAddress;
    @FindBy(xpath = "//input[@id='ux1AddCustomer_companyName']") private WebElement companyName;
    @FindBy(xpath = "//input[@id='ux1AddCustomer_zip']") private WebElement zipCode;
    @FindBy(xpath = "//input[@id='ux1AddCustomer_locality']") private WebElement city;
    @FindBy(xpath = "//input[@id='ux1AddCustomer_country']") private WebElement country;
    @FindBy(xpath = "//input[@id='ux1AddCustomer_region']") private WebElement state;
    @FindBy(xpath = "//input[@id='ux1AddCustomer_userLogin']") private WebElement loginName;
    @FindBy(xpath = "//input[@id='ux1AddCustomer_userPassword_textbox']") private WebElement password;
    @FindBy(xpath = "//button[@id='submitNav']") private WebElement submitButton;


    /*Clicking to View Customers
    * */
    public void viewCustomers() throws Exception {
        waitForPageLoaded();
        waitForExists(customers,12);
        customers.click();
    }

    /*Clicking to add New Customer
     * */
    public void addCustomerButton() throws Exception {
        waitForPageLoaded();
//        waitForExists(contentFrame,12);
//        browser.switchToFrame(contentFrame);
        untilJqueryIsDone(browser.driver());
        addCustomer.click();}

    /*Selecting Account type
     * */
    public void selectPersonalAccount () {
        waitForExists(selectPersonalAccount,10);
        selectPersonalAccount.click();}

    /*Selecting Account type
     * */
    public void selectBusinessAccount() {
        waitForExists(selectBusinessAccount,10);
        selectBusinessAccount.click();}

    /*Enter the FirstName
     * */
    public void enterFirstName(String first_Name) {firstName.sendKeys(first_Name);}

    /*Enter the LastName
     * */
    public void enterLastName(String last_Name) {lastName.sendKeys(last_Name);}

    /*Enter the PhoneNo
     * */
    public void enterPhoneNo(String phone_No) { phoneNo.sendKeys(phone_No);}

    /*Enter EmailId
     * */
    public void enterEmailId(String email_Id) { emailId.sendKeys(email_Id);}

    /*Enter Company Name
     * */
    public void enterCompanyName(String company_Name) { companyName.sendKeys(company_Name);
    }

    /*Enter Street Address
     * */
    public void address(String street_Address) { streetAddress.sendKeys(street_Address);
    }

    /*Enter PostCode Name
     * */
    public void enterPostalCode(String post_Code) { zipCode.sendKeys(post_Code);
    }

    /*Enter Customer's City
     * */
    public void enterCity(String city_Name) { city.sendKeys(city_Name);
    }

    /*Select Country Name From List
     * */
    public void selectCountry(String country_Name) throws InterruptedException {

        country.clear();
        country.sendKeys(country_Name);
        country.click();
        wait(1);
        country.sendKeys(Keys.ARROW_DOWN);
        country.sendKeys(Keys.ENTER);
    }

    /*Select Country Name From List
     * */
    public void selectstate(String state_Name) throws InterruptedException {

        state.clear();
        state.sendKeys(state_Name);
        state.click();
        wait(1);
        state.sendKeys(Keys.ARROW_DOWN);
        state.sendKeys(Keys.ENTER);
    }

    /*Enter Login Name
     * */
    public void enterLoginName(String login_Name) { loginName.sendKeys(login_Name);
    }

    /*Enter Login Password
     * */
    public void enterLoginPassword(String login_Password) {
        password.clear();
        password.sendKeys(login_Password);
    }

    /*Click Submit Button
     * */
    public void submitCustomerCreation() {
        browser.driver().switchTo().parentFrame();
        submitButton.click();
    }

}
