package com.qa.pages;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

public class LandingPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(LandingPage.class);

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "username")
    private WebElement txtUsername;

    @FindBy(name = "password")
    private WebElement txtPassword;

    @FindBy(css = ".orangehrm-login-button")
    private WebElement btnLogin;

    @Override
    protected boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(txtUsername));
        log.info("Display Status of Landing Page :: {}",txtUsername.isDisplayed());
        return txtUsername.isDisplayed();
    }


    @SneakyThrows
    public <T> T clkLoginButton(Class<T> classz) {
        btnLogin.click();
        log.info("Clicked On Login Button");
        return classz.getDeclaredConstructor().newInstance();
    }

    public LandingPage setUsername(String text) {
        this.txtUsername.sendKeys(text);
        log.info("Username entered is {}",text);
        return this;
    }

    public LandingPage setPassword(String text) {
        this.txtPassword.sendKeys(text);
        log.info("Password entered is {}",text);
        return this;
    }

}
