package com.vtiger.Stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TicketSteps extends BaseTest{
	
	@When("user clicks on New Ticket and click save button")
	public void user_clicks_on_new_ticket_and_click_save_button() {
		getPageObject();
		tp.clickNewTicket();
		tp.clickSaveButton();
	}
	@Then("Error message is displayed")
	public void error_message_is_displayed() {
	    tp.errorMessage(alldata.get(vTCName).get("ExpAlert1"));
	}
	@When("user provide all manadatory inputs and click save")
	public void user_provide_all_manadatory_inputs_and_click_save() {
	   tp.createTicket(alldata.get(vTCName).get("Title"));
	}
	@Then("Ticket is created.")
	public void ticket_is_created() {
	  tp.verifyTicket(alldata.get(vTCName).get("Title"));
	}
	
	
	
	@When("user clicks HelpDesk link and select the Ticket")
	public void user_clicks_help_desk_link_and_select_the_ticket() {
	   
	}
	@When("click edit_fill all the details")
	public void click_edit_fill_all_the_details() {
	    
	}
	@Then("Ticket with all fields is created")
	public void ticket_with_all_fields_is_created() {
	   
	}
	@When("user click on product name")
	public void user_click_on_product_name() {
	    
	}
	@Then("product page is open.")
	public void product_page_is_open() {
	    
	}
	@When("user click on delete")
	public void user_click_on_delete() {
	    
	}
	@Then("Ticket is deleted.")
	public void ticket_is_deleted() {
	    
	}

}
