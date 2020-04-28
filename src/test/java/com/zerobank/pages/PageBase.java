package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {

    protected WebDriver driver= Driver.getDriver(ConfigurationReader.getProperty("browser"));
    protected WebDriverWait wait= new WebDriverWait(driver,25);

    public PageBase()
    {
        PageFactory.initElements(driver,this);
    }

    public void navigateToModule(String moduleName) {
        WebElement module = driver.findElement(By.linkText(moduleName));
        module.click();
    }
}
