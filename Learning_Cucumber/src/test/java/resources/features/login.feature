Feature: Login
Login to the ecommerce site as a valid customer

Scenario: Login
Given User is on the login page
When User enters a valid username
And User enters a valid password
And User clicks on the login button
Then User navigates to the inventory page