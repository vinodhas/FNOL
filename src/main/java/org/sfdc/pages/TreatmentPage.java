package org.sfdc.pages;

import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.sfdc.base.TestBase;
	import org.testng.annotations.BeforeMethod;

	public class TreatmentPage extends TestBase {
		
		//Page factory-OR
			
		@FindBy(css="input.form-submit.multipage-link-next")
		//@FindBy(xpath="//input[@id=edit-submit]")
		WebElement register;
		
		
			
			public TreatmentPage()
			{
				PageFactory.initElements(driver, this);
			}
			
			public AccessSFDC treatmentDetails()
			{
				
				register.submit();
				return new AccessSFDC();
			}

	}



