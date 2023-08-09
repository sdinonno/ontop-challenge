package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    @FindBy(css = "input#twotabsearchtextbox")
    private WebElement searchTextbox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement submitButton;

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to perform a search.
     * @param keywords Keywords to be searched.
     */
    public void performSearch(String keywords){
        addText(searchTextbox, keywords);
        clickElement(submitButton);
    }
}
