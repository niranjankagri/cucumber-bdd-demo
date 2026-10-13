Feature: Sign in into Website
  
  Scenario Outline: Check Login Functionality with multiple dataset
    Given Open browser window
    When Enter url of website 
    When User enter <username> and <password>
    Then click on login button
  
  
    Examples: 
    
    
    
      | username  | password | 
      | standard_user  | secret_sauce | 
      | locked_out_user |secret_sauce |
      | problem_user |secret_sauce |
      | performance_glitch_user  |secret_sauce |
