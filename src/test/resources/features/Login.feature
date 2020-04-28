@Login
Feature: Login Authorization

  Background:
    Given the user is on the login page

  @ValidInfo
  Scenario: User logs in with valid credentials, Account summary page should be displayed
    When User logs in with username "username" and password "password"
    Then Page title "Account Summary" should be displayed


  @InvalidInfo
  Scenario: User enters invalid information
    When User logs in with username "empty" and password "empty"
    Then error message "Login and/or password are wrong." is displayed