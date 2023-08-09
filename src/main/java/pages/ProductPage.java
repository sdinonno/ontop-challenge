package pages;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {

    @FindBy(id = "productTitle")
    private WebElement productTitle;

    @FindBy(css = ".apexPriceToPay .a-offscreen")
    private WebElement productPrice;

    @FindBy(css = "#averageCustomerReviews_feature_div a.a-popover-trigger span.a-size-base")
    private WebElement productRating;

    @FindBy(css = "#renewedProgramDescriptionAtf_feature_div  h5")
    private WebElement productDescriptionTitle;

    @FindBy(css = "#renewedProgramDescriptionAtf_feature_div  span")
    private WebElement productDescription;

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

        String title = productTitle.getText();
        String descriptionTitle = productDescriptionTitle.getText();
        String description = productDescription.getText();
        String url = getUrl();

        return new Product(title, price, rating, descriptionTitle, description, url);
    }

    private Double extractPrice(String priceText) {
        try {
            return Double.parseDouble(priceText.replace("US$", ""));
        } catch (NumberFormatException e) {
            // Handle the exception appropriately (e.g., log an error, provide a default value)
            return 0.00; // Default value for price if parsing fails
        }
    }

    private Double extractRating(String ratingText) {
        try {
            return Double.parseDouble(ratingText);
        } catch (NumberFormatException e) {
            // Handle the exception appropriately (e.g., log an error, provide a default value)
            return 0.0; // Default value for rating if parsing fails
        }
    }
}
