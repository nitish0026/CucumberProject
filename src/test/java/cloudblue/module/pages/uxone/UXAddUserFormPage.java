package cloudblue.module.pages.uxone;

import cloudblue.utility.Pages;
import cloudblue.utility.browser.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UXAddUserFormPage extends Pages {
    Browser browser;

    public UXAddUserFormPage(Browser browser) {
        super(browser);
        PageFactory.initElements(browser.getDriver(),this);
    }
    @FindBy(xpath = "//input[contains(@id,'addUser_givenName')]")
    private WebElement add_new_user_first_name_textbox;
    @FindBy(xpath = "//input[contains(@id,'addUser_familyName')]")
    private WebElement add_new_user_family_name_textbox;
    @FindBy(xpath = "//input[contains(@id,'addUser_email')]")
    private WebElement add_new_user_email_textbox;
    @FindBy(xpath = "//input[contains(@id,'addUser_aps.type.user')]")
    private WebElement add_new_user_assign_service_rights_radiobutton;
    @FindBy(xpath = "//input[contains(@id,'addUser_custom-notification-email')]")
    private WebElement add_new_user_custom_notification_email_checkbox;
    @FindBy(xpath = "//input[contains(@id,'addUser_notification-email')]")
    private WebElement add_new_user_notification_email_textbox;
    @FindBy(xpath = "//button[contains(@id,'addUser_add_button')]")
    private WebElement add_another_new_user_add_button;
    @FindBy(id = "addUser_send_invitationInput")
    private WebElement add_new_user_send_activation_email_checkbox;
    @FindBy(id = "nextNav")
    private WebElement add_new_user_finish_button;
    @FindBy(id = "cancelNav")
    private WebElement add_new_user_cancel_button;
}

