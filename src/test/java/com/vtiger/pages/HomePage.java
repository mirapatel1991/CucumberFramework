package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.CommonActions;

public class HomePage extends CommonActions {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="New Lead")
	WebElement NewLead;
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	@FindBy(linkText="Leads")
	WebElement leads;
	
		
	
	public void clickNewLead()
	{	
		clickElement(NewLead,"Link New Lead clicked");
	}
	
	public void clicklogout()
	{	
		clickElement(logout,"Link Logout clicked");
	}
	
	public void clickLeads()
	{	
		clickElement(leads,"Link Leads clicked");
	}
	
	public void verifyHomePage()
	{
		ElementExist(logout, "Logout is displaying on home page");
	}
	

}
