package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBase {

    @FindBy(id = "user_login")
    private WebElement userName;

    @FindBy(id = "user_password")
    private WebElement password;

    @FindBy(id = "user_remember_me")
    private WebElement rememberMe;

    @FindBy(className = "btn btn-primary")
    private WebElement submit;

    @FindBy(linkText = "Forgot your password ?")
    private WebElement forgotPassword;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    private WebElement warningMessage;

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(ConfigurationReader.getProperty("browser")),this);
    }

    public String getWarningMessage(){
        return warningMessage.getText();
    }

    public void login(boolean ifRemember){
        userName.sendKeys(ConfigurationReader.getProperty("userName_default"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        if (ifRemember){
            rememberMe.click();
        }
        BrowserUtils.waitForPageToLoad(3);
        submit.click();
    }
}
