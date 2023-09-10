@regression
Feature: Login fuctionality

Background:
Given user should be on login page

@Title @sanity @smoke @regression @prasad1
Scenario: TC01_verifyAppUrl
Then verify application title


@invalid
Scenario Outline: TC04_VerifyInValidLogin
When user enters userid as "<userid>" and password as "<password>" click on login button
Then user can see the error message on login page
Examples:
|userid | password |
|admin1 | pwd1 |
|admin2 | pwd2 |



@prasad2
Scenario: TC03_VerifyValidLogin
When user enters valid credentials and click on login button
Then user should be navigated to home page
And user can see logout link on home page


