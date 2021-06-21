
@Login
Feature: Feature to Test Login Functionality

Background:
Given User is on "Home" page

  @LoginTest1
  Scenario Outline: Check Login is successful with valid credentials 
    When User clicks on "Laptop" link
    Then User navigate to "Laptop Details Page"
    And  User clicks on "Sony vaio i5" link
    Then User navigate to "Add to cart Page"
    And  User clicks on "Add to cart" link
    And  User confirm to add the prodcuts on "Add to cart"
    And  User clicks on "Home" link
    Then User navigate to "Home Page"
    And  User clicks on "Laptop" link
    Then User navigate to "Laptop Details Page"
    And  User clicks on "Dell i7 8gb" link
    Then User navigate to "Add to cart Page"
    And  User clicks on "Add to cart" link
    And  User confirm to add the prodcuts on "Add to cart"
    And  User clicks on "Cart" link
    And  User wants to remove prodcuts as "Dell i7 8gb" from CartOrder
    And  User clicks on "Place Order" button 
    Then User navigate to "User Payment Details"
    And  User fills the payments details 
    And  User clicks on "Purchase" button 
    And  User Validate the payment details
    And  User clicks on "OK" button 
    Examples: 
      | Email  							| Password 							| Error  											|   
			| SingVika@gmail.com 	|     Password12345 		| Invalid password.						|
						
