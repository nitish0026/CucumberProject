package cloudblue.module.pages;

import cloudblue.utility.DataTable;
import cloudblue.utility.Pages;
import cloudblue.utility.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OfferPage extends Pages {
    public OfferPage(Browser browser) {
        super(browser);
    }

    public OfferTable offerTable() {
        return new OfferTable();
    }


    public class OfferTable implements DataTable<OfferTable> {
        String _offerName;

        @FindBy(xpath = "//table[@id='example']/tbody/tr/td[1]") protected List<WebElement> offerNames;
        @FindBy(xpath = "//table[@id='example']/tbody/tr/td[2]") private List<WebElement> position;
        By startDate = By.xpath("//td[contains(text(),'$offerName')]/../td[5]");

        public OfferTable(){
            PageFactory.initElements(browser.getDriver(),this);
        }

        @Override
        public OfferTable refresh() {
            PageFactory.initElements(browser.getDriver(), this);
            return this;
        }

        public boolean findByOfferName(String offerName) {
            boolean found = false;
            do {
                for (WebElement offer : offerNames) {
                    if (offer.getText().trim().equalsIgnoreCase(offerName)) {
                        found = true;
                        break;
                    }
                }
                if( !found )
                    offerTable().pagination().next().refresh();
            }while( ! found );
            return found;
        }
        public void findByOfferNameAndClick(String offerName) {
            boolean found = false;
            do {
                for (WebElement offer : offerNames) {
                    if (offer.getText().trim().equalsIgnoreCase(offerName)) {
                        found = true;
                        offer.click();
                        break;
                    }
                }
                if( !found )
                    offerTable().pagination().next().refresh();
            }while( ! found );
        }
        public String getStartDatByOfferName(String offerName) {
            this._offerName = offerName;
            if( findByOfferName(offerName) )
                return browser
                        .getDriver()
                        .findElement(By.xpath("//td[contains(text(),'"+ offerName+"')]/../td[5]"))
                        .getText()
                        .trim();
            else
                throw new NotFoundException("Offer Not Found : " + offerName);
        }

        public class OfferTablePagination {
            private int currentPage = 0;
            @FindBy(id = "example_next") private WebElement nextButton;
            @FindBy(id= "example_previous") private WebElement previousButton;
            @FindBy(css = "span a.paginate_button") private List<WebElement> pageNumbers;

            public OfferTablePagination() {
                PageFactory.initElements(browser.getDriver(), this);
            }

            public OfferTable next() {
                nextButton.click();
                currentPage++;
                return OfferTable.this;
            }

            public OfferTable previous() {
                previousButton.click();
                currentPage--;
                return OfferTable.this;
            }

            public OfferTable moveTo(int page_number) {
                for (WebElement page : pageNumbers ){
                    if (page.getText().trim().equalsIgnoreCase(String.valueOf(page_number))) {
                        page.click();
                        currentPage = page_number;
                        break;
                    }
                }
                return OfferTable.this;
            }
            public int totalPage() {
                return pageNumbers.size();
            }
            public int currentPage() {
                return currentPage;
            }
        }

        public OfferTablePagination pagination() {
            return new OfferTablePagination();
        }
    }
}
