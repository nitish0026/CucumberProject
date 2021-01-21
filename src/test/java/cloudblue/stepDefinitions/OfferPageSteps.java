package cloudblue.stepDefinitions;

import cloudblue.module.pages.OfferPage;
import cloudblue.utility.Steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class OfferPageSteps extends Steps {
    OfferPage offerPage = new OfferPage(browser);

    @Given("Get All Offers")
    public void get_all_offers() {
        offerPage
            .offerTable()
            .pagination()
            .next()
            .refresh();
    }

    @Then("Find Offer {string}")
    public void find_Offer(String offerName) {
        OfferPage offerPage = new OfferPage(browser);
        boolean flag = offerPage
                .offerTable()
                .findByOfferName(offerName);
        Assert.assertTrue(flag);
    }

    @Then("Find Offer and goto details page  {string}")
    public void find_Offer_and_goto_details_page(String offerName) {
        OfferPage offerPage = new OfferPage(browser);
        String startDate = offerPage
                .offerTable()
                .getStartDatByOfferName(offerName);
        Assert.assertTrue(startDate.equalsIgnoreCase("2010/12/22"));
    }
}
