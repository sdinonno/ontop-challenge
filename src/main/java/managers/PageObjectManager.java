package managers;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;

/**
 * Page Object Manager create the page's object and make sure that
 * the same object should not be created again and again.
 */

public class PageObjectManager {
    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;
    private SearchResultsPage searchResultsPage;
    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }
    public ProductPage getProductPage() {
        return (productPage == null) ? productPage = new ProductPage(driver) : productPage; }

    public SearchResultsPage getSearchResultsPage() {
        return (searchResultsPage == null) ? searchResultsPage = new SearchResultsPage(driver) : searchResultsPage; }
}
