Feature: Sign in to a practice website

  Scenario: Test Login Functionality
    Given Open the browser window
    When Enter the url of website
    Then Click on signin button
    When Enter Username
    When Enter Password
    Then Click on Submit
    And The secure area is shown
