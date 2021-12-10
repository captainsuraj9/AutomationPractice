Feature: Order Functionality

Scenario Outline: Order Tshirt
Given user is on landing page of "http://automationpractice.com/"
When user log in to the application with "<username>" and "<password>"
Then user should be able to log in
And user should be able to add "<number>" of tshirt to cart
And user should be able to order those tshirts

Examples:
|username               |password   |number|
|suraj.pahwa29@gmail.com|Selenium123|2     |