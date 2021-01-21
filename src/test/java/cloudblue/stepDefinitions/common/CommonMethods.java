package cloudblue.stepDefinitions.common;

import cloudblue.module.pages.uxone.UXL2AccountsPage;
import cloudblue.module.pages.uxone.UXLeftSideBar;
import cloudblue.utility.browser.Browser;

import java.util.Random;

public class CommonMethods {

    /**
     * Gives randomly created number in string format of specified length
     * @param length : length of the string of number
     * @return String containing only numeric data
     */
    public String getRandomNum(int length)
    {
        Random rand = new Random ();
        String outputString = "";
        for(int i= 0; i < length; i++)
        {
            outputString+=( rand.nextInt(8) + 1)+"";
        }
        return outputString;
    }

    /*Cancelling the provisioned subscription from L2 UX1
    Given the the User has already logged in and in the L2 Ux1 page
    * */

    public void subscriptionCancellation(String subscrptionId, Browser browser) throws Exception {
        UXLeftSideBar uxLeftSideBar = new UXLeftSideBar(browser);
        uxLeftSideBar.clickUX1Accounts();
        UXL2AccountsPage uxl2AccountsPage = new UXL2AccountsPage(browser);
        uxl2AccountsPage.viewSubscriptions();
        uxl2AccountsPage.matchAndClickOnSubscriptionIdForCancellation(subscrptionId);
    }
}
