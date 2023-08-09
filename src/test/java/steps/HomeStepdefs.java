package steps;

import context.Context;
import context.TestContext;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import pages.HomePage;

public class HomeStepdefs {
    TestContext testContext;
    HomePage homePage;

    public HomeStepdefs(TestContext context){
        testContext = context;
        homePage = context.getPageObjectManager().getHomePage();
    }
    @Given("the user is in the Home page")
    public void theUserIsInTheHomePage() {
        Assert.assertTrue(homePage.getTitle().contains("Amazon"), "'Amazon' is not displayed in the title.");
        Assert.assertTrue(homePage.getUrl().contains("amazon.com"), "'amazon.com' does not appear in the URL.");
    }

    @Given("the user performs a search with keywords {string}")
    public void theUserPerformsASearchWithKeywords(String keywords) {
        homePage.performSearch(keywords);
        testContext.getScenarioContext().setContext(Context.SEARCH_KEYWORDS, keywords);
    }
}