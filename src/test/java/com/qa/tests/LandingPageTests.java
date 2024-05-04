package com.qa.tests;

import com.qa.pages.LandingPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class LandingPageTests extends BaseTest {

    @Test
    public void titleTest() {
        setUpBrowser("Edge");
        launchWebsite("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LandingPage landingPage = new LandingPage(getDriver());
        Assertions.assertThat(landingPage.isAt()).isTrue();
        Assertions.assertThat(landingPage.getPageTitle())
                .isEqualToIgnoringCase("OrangeHRM");
        closeBrowser();

    }

    @Test
    public void urlTest() {
        setUpBrowser("Chrome");
        launchWebsite("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LandingPage landingPage = new LandingPage(getDriver());
        Assertions.assertThat(landingPage.isAt()).isTrue();
        Assertions.assertThat(landingPage.getPageURL())
                .isEqualToIgnoringCase("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        closeBrowser();

    }

    @Test
    public void invalidLoginCredTest() {
        setUpBrowser("Chrome");
        launchWebsite("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LandingPage landingPage = new LandingPage(getDriver());
        Assertions.assertThat(landingPage.isAt()).isTrue();
        landingPage.setUsername("RajatSharma")
                .setPassword("Indigo@1234567890")
                        .clkLoginButton();

        Assertions.assertThat(landingPage.getInvalidCredError())
                .contains("Invalid credentials");
        closeBrowser();
    }


}
