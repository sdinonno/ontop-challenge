package steps;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import context.Context;
import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import models.Product;
import org.testng.Assert;
import pages.ProductPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static steps.Hooks.test;
import static utils.Screenshots.takeScreenshot;

public class ProductStepdefs {
    TestContext testContext;
    ProductPage productPage;
    private List<Product> products;

    public ProductStepdefs(TestContext context){
        this.testContext = context;
        this.productPage = context.getPageObjectManager().getProductPage();
        this.products = new ArrayList<>();
    }
    @And("the user validates the product details")
    public void theUserValidatesTheProductDetails() throws IOException {
        String keywords = (String) testContext.getScenarioContext().getContext(Context.SEARCH_KEYWORDS);
        Product product = productPage.getProductDetails();

        Assert.assertTrue(product.getTitle()
                .contains(keywords), "Product title does not contain the keywords ".concat(keywords));
        Assert.assertTrue(product.getPrice() > 0.0, "Product price is 0");
        Assert.assertFalse(product.getDescription().isEmpty(), "Product description is empty.");
        takeScreenshot(product.getTitle());
        products.add(product);
    }

    @Then("the user validates the products are different")
    public void theUserValidatesTheProductsAreDifferent() {
        Product firstProduct = products.get(0);
        Product secondProduct = products.get(1);
        Assert.assertNotEquals(firstProduct, secondProduct, "Products are equals.");
    }
}
