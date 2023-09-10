Feature: Create New Ticket

Background: 
Given user should be on login page
When user enters valid credentials and click on login button
Then user should be navigated to home page

@Ticket
Scenario: TC08_CreateTicketWithMandatoryFields
When user clicks on New Ticket and click save button
Then Error message is displayed
When user provide all manadatory inputs and click save
Then Ticket is created.


Scenario: TC09_EditTicket_DeleteTicket
When user clicks HelpDesk link and select the Ticket
And click edit_fill all the details
Then Ticket with all fields is created
When user click on product name
Then product page is open.
When user click on delete
Then Ticket is deleted.