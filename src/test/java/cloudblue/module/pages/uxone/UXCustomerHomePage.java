package cloudblue.module.pages.uxone;

import cloudblue.utility.Pages;
import cloudblue.utility.browser.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UXCustomerHomePage extends Pages {
    public UXCustomerHomePage(Browser browser) {
        super(browser);
    }

    @FindBy(id = "ccp-title") private WebElement title;

    public String readTitle() {
        return title.getText().trim();
    }
}
