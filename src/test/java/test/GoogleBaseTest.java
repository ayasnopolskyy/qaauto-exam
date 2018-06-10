package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.GoogleSearchPage;

public class GoogleBaseTest {



        WebDriver webDriver;
        GoogleSearchPage googleSearchPage;


        @BeforeMethod
        public void before(){
            webDriver = new FirefoxDriver();
            webDriver.get("https://www.google.com");
            googleSearchPage = new GoogleSearchPage (webDriver);
        }
        @AfterMethod
        public void after () {
            webDriver.close();
        }


    }



