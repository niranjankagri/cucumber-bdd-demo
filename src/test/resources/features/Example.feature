# Sauce Demo login, once per Examples row (runner: ExampleRunner).
# Steps: stepdefinitions/ExampleStpDef.java. "result" is the text the page must show afterwards:
# the product page for users who can log in, the error message for the locked-out user.
Feature: Sign in into Website

  @TC-102
  Scenario Outline: [TC-102] Check Login Functionality with multiple dataset
    Given Open browser window
    When Enter url of website
    When User enter <username> and <password>
    Then click on login button
    And the page shows "<result>"

    Examples:
      | username                | password     | result                                              |
      | standard_user           | secret_sauce | Products                                            |
      | locked_out_user         | secret_sauce | Epic sadface: Sorry, this user has been locked out. |
      | problem_user            | secret_sauce | Products                                            |
      | performance_glitch_user | secret_sauce | Products                                            |
