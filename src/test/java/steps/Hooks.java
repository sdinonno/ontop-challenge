package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static managers.DriverManager.quitDriver;
import static utils.Screenshots.takeScreenshot;

public class Hooks {
    private static WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);
    @Before
    public static void setUp(Scenario scenario) {
        logger.info("---------- Starting execution of scenario " + scenario.getName() + " ----------");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = DriverManager.createDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().to("https://www.amazon.com/");
    }

    @After()
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            takeScreenshot(scenario, "Failed test");
            logger.info("---------- FAILED SCENARIO " + scenario.getName() + " ----------");
        }
        else {
            logger.info("---------- PASSED SCENARIO " + scenario.getName() + " ----------");
        }
        quitDriver();
        logger.info("---------- Test finished ----------");
    }
}
