@Leads
Feature: Create New Lead

Background: 
Given user should be on login page
When user enters valid credentials and click on login button
Then user should be navigated to home page


Scenario: TC06_CreateLeadWithMandatoryFields
When user clicks on New Lead and click save button
Then Error message should be displayed
When user provide manadatory inputs and click save
Then Lead is created.


Scenario: TC07_EditLead_DeleteLead
When user clicks Leads link and select the lead
And click edit and fill all the details
Then Lead with all fields is created
When user click on delete button then Lead is deleted.


