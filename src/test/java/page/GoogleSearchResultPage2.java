package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResultPage2 extends GoogleBasePage {


    @FindBy (xpath = "//a[@id='pnprev']")
    private WebElement previousPageButton;

    @FindBy (xpath = "//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchResults;

    public GoogleSearchResultPage2(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
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
    public boolean isPageLoaded() {
        waitUntilElementIsClickable(previousPageButton, 50);
        return previousPageButton.isDisplayed();
    }



}