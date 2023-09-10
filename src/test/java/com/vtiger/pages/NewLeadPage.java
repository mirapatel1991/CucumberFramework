package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.CommonActions;

public class NewLeadPage extends CommonActions {
	
	private WebDriver driver;
	private ExtentTest logger;
	
	public NewLeadPage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
		this.driver =driver;
		this.logger =logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="firstname")
	WebElement fname;
	
	@FindBy(name="lastname")
	WebElement lname;
	
	@FindBy(name="company")
	WebElement comp;
	
	@FindBy(name="button")
	WebElement save;
	
	@FindBy(linkText = "New Lead")
	WebElement newLead;
	
	@FindBy(xpath = "//td[text()='Last Name:']/following::td[1]")
	WebElement lastnameValue;
	
	@FindBy(xpath = "//td[text()='Company:']/following::td[1]")
	WebElement companyValue;
	
	@FindBy(linkText = "Leads")
	WebElement leads;
	
	@FindBy(xpath = "//input[@value='Search'][@name='button']")
	WebElement search;
	
	@FindBy(name="Edit")
	WebElement edit;
	
	@FindBy(name="leadsource")
	WebElement leadsource;
	
	@FindBy(name="noofemployees")
	WebElement noofemployees;
	
	@FindBy(name="mobile")
	WebElement mobile;
	
	@FindBy(name="leadstatus")
	WebElement leadstatus;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="Delete")
	WebElement delete;
	
	@FindBy(xpath = "//input[@value='T']")
	WebElement assignTo;
	
	@FindBy(xpath = "//td[text()='No Of Employees:']/following::td[1]")
	WebElement noofemployeesvalue;
	
	@FindBy(xpath = "//td[text()='Email:']/following::td[1]")
	WebElement emailvalue;
	
	@FindBy(xpath = "//td[text()='City:']/following::td[1]")
	WebElement cityvalue;
	
	
	
	@FindBy(xpath = "//input[@name='lastname'][@size='10']")
	WebElement LastName;
	

	
	public void clickNewLead()
	{
		clickElement(newLead, "New Lead link has been clicked");
	}
	
	public void clickSaveButton()
	{
		clickElement(save, "Save button clicked");
	}
	
	public void createLead(String firstname, String lastname, String company)
	{
		SetInput(fname, firstname, firstname+" has been entered into first name fields");
		SetInput(lname, lastname, lastname+" has been entered into last name fields");
		SetInput(comp, company, company+" has been entered into company fields");
		clickElement(save, "Save button clicked");
	}
	
	public void createLead(String lastname, String company)
	{
		SetInput(lname, lastname, lastname + " has been entered in last name field");
		SetInput(comp, company, company+" has been entered into company fields");
		clickSaveButton();
	}
	
	public void verifyCreatedLead(String lastname, String Company)
	{
		verifyText(lastname, lastnameValue, lastname +" is validated for Last name field");
		verifyText(Company, companyValue, Company +" is validated for Last name field");
	}
	
	public void selectLeadFromLeads(String lastname)
	{
		clickElement(leads, "Leads link is clicked.");
		SetInput(LastName, lastname, lastname +" entered in Last name field");
		clickElement(search, "Search button clicked");
		selectMostRecentFormEntry("//tr[@height='20']//a[contains(text(),'Mishra')]", "Last lead entry is selected");
	}
	
	public void clickEdit()
	{
		clickElement(edit, "Edit button clicked");
	}
	
	
		
	public void createLead(String firstname, String leadSource, String noOfEmployees, String Mobile, String leadStatus, String	City, String EmailWrong, String	EmailRight, String expErrorMsg)
	{
		SetInput(fname, firstname, firstname+" has been entered into first name field");
		selectFromDropdown(leadsource, leadSource, leadSource + " selected in Lead Source dropdown");
		SetInput(noofemployees, noOfEmployees, noOfEmployees+" has been entered into No of Employees field");
		SetInput(mobile, Mobile, Mobile+" has been entered into Mobile field");
		selectFromDropdown(leadstatus, Integer.parseInt(leadStatus), leadStatus + " has been entered into Lead Status field");
		SetInput(city, City, City+" has been entered into City field");
		SetInput(email, EmailWrong, EmailWrong+" has been entered into Email field");
		clickElement(save, "Save button clicked");
		verifyErrorMessage(expErrorMsg);
		acceptAlertMessage();
		SetInput(email, EmailRight, EmailRight+" has been entered into Email field");
		clickElement(assignTo, "Team radio button is selected");
		clickSaveButton();
	}
	
	public void verifyCreatedLead(String noOfEmployees, String Email, String City)
	{
		verifyText(noOfEmployees, noofemployeesvalue, noOfEmployees +" is validated for No of Employees field");
		verifyText(Email, emailvalue , Email +" is validated for Email field");
		verifyText(City, cityvalue , City +" is validated for City field");
	}
	
	public void clickDeleteAndVerify(String lastname)
	{
		clickElement(leads, "Leads link clicked");
		int count1 = countEntries("//tr[@height='20']//a[contains(text(),'Mishra')]");
		selectMostRecentFormEntry( "//tr[@height='20']//a[contains(text(),'Mishra')]", lastname +" entry is clicked.");
		clickElement(delete, "Delete button clicked");
		acceptAlertMessage();
		SetInput(lname, lastname, lastname + " is entered in last name field");
		clickElement(search, "Search button clicked");
		int count2 = countEntries("//tr[@height='20']//a[contains(text(),'Mishra')]");
		if(count2 == count1 - 1)
		{
			logger.pass("Lead deleted successfully");
		}
		else
		{
			logger.fail("Lead is not deleted"+ "<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
	}
	
	
	
	

}
