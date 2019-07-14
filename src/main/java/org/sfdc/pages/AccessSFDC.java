package org.sfdc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sfdc.base.TestBase;
import org.testng.annotations.Test;

public class AccessSFDC extends TestBase{
	
				
	//Page factory-OR
				
	@FindBy(xpath="//input[@id='username']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement pwd;
	
	@FindBy(xpath="//input[@id='Login']")
	WebElement login;
	
	@FindBy(xpath="//input[@id='phSearchInput']")
	WebElement searchBox;
	
	@FindBy(xpath="//input[@id='phSearchButton']")
	WebElement searchButton;
	
	@FindBy(xpath="//a[@class='actionLink']")
	WebElement actionLink;
				
				public AccessSFDC()
				{
					PageFactory.initElements(driver, this);
				}
				
				
				public void accessSFDC()
				{
					driver.get(prop.getProperty("sfdcurl"));
					userName.sendKeys(prop.getProperty("sfdcUser"));
					pwd.sendKeys(prop.getProperty("sfdcPwd"));
					login.click();
								
				}
				
				public WebElement searchPatientName()
				{
					return searchBox;
					
				}
				
				public WebElement searchButtonClick()
				{
					return searchButton;
					 
				}
				
				public WebElement actionLink()
				{
					return actionLink;
					
				}
				
}
