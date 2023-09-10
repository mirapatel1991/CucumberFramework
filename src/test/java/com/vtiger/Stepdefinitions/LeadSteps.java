package com.vtiger.Stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeadSteps extends BaseTest{
	
	@When("user clicks on New Lead and click save button")
	public void user_clicks_on_new_lead_and_click_save_button() {
	    getPageObject();
		ldp.clickNewLead();
	    ldp.clickSaveButton();
	}
	@Then("Error message should be displayed")
	public void error_message_should_be_displayed() {
	    ldp.verifyErrorMessage(alldata.get(vTCName).get("ExpAlert1"));
	    ldp.acceptAlertMessage();
	}
	@When("user provide manadatory inputs and click save")
	public void user_provide_manadatory_inputs_and_click_save() {
	   ldp.createLead(alldata.get(vTCName).get("lastname"), alldata.get(vTCName).get("company"));
	}
	@Then("Lead is created.")
	public void lead_is_created() {
	   ldp.verifyCreatedLead(alldata.get(vTCName).get("lastname"), alldata.get(vTCName).get("company") );
	   ldp.clickLogout();
	}
	
	
	
	@When("user clicks Leads link and select the lead")
	public void user_clicks_leads_link_and_select_the_lead() {
		 getPageObject();
	    ldp.selectLeadFromLeads(alldata.get(vTCName).get("lastname"));
	    ldp.clickEdit();
	}
	@When("click edit and fill all the details")
	public void click_edit_and_fill_all_the_details() {
	   ldp.createLead(alldata.get(vTCName).get("firstname"), alldata.get(vTCName).get("Lead Source"), alldata.get(vTCName).get("No of employees"), alldata.get(vTCName).get("Mobile"), alldata.get(vTCName).get("Lead Status"), alldata.get(vTCName).get("City"), alldata.get(vTCName).get("EmailWrong"), alldata.get(vTCName).get("EmailRight"),  alldata.get(vTCName).get("ExpAlert1"));
	}
	@Then("Lead with all fields is created")
	public void lead_with_all_fields_is_created() {
	   ldp.verifyCreatedLead(alldata.get(vTCName).get("No of employees"), alldata.get(vTCName).get("EmailRight"), alldata.get(vTCName).get("City"));
	}
	@When("user click on delete button then Lead is deleted.")
	public void user_click_on_delete_button() {
	    ldp.clickDeleteAndVerify(alldata.get(vTCName).get("lastname"));
	}
	
	
	
	
}
