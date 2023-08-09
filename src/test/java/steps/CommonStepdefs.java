package steps;

import context.TestContext;
import io.cucumber.java.en.And;
import pages.HomePage;

public class CommonStepdefs {
    TestContext testContext;
    HomePage homePage;
    public CommonStepdefs(TestContext context){
        homePage = context.getPageObjectManager().getHomePage();
    }
    @And("the user navigates back")
    public void theUserNavigatesBack() {
        homePage.navigateBack();
    }
}
