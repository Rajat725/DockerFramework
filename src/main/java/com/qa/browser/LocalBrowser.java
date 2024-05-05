package com.qa.browser;

import com.qa.driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LocalBrowser {

    public static void launchWebsite(String url)
    {
        DriverManager.getDriver().get(url);
    }

    public static void setUpBrowser(String name)
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
}
