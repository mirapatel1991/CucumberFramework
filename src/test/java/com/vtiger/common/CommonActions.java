package com.vtiger.common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class CommonActions {
	
	private WebDriver driver;
	private ExtentTest logger;
	public WebDriverWait wait;
	
	public CommonActions(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	public void clickLogout()
	{
		try
		{
		driver.findElement(By.linkText("Logout")).click();
		logger.pass("Logout link clicked");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
	}
	
	
	public void SetInput(WebElement elm, String data,String msg)
	{
		try
		{
		
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.clear();
		elm.sendKeys(data);
		logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
	}
	
	public void SetInput(By elm, String data,String msg)
	{
		try
		{
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(elm));
		driver.findElement(elm).clear();
		driver.findElement(elm).sendKeys(data);
		logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed  due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
	}
	
	
	public void SetInput(String elm, String data,String msg)
	{
		try
		{
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elm))));
		driver.findElement(By.xpath(elm)).clear();
		driver.findElement(By.xpath(elm)).sendKeys(data);
		logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
	}
	
	public void clickElement(WebElement elm,String msg)
	{
		try
		{
		
		wait.until(ExpectedConditions.elementToBeClickable(elm));
		elm.click();
		logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
	}
	
	public void clickElement(By elm, String msg)
	{
		try
		{
		
		wait.until(ExpectedConditions.elementToBeClickable(elm));
		driver.findElement(elm).click();
		logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
	}
	
	public void clickElement(String elm,String msg)
	{
		try
		{
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(elm))));
		driver.findElement(By.xpath(elm)).click();
		logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
	}
	
	public void ElementExist(WebElement  elm,String msg)
	{
		try
		{
		
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.isDisplayed();
		logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
	}
	
	public void verifyTitle(String exp)
	{
		try
		{
		if(exp.equals(driver.getTitle()))
		logger.pass("Title matched");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
	}
	
	public String getScreenshot() 
	{
		Date d = new Date();
		DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName = ft.format(d);
		String path = System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/screenshot/"+fileName+".png";
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File SrcFile=ts.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(path);
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	public void verifyErrorMessage(String exp)
	{
		try
		{
			if(exp.equals(driver.switchTo().alert().getText()))
			{
			logger.pass("Error message verified");
			}
			else
			{
				logger.fail("Expected error message is: "+ exp + " and actual message is: " + (driver.switchTo().alert().getText()) + "<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
	}
	
	public void verifyText(String exp, WebElement elm, String msg)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(elm));
			if(exp.equals(elm.getText()))
			{
			logger.pass(msg);
			}
			else
			{
				logger.fail("Expected text is: "+ exp + " and actual text is: " + (elm.getText()) + "<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
	}
	
	public void acceptAlertMessage()
	{
		try
		{
		driver.switchTo().alert().accept();
		logger.pass("Error message - clicked 'ok'.");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
	}
	
	public void selectMostRecentFormEntry(String xpath, String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
		List<WebElement> list = driver.findElements(By.xpath(xpath));
		list.get(list.size()-1).click();
		logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
		
	}
	
	public void selectFromDropdown(WebElement elm, String text, String msg)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(elm));
			Select sel =  new Select(elm);
			sel.selectByVisibleText(text);
			logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
			
	}
	public void selectFromDropdown(WebElement elm, int index, String msg)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(elm));
			Select sel =  new Select(elm);
			sel.selectByIndex(index);
			logger.pass(msg);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
			
	}
	
		
	public int countEntries(String xpath)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Step failed due to "+e.getMessage()+"<span class='label end-time'><a href="+getScreenshot()+">Screenshot</a></span>");
		}
		return driver.findElements(By.xpath(xpath)).size();
	}

			
	
		
	}
	
	


