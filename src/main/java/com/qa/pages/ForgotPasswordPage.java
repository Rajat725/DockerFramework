package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForgotPasswordPage extends AbstractPage {
    private static final Logger log = LoggerFactory.getLogger(ForgotPasswordPage.class);

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[placeholder='Username']")
    private WebElement txtUsername;

    @FindBy(css = "button[type='submit']")
    private WebElement btnResetPassword;

    @FindBy(css = ".oxd-input-field-error-message")
    private WebElement errorEmptyUsername;

    @FindBy(css = ".orangehrm-forgot-password-title")
    private WebElement titleResetPasswordSuccess;


    @Override
    protected boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(txtUsername));
        log.info("Display Status of Landing Page :: {}", txtUsername.isDisplayed());
        return txtUsername.isDisplayed();
    }

    public String getResetPasswordConfirmationText()
    {
        this.wait.until(ExpectedConditions.visibilityOf(titleResetPasswordSuccess));
        String text = titleResetPasswordSuccess.getText();
        log.info("Grabbed the error :: {}",text);
        return text;
    }

    public String getEmptyUSernameErrorMessage()
    {
        this.wait.until(ExpectedConditions.visibilityOf(errorEmptyUsername));
        String text = errorEmptyUsername.getText();
        log.info("Grabbed the error :: {}",text);
        return text;
    }
    public ForgotPasswordPage enterUsername(String text)
    {
        this.wait.until(ExpectedConditions.visibilityOf(txtUsername));
        txtUsername.sendKeys(text);
        log.info("Entered Username is {}",text);
        return this;
    }
    public ForgotPasswordPage clkResetPassword()
    {
        this.wait.until(ExpectedConditions.visibilityOf(btnResetPassword));
        btnResetPassword.click();
        log.info("Clicked on Reset PAssword Button");
        return this;
    }

}
