package cloudblue.utility;

import cloudblue.utility.browser.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Pagination<T> extends Pages implements PaginationAnnotation {
    int currentPage = 0;
    protected WebElement nextButton;
    protected WebElement previousButton;
    protected List<WebElement> pageNumbers;

    public Pagination(Browser browser) {
        super(browser);
    }

    protected void setNextButton(WebElement nextButton) {
        this.nextButton = nextButton;
    }
    protected void setPreviousButton(WebElement previousButton){
        this.previousButton = previousButton;
    }
    protected void setPageNumbers(List<WebElement> pageNumbers){
        this.pageNumbers = pageNumbers;
    }


    @Override
    public T next() {
        nextButton.click();
        currentPage++;
        return (T)this;
    }

    @Override
    public T previous() {
        previousButton.click();
        currentPage--;
        return (T)this;
    }

    @Override
    public T moveTo(int page_number) {
        for (WebElement page : pageNumbers ){
            if (page.getText().trim().equalsIgnoreCase(String.valueOf(page_number))) {
                page.click();
                currentPage = page_number;
                break;
            }
        }
        return (T)this;
    }

    @Override
    public int totalPage() {
        return pageNumbers.size();
    }

    @Override
    public int currentPage() {
        return currentPage;
    }
}
