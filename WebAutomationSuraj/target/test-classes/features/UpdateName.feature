Feature: Order Functionality

Scenario Outline: Order Tshirt
Given user is on landing page of "http://automationpractice.com/"
When user log in to the application with "<username>" and "<password>"
Then user should be able to log in
And user should be able to update the existing username to "<updatedUsername>" using "<password>"


Examples:
|username               |password   |updatedUsername|
|suraj.pahwa29@gmail.com|Selenium123|Captain        |