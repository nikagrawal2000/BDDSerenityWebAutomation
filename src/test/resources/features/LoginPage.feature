Feature: Login Page

Background: User launches application
Given User Launches Application
Then Home Page is displayed
 
#@ValidCredentials
   #Scenario: Login with valid credentials
    #
    #Given User is on Login page
    #When User enters username as "nikagrawal774@gmail.com"
    #And User enters password as "feX.Nin3YtG2ehE"
    #Then User should be able to login successfully
    
@ProductSearchAndAdd
		Scenario: Tshirt Product search and add
			Given User is on Product page
			When User enters search as "tshirt"
			And User selects product of value "400"
			And User is on Shop Cart page
			Then User verifies cart page of name and price "tshirt" "400"

    
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