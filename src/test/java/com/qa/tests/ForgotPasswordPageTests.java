package com.qa.tests;

import com.qa.driver.DriverManager;
import com.qa.pages.ForgotPasswordPage;
import com.qa.pages.LandingPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class ForgotPasswordPageTests extends BaseTest {

    @Test
    public void validForgotPasswordCredentialsTests() {

        LandingPage landingPage = new LandingPage(DriverManager.getDriver());
        Assertions.assertThat(landingPage.isAt()).isTrue();
        ForgotPasswordPage forgotPasswordPage = landingPage.clkForgotPassword();
        Assertions.assertThat(forgotPasswordPage.isAt()).isTrue();
        forgotPasswordPage.enterUsername("Rajat").clkResetPassword();
        Assertions.assertThat(forgotPasswordPage.getResetPasswordConfirmationText())
                .contains("Reset Password link sent successfully");


    }

    @Test
    public void validEmptyCredentialsTests() {

        LandingPage landingPage = new LandingPage(DriverManager.getDriver());
        Assertions.assertThat(landingPage.isAt()).isTrue();
        ForgotPasswordPage forgotPasswordPage = landingPage.clkForgotPassword();
        Assertions.assertThat(forgotPasswordPage.isAt()).isTrue();
        forgotPasswordPage.clkResetPassword();
        Assertions.assertThat(forgotPasswordPage.getEmptyUSernameErrorMessage())
                .contains("Required");


    }


}
