package com.qa.tests;

import com.qa.browser.LocalBrowser;
import com.qa.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUpBrowser(@Optional("Chrome") String browser) {
        LocalBrowser.setUpBrowser(browser);
        LocalBrowser.launchWebsite("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        DriverManager.getDriver().quit();
    }

}
