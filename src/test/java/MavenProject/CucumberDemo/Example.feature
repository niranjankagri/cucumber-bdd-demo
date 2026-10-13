Feature: Sign in into Website

  Scenario Outline: Check Login Functionality with multiple dataset
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
