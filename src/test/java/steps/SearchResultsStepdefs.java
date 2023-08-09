package steps;

import context.Context;
import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.SearchResultsPage;

public class SearchResultsStepdefs {
    TestContext testContext;
    SearchResultsPage searchResultsPage;

    public SearchResultsStepdefs(TestContext context){
        testContext = context;
        searchResultsPage = context.getPageObjectManager().getSearchResultsPage();
    }
    
    @And("the user verifies the results are displayed with relevant products")
    public void theUserVerifiesTheResultsAreDisplayedWithRelevantProducts() {
        String keywords = testContext.getScenarioContext().getContext(Context.SEARCH_KEYWORDS).toString();

        Assert.assertTrue(searchResultsPage.getTitle().contains(keywords),
                "Page does not contain keywords " + keywords + "in the title.");
        Assert.assertTrue(searchResultsPage.getUrl().contains(keywords.replace(" ", "+")),
                "Page URL does not contain keywords: ".concat(keywords));
        Assert.assertTrue(searchResultsPage.getKeywordsSpanText().contains(keywords),
                "Keywords are not displayed in the page.");
    }

    @When("the user opens product listed in the position {string}")
    public void theUserOpensProductListedInThePosition(String position) {
        searchResultsPage.openResultItem(Integer.parseInt(position));
    }
}
