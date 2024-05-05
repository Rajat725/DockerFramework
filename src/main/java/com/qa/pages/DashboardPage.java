package com.qa.pages;

import com.qa.enums.Panel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardPage extends AbstractPage {
    private static final Logger log = LoggerFactory.getLogger(DashboardPage.class);

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".oxd-topbar-header-breadcrumb-module")
    private WebElement titlePage;


    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(titlePage));
        log.info("Display Status of DashboardPage  :: {}", titlePage.isDisplayed());
        return titlePage.isDisplayed();
    }

    public String getPageTitle()
    {
        this.wait.until(ExpectedConditions.visibilityOf(titlePage));
        String text = titlePage.getText();
        log.info("Grabbed the Title :: {}",text);
        return text;
    }

    public void navigateToSection(Panel panel)
    {
        accessLeftPanelSwitch(true,panel);
    }

}
