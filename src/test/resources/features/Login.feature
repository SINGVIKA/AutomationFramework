
@Login
Feature: Feature to Test Login Functionality

Background:
Given User is on login page
And User clicks the Sign-in Link in header
Then User navigate to login page "My Account Page"

  @LoginTest1
  Scenario Outline: Check Login is successful with valid credentials 
    When User clicks the Sign-in button
    And  User enters "<Email>" and "<Password>"
    And  User clicks the "Sign in" submit button
    Then User navigate to login page "Login Page"
    Examples: 
      | Email  							| Password 							| Error  											|   
			| SingVika@gmail.com 	|     Password12345 		| Invalid password.						|
						
	@LoginTest2
  Scenario Outline: Check Login for Invalid credentials Errors
    When User clicks the Sign-in button
    And  User enters "<Email>" and "<Password>"
    And  User clicks the "Sign in" submit button
    Then User aspects "<Error>" for Invalid Crederntails
    Examples: 
      | Email  							| Password 			| Error  											|
      | 			 							|       				| An email address required. 	|
      | SingVika@gmail.com	|     			 		| Password is required.    		|
			| SingVika@gmail.com 	|     12454 		| Invalid password.						|