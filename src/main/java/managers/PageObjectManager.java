package managers;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;

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
