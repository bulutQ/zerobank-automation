package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {

    protected WebDriver driver= Driver.getDriver(ConfigurationReader.getProperty("browser"));
    protected WebDriverWait wait= new WebDriverWait(driver,25);

    public PageBase()
    {
        PageFactory.initElements(Driver.getDriver(ConfigurationReader.getProperty("browser")),this);
    }


}
