# Fails and skips ON PURPOSE to show both results in the report (runner: ReportDemoRunner,
# excluded from the normal "mvn test"; run with: mvn test -Dtest=ReportDemoRunner).
# Expected: Tests run: 2, Failures: 1, Skipped: 1. Report: target/cucumber-reports/report-demo.html
Feature: Report demo (a failure and a skip on purpose)

  # Same steps as the practice-site login, without "Enter Password", so the last check fails
  Scenario: Login without a password fails on purpose
    Given Open the browser window
    When Enter the url of website
    Then Click on signin button
    When Enter Username
    Then Click on Submit
    And The secure area is shown

  # The step throws AssumptionViolatedException, which marks the scenario as skipped
  Scenario: Scenario skipped on purpose
    Given this scenario is skipped on purpose
