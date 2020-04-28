package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBase {

    @FindBy(id = "user_login")
    private WebElement userName;

    @FindBy(id = "user_password")
    private WebElement password;

    @FindBy(id = "user_remember_me")
    private WebElement rememberMe;

    @FindBy(name = "submit")
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

    public void login(){
        userName.sendKeys(ConfigurationReader.getProperty("userName_default"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.waitForPageToLoad(3);
        submit.click();
    }
    public void login(String usernameValue, String passwordValue) {
        userName.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
    }
    public void goToLogin(){
        Driver.getDriver(ConfigurationReader.getProperty("URL"));
    }
}
