package com.qa.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.Logger;

public class BaseTest {

    private static final ThreadLocal<WebDriver> threadLocal=new ThreadLocal<>();

    public static void setDriver(WebDriver driver)
    {
       threadLocal.set(driver);

    }

    public static WebDriver getDriver()
    {
        return threadLocal.get();
    }

    public static void unsetDrivers()
    {
        threadLocal.remove();
    }

    public void setUpBrowser(String name)
    {
        if(name.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            setDriver(new ChromeDriver());
        }
        if(name.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            setDriver(new EdgeDriver());
        }
    }

    public void launchWebsite(String url)
    {
        getDriver().get(url);
    }

    public void closeBrowser()
    {
        getDriver().quit();
    }

}
