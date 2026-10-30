# Login on the-internet.herokuapp.com, a public practice site (runner: TestRunner).
# Steps: stepdefinitions/CucumberStpDef.java; URL and test user: src/test/resources/config.properties.
Feature: Sign in to a practice website

  @TC-101
  Scenario: [TC-101] Test Login Functionality
    Given Open the browser window
    When Enter the url of website
    Then Click on signin button
    When Enter Username
    When Enter Password
    Then Click on Submit
    And The secure area is shown
