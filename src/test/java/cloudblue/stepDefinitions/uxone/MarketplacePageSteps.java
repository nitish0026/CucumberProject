package cloudblue.stepDefinitions.uxone;

import cloudblue.module.pages.odin.CBCLoginPage;
import cloudblue.module.pages.uxone.UXMarketplacePage;
import cloudblue.utility.Steps;
import cloudblue.utility.dataProvider.DataReader;
import io.cucumber.java.en.Then;

public class MarketplacePageSteps extends Steps {

     UXMarketplacePage uxMarketplacePage;
    @Then("user search for Sub Category Name")
    public void user_search_for_Sub_Category_Name() throws InterruptedException {

        uxMarketplacePage = new UXMarketplacePage (browser);
        uxMarketplacePage.categorySearch (DataReader.get("subCategoryName"));

    }
}
