package com.qa.tests;

import com.qa.browser.LocalBrowser;
import com.qa.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUpBrowser() {
        LocalBrowser.setUpBrowser("Chrome");
        LocalBrowser.launchWebsite("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        DriverManager.getDriver().quit();
    }

}
