@summary
Feature: Account summary page

  Background:
    Given the user is on the login page
    When User logs in with username "username" and password "password"
    Then Page title "Account Summary" should be displayed

  @step1
  Scenario:Account summary page should have title "Zero-Account Summary"
    When user navigates to Account summary page
    Then page title should be Zero-Account summary

  @step2
  Scenario: Account summary page should have all account types
    When user navigates to Account summary page
    Then user verifies that account types are displayed
      |Cash Accounts      |
      |Investment Accounts|
      |Credit Accounts    |
      |Loan Accounts      |

  @step3
  Scenario: Credit account table should have all columns
    When user navigates to Account summary page
    Then user verifies that columns are displayed in Credit Accounts table
      |Account|
      |Credit Card|
      |Balance    |