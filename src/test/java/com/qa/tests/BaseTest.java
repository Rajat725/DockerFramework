package com.qa.tests;

import com.qa.browser.LocalBrowser;
import com.qa.browser.RemoteBrowser;
import com.qa.driver.DriverManager;
import com.qa.utils.ConfigReader;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeSuite
    public void initConfigProperties()
    {
        ConfigReader.initialize();
    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUpBrowser(@Optional("Chrome") String browser) {

        if (System.getProperty("selenium.grid.enabled").equalsIgnoreCase("false")) {
            LocalBrowser.setUpBrowser(browser);
            LocalBrowser.launchWebsite("https://opensource-demo.orangehrmlive.com/");
        } else {
            RemoteBrowser.setupBroswer(browser);
            RemoteBrowser.launchWebsite("https://opensource-demo.orangehrmlive.com/");

        }

    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        DriverManager.getDriver().quit();
    }

}
