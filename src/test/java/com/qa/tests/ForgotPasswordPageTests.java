package com.qa.tests;

import com.qa.pages.ForgotPasswordPage;
import com.qa.pages.LandingPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class ForgotPasswordPageTests extends BaseTest {

    @Test
    public void validForgotPasswordCredentialsTests() {
        setUpBrowser("Chrome");
        launchWebsite("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LandingPage landingPage = new LandingPage(getDriver());
        Assertions.assertThat(landingPage.isAt()).isTrue();
        ForgotPasswordPage forgotPasswordPage = landingPage.clkForgotPassword();
        Assertions.assertThat(forgotPasswordPage.isAt()).isTrue();
        forgotPasswordPage.enterUsername("Rajat").clkResetPassword();
        Assertions.assertThat(forgotPasswordPage.getResetPasswordConfirmationText())
                .contains("Reset Password link sent successfully");
        closeBrowser();

    }

    @Test
    public void validEmptyCredentialsTests() {
        setUpBrowser("Chrome");
        launchWebsite("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LandingPage landingPage = new LandingPage(getDriver());
        Assertions.assertThat(landingPage.isAt()).isTrue();
        ForgotPasswordPage forgotPasswordPage = landingPage.clkForgotPassword();
        Assertions.assertThat(forgotPasswordPage.isAt()).isTrue();
        forgotPasswordPage.clkResetPassword();
        Assertions.assertThat(forgotPasswordPage.getEmptyUSernameErrorMessage())
                .contains("Required");
        closeBrowser();

    }


}
