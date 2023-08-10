package context;

import managers.DriverManager;
import managers.PageObjectManager;

/**
 * TestContext class for sharing data and state among steps in Selenium-Cucumber automated tests.
 */
public class TestContext {
    private final DriverManager webDriverManager;
    private final PageObjectManager pageObjectManager;
    private ScenarioContext scenarioContext;

    public TestContext(){
        webDriverManager = new DriverManager();
        pageObjectManager = new PageObjectManager(DriverManager.getDriver());
        scenarioContext = new ScenarioContext();
    }

    public DriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
