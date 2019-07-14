package org.sfdc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sfdc.base.TestBase;

public class StartPage extends TestBase{

	//Page factory-OR
		
	@FindBy(xpath="//a[contains(@href,'/registrieren-sie-ihr-geraet')]")
	WebElement join;
	
	@FindBy(xpath="//a[contains(@href,'/registrieren-sie-ihr-geraet/oesterreich')]")
	WebElement register;
	
	//initialise the page objects
	public StartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	
	public RegistrationPage register() throws InterruptedException
	{
		
		Actions ref = new Actions (driver);
		
		ref.moveToElement(join).click(join).build().perform();
		ref.moveToElement(register).click(register).build().perform();
		Thread.sleep(3000);
		
		return new RegistrationPage();
		
	}
	
}
