package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage extends BasePage {
    @FindBy(css = ".s-result-list  .s-card-container h2")
    private List<WebElement> resultsTitle;

    @FindBy(css = ".s-desktop-toolbar .a-text-bold")
    private WebElement keywordSpan;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to open an item from the search result page by position.
     * @param position Position in the result page.
     */
    public void openResultItem(Integer position) {
        WebElement item = getElementFromList(resultsTitle, position-1);
        scrollToViewElementAtTheTop(item);
        clickElement(item);
    }

    /**
     * Method to open an item from the search result page by text.
     * @param keywords Keywords to find in the item.
     */
    public void openResultItem(String keywords) {
        clickElement(getElementFromList(resultsTitle, keywords));
    }

    /**
     * Method to get span element text.
     * @return text.
     */
    public String getKeywordsSpanText(){
        return keywordSpan.getText();
    }
}
