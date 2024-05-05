package com.qa.pages;

import com.qa.enums.Panel;
import com.qa.utils.DynamicXpath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected AbstractPage(WebDriver driver) {
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    protected abstract boolean isAt();

    protected void accessLeftPanelSwitch(Boolean canAccess,Panel panel)
    {
        if(!DynamicXpath.getLeftPanelXpath(panel).isEmpty()
        && canAccess)
        {
            DynamicXpath.getLeftPanelXpath(panel);
        }
        else
        {
            throw new RuntimeException("Invalid Panel Name");
        }
    }
}
