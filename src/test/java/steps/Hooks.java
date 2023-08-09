package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.DriverManager;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static managers.DriverManager.quitDriver;
import static utils.Screenshots.takeScreenshot;

public class Hooks {
    private static WebDriver driver;
    @Before
    public static void setUp() {
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
        }
        quitDriver();
    }
}
