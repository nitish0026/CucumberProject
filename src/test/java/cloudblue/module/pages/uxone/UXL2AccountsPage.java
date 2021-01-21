package cloudblue.module.pages.uxone;

import cloudblue.utility.Pages;
import cloudblue.utility.browser.Browser;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UXL2AccountsPage extends Pages {
    public UXL2AccountsPage(Browser browser) {
        super(browser);
    } {
    }

    @FindBy(xpath = "//span[text()='Subscriptions']") private WebElement subscription;
    @FindBy(xpath = "//div[@id='subscription']//span[text()='Cancel Subscription']") private WebElement Cancel_Subscription;
    @FindBy(xpath = "//div[@id='all-subscriptions']//tbody/tr/td[1]") private List<WebElement> table;
    @FindBy(xpath = "//iframe[@id='http://www.parallels.com/ccp-billing']") private WebElement frame;
    @FindBy(xpath = "//textarea[contains(@class,'form-control')]") private WebElement textArea;
    @FindBy(xpath = "//button[@id='submitPopupNav']") private WebElement submitForCancellation;
    @FindBy(xpath = "//div[@id='all-subscriptions']//thead/tr/th") private WebElement title;
    @FindBy(xpath = "//div//iframe[@id='popup_http://www.parallels.com/ccp-billing']" ) private WebElement popup_frame ;



    /*Clicking to View Subscription
     * */
    public void viewSubscriptions() throws Exception {
        waitForPageLoaded();
        waitForExists(subscription,12);
        subscription.click();
    }


    /*Selecting Subscription for Cancellation
    Clicking to Canceling Subscription
    * */
    public void matchAndClickOnSubscriptionIdForCancellation(String cancelationSubscriptionId){
        browser.switchToFrame(frame);
        waitForPageLoaded();
        waitForExists(title,12);
        List<String> subscriptionIds = new ArrayList<>();
        for (WebElement id:table) {
            if(id.getText().trim().equals(cancelationSubscriptionId)){
                id.click();
                break ;
            }
        }
        waitForExists(Cancel_Subscription,20);
        Cancel_Subscription.click();
        wait(3);
        browser.switchToFrame(popup_frame);
        waitForExists(textArea,12);
        textArea.sendKeys(cancelationSubscriptionId);
        browser.driver().switchTo().parentFrame();
        submitForCancellation.click();

    }





}
