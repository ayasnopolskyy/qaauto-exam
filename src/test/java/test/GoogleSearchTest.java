package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleSearchResultPage1;
import page.GoogleSearchResultPage2;

import java.util.List;

public class GoogleSearchTest extends GoogleBaseTest  {



@Test
        public void GoogleSearchTest ()
        {
            String searchTerm = "Selenium";
            Assert.assertTrue(googleSearchPage.isPageLoaded(), "Google search page is not loaded");
            GoogleSearchResultPage1 googleSearchResultPage1 = googleSearchPage.search(searchTerm);
            Assert.assertTrue(googleSearchResultPage1.isPageLoaded(), "Google search results page is not loaded");

            Assert.assertEquals(googleSearchResultPage1.getResultsCount(), 10, "search results count is wrong.");
            List<String> resultsListPage1 = googleSearchResultPage1.getResultsList();
            for (String result:resultsListPage1){
                Assert.assertTrue(result.contains(searchTerm),
                        "Searchterm " +searchTerm+" is missing in following result: \n"+result );}

            GoogleSearchResultPage2 googleSearchResultPage2 = googleSearchResultPage1.nextPageRedirect();
            Assert.assertTrue(googleSearchResultPage2.isPageLoaded(), "Google search results page is not loaded");
            Assert.assertEquals(googleSearchResultPage2.getResultsCount(), 10, "search results count is wrong.");
            List<String> resultsListPage2 = googleSearchResultPage2.getResultsList();
            for (String result:resultsListPage2){
                Assert.assertTrue(result.contains(searchTerm),
                        "Searchterm" +searchTerm+"is missing in following result: \n"+result );}

        }


    }


