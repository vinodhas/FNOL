package org.ssfdc.api;



import org.openqa.selenium.JavascriptExecutor;
import org.sfdc.base.TestBase;
import org.sfdc.pages.RegistrationPage;
import org.sfdc.pages.StartPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationPageTest extends TestBase{
	
	RegistrationPage regPage;
	
	StartPage spage;
	ApiResponseTest api;

	public RegistrationPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialisation();
		spage= new StartPage();
		regPage=new RegistrationPage();
		api=new ApiResponseTest();
	}
	
	
	@Test
	public void entry() throws InterruptedException
	{
		
		spage.register();		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)", "");
		
	}
		
	}
		
	/*@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}*/



