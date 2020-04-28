package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition {

    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String URL=ConfigurationReader.getProperty("URL");
        Driver.getDriver(ConfigurationReader.getProperty("browser")).get(URL);
    }

    @When("User logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("Page title {string} should be displayed")
    public void page_title_should_be_displayed(String string) {
        Assert.assertEquals("Zero - Account Summary", Driver.getDriver(ConfigurationReader.getProperty("browser")).getTitle());
    }

    @Then("error message {string} is displayed")
    public void error_message_is_displayed(String string) {
        loginPage.getWarningMessage();
    }

}
