package cloudblue.module.pages.odin;

import cloudblue.utility.Pages;
import cloudblue.utility.browser.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CBCNavigationMenuPage extends Pages {
    public CBCNavigationMenuPage(Browser browser) {
        super(browser);
        browser.switchToFrame(menuFrame);
    }

    @FindBy(name = "leftFrame") private WebElement menuFrame;
    @FindBy(xpath = "//b[text()='Customers']") private WebElement customerLink;
    @FindBy(xpath = "//b[text()='Resellers']") private WebElement resellerLink;
    @FindBy(xpath = "//b[text()='Subscriptions']") private WebElement subscriptionsLink;
    @FindBy(xpath = "//b[text()='Service Templates']") private WebElement servicetemplatesLink;
    @FindBy(xpath = "//b[text()='Resources']") private WebElement resourcesLink;
    @FindBy(xpath = "//b[text()='Domains']") private WebElement domainsLink;
    @FindBy(xpath = "//b[text()='Applications']") private WebElement applicationsLink;
    @FindBy(xpath = "//b[text()='Domain Registrars']") private WebElement domainRegistrarsLink;
    @FindBy(xpath = "//b[text()='Service Nodes']") private WebElement serviceNodesLink;
    @FindBy(xpath = "//b[text()='IP Addresses']") private WebElement ipAddressesLink;
    @FindBy(xpath = "//b[text()='Information']") private WebElement informationLink;
    @FindBy(xpath = "//b[text()='Users']") private WebElement usersLink;
    @FindBy(xpath = "//b[text()='Announcements']") private WebElement announcementsLink;
    @FindBy(xpath = "//b[text()='Settings']") private WebElement settingsLink;

    @FindBy(xpath = "//*[contains(@class,'left-search-input')]")
    private WebElement leftFrameSearchBox ;
    @FindBy(xpath = "//*[contains(@class,'left-search-button-clear')]")
    private WebElement leftFrameSearchClearButton ;

    public CBCNavigationMenuPage load() {
        browser.switchToFrame(menuFrame);
        return this;
    }

    public CBCCustomerPage openCustomerPage()
    {   waitForPageLoaded();
        waitForExists(customerLink,20);
        customerLink.click();
        wait(3);
        return new CBCCustomerPage(browser);
    }

    public void openResellerPage(){
       resellerLink.click();
       waitForPageLoaded();
        waitForExists(resellerLink,4000);
    }
    public void openSubscriptionPage(){
        subscriptionsLink.click();
        wait(3);
    }
    public void openServiceTemplatePage(){
        servicetemplatesLink.click();
        wait(3);
    }
    public void openResourcesPage(){
        resourcesLink.click();
        wait(3);
    }
    public void openDomainsPage(){
        domainsLink.click();
        wait(3);
    }
    public void openApplicationsPage(){
        applicationsLink.click();
        wait(3);
    }
    public void openDomainRegistrarsPage(){
        domainRegistrarsLink.click();
        wait(3);
    }
    public void openServiceNodesPage(){
        serviceNodesLink.click();
        wait(3);
    }
    public void openIpAddressPage(){
        ipAddressesLink.click();
        wait(3);
    }
    public void openInformationPage(){
        informationLink.click();
        wait(3);
    }
    public void openUsersPage(){
        usersLink.click();
        wait(3);
    }
    public void openAnnouncementsPage(){
        announcementsLink.click();
        wait(3);
    }
    public void openSettingsPage(){
        settingsLink.click();
        wait(3);
    }



}
