package com.qa.tests;

import com.qa.driver.DriverManager;
import com.qa.pages.LandingPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

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


}
