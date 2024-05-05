package com.qa.pages;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LandingPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(LandingPage.class);

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[placeholder='Username']")
    private WebElement txtUsername;

    @FindBy(css = "input[placeholder='Password']")
    private WebElement txtPassword;

    @FindBy(css = ".orangehrm-login-button")
    private WebElement btnLogin;

    @FindBy(css = ".oxd-alert--error")
    private WebElement errInvalidCred;

    @FindBy(css = ".orangehrm-login-forgot p")
    private WebElement lnkForgotPassword;

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(txtUsername));
        log.info("Display Status of Landing Page :: {}", txtUsername.isDisplayed());
        return txtUsername.isDisplayed();
    }

    public ForgotPasswordPage clkForgotPassword()
    {
        this.lnkForgotPassword.click();
        log.info("CLicked on Forgot PAssword");
        return new ForgotPasswordPage(driver);
    }


    public String getInvalidCredError() {
        this.wait.until(ExpectedConditions.visibilityOf(errInvalidCred));
        String text = errInvalidCred.getText();
        log.info("Error is {}", text);
        return text;
    }

    @SneakyThrows
    public void clkLoginButton() {
        btnLogin.click();
        log.info("Clicked On Login Button");

    }

    public LandingPage setUsername(String text) {
        this.txtUsername.sendKeys(text);
        log.info("Username entered is {}", text);
        return this;
    }

    public LandingPage setPassword(String text) {
        this.txtPassword.sendKeys(text);
        log.info("Password entered is {}", text);
        return this;
    }

    public String getPageTitle() {
        final String title = driver.getTitle();
        log.info("Title Grabbed is {}", title);
        return title;
    }

    public String getPageURL() {
        final String url = driver.getCurrentUrl();
        log.info("URL Grabbed is {}", url);
        return url;
    }

}
