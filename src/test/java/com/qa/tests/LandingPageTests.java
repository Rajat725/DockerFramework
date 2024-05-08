package com.qa.tests;

import com.qa.driver.DriverManager;
import com.qa.pages.LandingPage;
import com.qa.utils.ConfigReader;
import com.qa.utils.JsonReader;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class LandingPageTests extends BaseTest {

    @Test
    public void titleTest() {

        LandingPage landingPage = new LandingPage(DriverManager.getDriver());
        Assertions.assertThat(landingPage.isAt()).isTrue();
        Assertions.assertThat(landingPage.getPageTitle())
                .isEqualToIgnoringCase("OrangeHRM");


    }

    @Test
    public void urlTest() {

        LandingPage landingPage = new LandingPage(DriverManager.getDriver());
        Assertions.assertThat(landingPage.isAt()).isTrue();
        Assertions.assertThat(landingPage.getPageURL())
                .isEqualToIgnoringCase("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


    }

    @Test
    public void invalidLoginCredTest() {
        LandingPage landingPage = new LandingPage(DriverManager.getDriver());
        Assertions.assertThat(landingPage.isAt()).isTrue();
        landingPage.setUsername("RajatSharma")
                .setPassword("Indigo@1234567890")
                .clkLoginButton();

        Assertions.assertThat(landingPage.getInvalidCredError())
                .contains("Invalid credentials");

    }

    @Test(dataProvider = "getData")
    public void invalidLoginCredTestJsonDataTest(HashMap<String,String> map) {
        LandingPage landingPage = new LandingPage(DriverManager.getDriver());
        Assertions.assertThat(landingPage.isAt()).isTrue();
        landingPage.setUsername(map.get("username"))
                .setPassword(map.get("password"))
                .clkLoginButton();

        Assertions.assertThat(landingPage.getInvalidCredError())
                .contains("Invalid credentials");

    }

    @DataProvider
    public Object[] getData()
    {
        final List<HashMap<String, String>> jsonDataAsMap =
                JsonReader.getJsonDataAsMap("test-data/Login.json");
        return new Object[]{jsonDataAsMap.get(0),jsonDataAsMap.get(1),jsonDataAsMap.get(2)};

    }




}
