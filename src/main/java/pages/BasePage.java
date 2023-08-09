package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected Actions actions;

    /**
     * This class helps to reuse driver interactions.
     * @param driver is the WebDriver.
     */
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Method to click an element.
     * @param element it is the element to be clicked.
     */
    protected void clickElement(WebElement element) {
        waitElementToBeClickeable(element);
        element.click();
    }

    /**
     * Method to enter text in an element.
     * @param element it is the element to enter the text.
     * @param text the text to be written in the element.
     */
    protected void addText(WebElement element, String text) {
        waitVisibilityOfElement(element);
        element.sendKeys(text);
    }

    /**
     * Method to get the title from the current page.
     * @return title.
     */
    public String getTitle(){
        return driver.getTitle();
    }

    /**
     * Method to get the URL from the current page.
     * @return url.
     */
    public String getUrl() { return driver.getCurrentUrl(); }

    /**
     * Method to navigate back with the WebDriver.
     */
    public void navigateBack() { driver.navigate().back(); }

    /**
     * Method to wait for an element to be clickeable.
     * @param element it is the element to wait for.
     */
    protected void waitElementToBeClickeable(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(Exception.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Method to wait for the visibility of a element.
     * @param element it is the element to wait for.
     */
    protected void waitVisibilityOfElement(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(Exception.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Method to wait for the visibility of a list of elements.
     * @param elements Elements to wait for.
     */
    protected void waitVisibilityOfAllElements(List<WebElement> elements) {
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(Exception.class);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    /**
     * Method to get an element from a list by text.
     * @param elements Elements to be analyzed.
     * @param text Text to be searched.
     * @return Element.
     */
    protected WebElement getElementFromList(List<WebElement> elements, String text){
        for(WebElement e : elements){
            if(e.getText().equals(text)){
                return e;
            }
        }
        throw new NoSuchElementException("Cannot find element.");
    }

    /**
     * Method to get an element from a list by position.
     * @param elements Elements to be analyzed.
     * @param position Position of the element.
     * @return Element.
     */
    protected WebElement getElementFromList(List<WebElement> elements, Integer position){
        try{
            return elements.get(position);
        }
        catch (NoSuchElementException e){
            throw new NoSuchElementException("Cannot find element.");
        }
    }

    /**
     * Method to wait for an attribute in an element.
     * @param element Element.
     * @param attribute Attribute to wait for.
     * @param value Value of the attribute.
     */
    protected void waitForAttribute(WebElement element, String attribute, String value){
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofMillis(10))
                .ignoring(Exception.class);
        wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
    }

    /**
     * Method to scroll and view an element at the top of the screen.
     * @param element Element.
     */
    protected void scrollToViewElementAtTheTop(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
