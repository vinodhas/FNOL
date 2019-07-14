package org.ssfdc.api;

import org.sfdc.base.TestBase;
import org.sfdc.pages.StartPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StartPageTest extends TestBase{
	
	StartPage page;

	public StartPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialisation();
		page=new StartPage();
	}
	
	@Test
	public void startPage() throws InterruptedException
	{
		page.register();
		
	}
		
	/*@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}*/
}
