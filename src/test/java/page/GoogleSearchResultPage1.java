package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;





public class GoogleSearchResultPage1 extends GoogleBasePage {

    @FindBy (xpath = "//a[@id='pnnext']")
    private WebElement nextPageButton;

    @FindBy (xpath = "//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchResults;


    public GoogleSearchResultPage1(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        waitUntilElementIsClickable(nextPageButton, 50);
        return nextPageButton.isDisplayed();
    }

    public List<String> getResultsList() {
    List<String> searchResultsList = new ArrayList();
    for (WebElement  searchResult:searchResults) {
    ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", searchResult);
    String searchResultText = searchResult.getText();
    searchResultsList.add(searchResultText);
    }
            return searchResultsList;

    }
    public int getResultsCount() {return searchResults.size();
    }

    public GoogleSearchResultPage2 nextPageRedirect() {
        nextPageButton.click();
        return PageFactory.initElements(webDriver, GoogleSearchResultPage2.class);
    }
}