package page;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage extends GoogleBasePage {


    @FindBy (xpath = "//input[@id='lst-ib']")
    private WebElement searchField;



    public GoogleSearchPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public GoogleSearchResultPage1 search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
        return PageFactory.initElements(webDriver, GoogleSearchResultPage1.class);
    }

    public boolean isPageLoaded() {
        waitUntilElementIsClickable(searchField, 40);
        return searchField.isDisplayed();
    }
}