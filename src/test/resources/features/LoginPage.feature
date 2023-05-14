Feature: Login Page

Background: User launches application
Given User Launches Application
 
@ValidCredentials
   Scenario: Login with valid credentials
    
    Given User is on Login page
    When User enters username as "nikagrawal774@gmail.com"
    And User enters password as "feX.Nin3YtG2ehE"
    Then User should be able to login successfully
    
    #@InValidCredentials   
   #Scenario Outline: Login with invalid credentials
    #
    #Given User is on Home page
    #When User enters username as '<username>'
    #And User enters password as '<password>'
    #Then User should be able to see error message '<errorMessage>'
     #
  #Examples:
   #| username   | password  | errorMessage                      |
   #| Admin123   | admin     | Invalid credentials               |  