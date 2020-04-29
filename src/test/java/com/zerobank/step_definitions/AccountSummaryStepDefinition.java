package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;


import java.util.List;

public class AccountSummaryStepDefinition {

    AccountSummaryPage accountSummaryPage=new AccountSummaryPage();

    @When("user navigates to Account summary page")
    public void user_navigates_to_Account_summary_page() {
        accountSummaryPage.accountSummary.click();
        BrowserUtils.waitForPageToLoad(3);
    }

    @Then("page title should be Zero-Account summary")
    public void page_title_should_be_Zero_Account_summary() {
        String expectedTitle= Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,"Zero - Account Summary");
    }

    @Then("user verifies that account types are displayed")
    public void user_verifies_that_account_types_are_displayed(List<String> accountTypes) {
        for (WebElement accountType:accountSummaryPage.account_Types){
            accountTypes.add(accountType.getText());
        }
        Assert.assertEquals(accountTypes.toString(),"[Cash Accounts, Investment Accounts, Credit Accounts, Loan Accounts]");
    }

    @Then("user verifies that columns are displayed in Credit Accounts table")
    public void user_verifies_that_columns_are_displayed_in_Credit_Accounts_table(List<String> accountColumns) {
        for (WebElement accountColumn: accountSummaryPage.account_Column) {
            accountColumns.add(accountColumn.getText());
        }

        Assert.assertEquals(accountColumns.toString(), "[Account, Credit Card, Balance]");
    }

}
