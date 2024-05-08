package com.qa.tests;

import com.qa.browser.LocalBrowser;
import com.qa.browser.RemoteBrowser;
import com.qa.driver.DriverManager;
import com.qa.enums.ConfigKey;
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
    public void setUpBrowser(@Optional("chrome") String browser) {

        if (ConfigReader.getValueFromKey(ConfigKey.SELENIUMGRIDENABLED).equalsIgnoreCase("false") ){
            LocalBrowser.setUpBrowser(browser);
            LocalBrowser.launchWebsite(ConfigReader.getValueFromKey(ConfigKey.URL));
        } else {
            RemoteBrowser.setupBroswer(browser,ConfigReader.getValueFromKey(ConfigKey.HUBURL));
            RemoteBrowser.launchWebsite(ConfigReader.getValueFromKey(ConfigKey.URL));

        }

    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        DriverManager.getDriver().quit();
    }

}
