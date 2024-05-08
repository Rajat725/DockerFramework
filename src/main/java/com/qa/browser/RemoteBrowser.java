package com.qa.browser;

import com.qa.driver.DriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;

public class RemoteBrowser {

    public static void launchWebsite(String url)
    {
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
        DriverManager.getDriver().get(url);
    }

    @SneakyThrows
    public static void setupBroswer(String browser,String hubUrl) {

        Capabilities capabilities = null;

        if (browser.equalsIgnoreCase("chrome")) {
            capabilities = new ChromeOptions();
        }
        if (browser.equalsIgnoreCase("edge")) {
            capabilities = new EdgeOptions();
        }


        URL url = new URL(hubUrl);
        DriverManager.setDriver(new RemoteWebDriver(url, capabilities));


    }
}
