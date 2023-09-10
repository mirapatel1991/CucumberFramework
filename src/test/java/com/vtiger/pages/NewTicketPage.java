package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.CommonActions;

public class NewTicketPage extends CommonActions{
	
	private WebDriver driver;
	
	
	public NewTicketPage(WebDriver driver, ExtentTest logger)
	{
		super(driver,logger);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText = "New Ticket")
	WebElement newticket;
	
	@FindBy(name="button")
	WebElement save;
	
	@FindBy(name="ticket_title")
	WebElement title;
	
	@FindBy(xpath="//td[text()='Title:']/following::td[1]")
	WebElement verifyTitle;
	
	
	public void clickNewTicket()
	{
		clickElement(newticket, "New Ticket link is clicked.");
	}
	
	public void clickSaveButton()
	{
		clickElement(save, "Save button is clicked.");
	}
	
	public void errorMessage(String errorMessage)
	{
		verifyErrorMessage(errorMessage);
		acceptAlertMessage();
	}
	
	public void createTicket(String Title)
	{
		SetInput(title, Title, "'" +Title + "' is added to title field");
		clickSaveButton();
	}
	
	public void verifyTicket(String text)
	{
		verifyText(text, verifyTitle, "New Ticket is created successfully");
	}
	
	

}
