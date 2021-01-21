package cloudblue.module.pages.odin;

import cloudblue.utility.Pages;
import cloudblue.utility.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CBCCustomerPage extends Pages {
    // element for the customer page
    String mainFrame = "mainFrame";
    @FindBy(id = "list_search") private WebElement search_button;
    @FindBy(id = "header_id_0_field_id_0") private WebElement id_search_field;
    @FindBy(id = "header_id_1_field_id_0") private WebElement companyName_search_field;
    @FindBy(xpath = "//table[@id='global_list']/tbody/tr/td[1]") private List<WebElement> id_list;
    By actionButton = By.xpath("../td[last()]/a");
    By statusLabel = By.xpath("../td[7]");

    public CBCCustomerPage(Browser browser) {
        super(browser);
        browser.switchToFrame(mainFrame);
    }

    public CBCCustomerPage load() {
        browser.switchToFrame(mainFrame);
        return this;
    }

    public CBCCustomerDetailsPage openDetailsPageById(String id) {
        for (WebElement id_row : id_list ) {
            if( id_row.getText().trim().equalsIgnoreCase(id)) {
                id_row.click();
                break;
            }
        }
        return new CBCCustomerDetailsPage(browser);
    }

    public CBCCustomerDetailsPage openDetailsPage() {
        id_list.get(0).click();
        wait(5);
        return new CBCCustomerDetailsPage(browser);
    }

    public String readStatusById(String id) {
        String status = "";
        for (WebElement id_row:id_list) {
            if( id_row.getText().equalsIgnoreCase(id)) {
                status = id_row.findElement(statusLabel).getText().trim();
                break;
            }
        }
        return status;
    }
    public void loginAsCustomer() {
        id_list.get(0).findElement(actionButton).click();
        wait(5);
        browser.switchToLastTab();
    }

    public List<String> readCustomerIds() {
        List<String> customerIds = new ArrayList<>();
        for (WebElement id:id_list) {
            customerIds.add(id.getText().trim());
        }
        return customerIds;
    }
    public List<String> readCompanyNames() {
        // return all company name as a String list
        return null;
    }


    public CBCCustomerPage searchWithId(String id) {
        id_search_field.clear();
        id_search_field.sendKeys(id);
        search_button.click();
        return this;
    }

/*To Search Customer with CompanyName
* */
    public CBCCustomerPage searchWithCompanyName(String companyName) throws Exception {

        waitForExists(companyName_search_field,10);
        companyName_search_field.clear();
        companyName_search_field.sendKeys(companyName);
        search_button.click();
        return this;
    }

}
