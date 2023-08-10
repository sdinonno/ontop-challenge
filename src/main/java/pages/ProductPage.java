package pages;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(id = "productTitle")
    private WebElement productTitle;

    @FindBy(css = ".apexPriceToPay .a-offscreen")
    private WebElement productPrice;

    @FindBy(css = "#averageCustomerReviews_feature_div a.a-popover-trigger span.a-size-base")
    private WebElement productRating;

    @FindBy(css = "#feature-bullets .a-spacing-mini span")
    private List<WebElement> descriptionItems;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        waitVisibilityOfElement(productTitle);
    }

    /**
     * Method to create a Product object with the information found in the elements.
     * @return a Product object.
     */
    public Product getProductDetails() {
        String priceText = productPrice.getAttribute("innerText");
        String ratingText = productRating.getText();

        Double price = extractPrice(priceText);
        double rating = extractRating(ratingText);
        String url = getUrl();

        return new Product(getProductTitle(), price, rating, getDescription(), url);
    }

    private String getDescription(){
        List<String> texts = new ArrayList<>();
        for (WebElement e : descriptionItems) {
            texts.add(e.getText());
        }
        return String.join(" ", texts);
    }

    private String getProductTitle(){
        return productTitle.getText();
    }

    private Double extractPrice(String priceText) {
        try {
            return Double.parseDouble(priceText.replace("US$", "").replace(",", ""));
        } catch (NumberFormatException e) {
            System.err.println("Error when try to parse the price: " + e.getMessage());
            return 0.00;
        }
    }

    private Double extractRating(String ratingText) {
        try {
            return Double.parseDouble(ratingText);
        } catch (NumberFormatException e) {
            System.err.println("Error when try to parse the rating: " + e.getMessage());
            return 0.0;
        }
    }
}
