package com.qa.tests;

import com.qa.driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.Logger;

public class BaseTest {

    public void setUpBrowser(String name)
    {
        if(name.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            DriverManager.setDriver(new ChromeDriver());
        }
        if(name.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            DriverManager.setDriver(new EdgeDriver());
        }
    }

    public void launchWebsite(String url)
    {
        DriverManager.getDriver().get(url);
    }

    public void closeBrowser()
    {
        DriverManager.getDriver().quit();
    }

}
