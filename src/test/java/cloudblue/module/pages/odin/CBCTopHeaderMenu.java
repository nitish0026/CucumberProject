package cloudblue.module.pages.odin;

import cloudblue.utility.Pages;
import cloudblue.utility.browser.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class CBCTopHeaderMenu extends Pages {

    Browser browser;
    public CBCTopHeaderMenu(Browser browser)
    {
        super(browser);
        PageFactory.initElements(browser.getDriver(),this);
        browser.switchToFrame("topFrame");
    }

    @FindBy(name="topFrame")
    private WebElement top_frame;

    @FindBy(id="topTxtToBM")
    private WebElement billing_btn;

    public void clickBilling(){
        billing_btn.click ();
    }

    @FindBy(id="topTxtToCP")
    private WebElement hostingCP_btn;

    public void clickHostingCP() throws Exception {
        Thread.sleep (5000);
        hostingCP_btn.click ();
    }

    @FindBy(id="topTxtPersonal")
    private WebElement myProfile_btn;

    public void clickMyprofile() throws Exception {
        Thread.sleep (5000);
        myProfile_btn.click ();
    }

    @FindBy(id="topTxtHelp")
    private WebElement documentation_btn;

    public void clickDocumentation() throws Exception {
        Thread.sleep (5000);
        documentation_btn.click ();
    }

    @FindBy(id="topTxtLogout")
    private WebElement logout_btn;

    public void clickLogout() {
        logout_btn.click ();
    }
}
