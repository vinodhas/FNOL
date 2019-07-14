package org.sfdc.pages;

import io.restassured.path.json.JsonPath;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sfdc.base.TestBase;
import org.testng.annotations.BeforeMethod;

public class RegistrationPage extends TestBase {
	
	//Page factory-OR
	
		@FindBy(id="edit-field-serial-number-de-0-value")
		WebElement deviceSerial;
		
		@FindBy(css="input.form-submit.multipage-link-next")
		WebElement next;
		
		@FindBy(xpath="//img[contains(@src,'https://stage.onetouch.de/sites/onetouch_de/files/ot_upf_messsystem_mg.jpg')]")
		WebElement deviceOne;
				
		@FindBy(xpath="//img[contains(@src,'https://stage.onetouch.de/sites/onetouch_de/files/onetouch_verio_flex_product_germin-min.png')]")
		WebElement deviceTwo;
				
		@FindBy(xpath="//img[contains(@src,'https://stage.onetouch.de/sites/onetouch_de/files/2onetouch-selectplus_mg_ger1-min.png')]")
		WebElement deviceThree;
		
		
		//img[contains(@src,'/img/logo/new_logo.jpg')] 
		
		

		public RegistrationPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		public PersonDetailsPage enterDetails(String srlNo) throws InterruptedException
		{
										 
					Boolean yesOne=deviceOne.isDisplayed();
					Boolean yesTwo=deviceTwo.isDisplayed();
					Boolean yesThree=deviceThree.isDisplayed();
					
					if(yesOne && srlNo=="FAKTQVBC")
					{
						deviceOne.click();
						if(deviceOne.isEnabled())
						{
						deviceSerial.sendKeys(srlNo);
						}
					}else if(yesTwo && srlNo=="ZAHJSL9H")
					{
						
						deviceTwo.click();
						if(deviceTwo.isEnabled())
						{
						deviceTwo.click();
						deviceSerial.sendKeys(srlNo);
						}		
					Thread.sleep(2000);
					}else if(yesThree && srlNo=="JAMLF5MZ")
					{
						deviceThree.click();
						if(deviceThree.isEnabled())
						{
							deviceThree.click();
							deviceThree.sendKeys(srlNo);
						}		
						
								
					Thread.sleep(2000);
					}
		            
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,250)", "");
				jse.executeScript("arguments[0].click();", next );
				
				return new PersonDetailsPage();
		        
				}
				
				
			
			
			
		}


