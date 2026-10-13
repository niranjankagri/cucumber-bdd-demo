Feature: Report demo (a failure and a skip on purpose)

  Scenario: Login without a password fails on purpose
    Given Open the browser window
    When Enter the url of website
    Then Click on signin button
    When Enter Username
    Then Click on Submit
    And The secure area is shown

  Scenario: Scenario skipped on purpose
    Given this scenario is skipped on purpose
