package cloudblue.module.pages.odin;

import cloudblue.utility.Pages;
import cloudblue.utility.browser.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CBCCustomerDetailsPage extends Pages {
    public CBCCustomerDetailsPage(Browser browser) {
        super(browser);
    }

    @FindBy(xpath = "//div[text()='Name']/following-sibling::div/div") private WebElement cusotmerName;
    @FindBy(xpath = "//div[text()='ID']/following-sibling::div/div") private WebElement customerId;
    @FindBy(xpath = "//div[text()='State']/following-sibling::div/div") private WebElement state;

    public String readCustomerName() {
        return cusotmerName.getText().trim();
    }

    public String readCustomerId() {
        return customerId.getText().trim();
    }

}
