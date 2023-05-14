Feature: Login Page

Background: User launches application
Given User Launches Application
Then Home Page is displayed
 
@RegisteredAccessCheckoutPage
   Scenario Outline: Login with valid credentials and access checkout page
    Given User is on Login page
   	 When User enters username as "nikagrawal774@gmail.com"
   	 And User enters password as "feX.Nin3YtG2ehE"
     And User should be able to login successfully
		 And User is on Product page
		 And User enters search as '<productname>'
		 And User selects product of value '<productprice>'
		 And User is on Shop Cart page
		 Then User verifies cart page of name and price '<productname>' '<productprice>'
		 And User clicks on checkout
		 And User is on Checkout page
		 Examples:
   | productname   | productprice  |
   | tshirt  			 | 400   				 |

@NonRegisteredUserAccessCheckoutPage
		Scenario: User not signed in tries to access checkout page
		Given User is on Product page 
			When User enters search as "tshirt"
			And User selects product of value "400"
			And User is on Shop Cart page
			And User clicks on checkout
			Then User is on Checkout page 

@InValidCredentials   
   Scenario Outline: Login with invalid credentials
    Given User is on Login page
    When User enters username as '<username>'
    And User enters password as '<password>'
    Then User should be able to see error message '<errorMessage>'
     
  Examples:
   | username   | password  | errorMessage                      |
   | test@admin.com   | admin     | Your email or password is incorrect!      |  