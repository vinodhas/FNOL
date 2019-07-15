package org.ssfdc.api;

import io.restassured.path.json.JsonPath;

import org.sfdc.base.TestBase;
import org.sfdc.pages.AccessSFDC;
import org.sfdc.pages.PersonDetailsPage;
import org.sfdc.pages.RegistrationPage;
import org.sfdc.pages.StartPage;
import org.sfdc.pages.TreatmentPage;
import org.sfdc.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class PersonDetailsTest extends TestBase{
	//jhjhjhj
	AccessSFDC sfdcAccess;
	PersonDetailsPage personal;
	RegistrationPage regPage;
	StartPage spage;
	TreatmentPage page;
	ApiResponseTest api;
	
	String srlNo[]={"FAKTQVBC","ZAHJSL9H","JAMLF5MZ"};

	
	public PersonDetailsTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialisation();
		spage= new StartPage();
		regPage=new RegistrationPage();
		personal=new PersonDetailsPage();
		page=new TreatmentPage();
		sfdcAccess=new AccessSFDC();		
		api= new ApiResponseTest();	
			
	}
	
			
	@DataProvider
	public Object[][] inputData()
	{
		Object[][] testdata=TestUtil.getTestData();
		return testdata;
	}
	
		
	@Test(dataProvider="inputData")
	public void registerAndfetchAPIData(String firstName, String lastName, String age, String email, String street, String place,
			String postcode, String phone, String childFirstName
			, String childLastName, String childAge) throws InterruptedException
	{
		for(int i=0;i<3;i++)
		{
		spage.register();
		regPage.enterDetails(srlNo[i]);
		personal.enterPersonDetails(firstName, lastName, age,  email, street, place,
				 postcode,  phone, childFirstName, childLastName, childAge);
		page.treatmentDetails();
		sfdcAccess.accessSFDC();
		String childFullName=childFirstName+" "+childLastName;
		sfdcAccess.searchPatientName().sendKeys(childFullName);
		sfdcAccess.searchButtonClick().click();
		sfdcAccess.actionLink().click();
		
		api.extractingNamesAPI();
		
		String acctName=api.getAcctName();
		String childName=childLastName+","+" "+childFirstName;
		
		System.out.println("Child name coming from api is..."+acctName+
				"   Child name entered in the app is.."+childName);
		Assert.assertEquals(acctName,childName);
		
		JsonPath jsDevSerResult=api.rawToJsonDeviceSerial();
		String devSrlNo=jsDevSerResult.getJsonObject("Serial_Number__c");
		
		System.out.println("Device srl number coming from api is..."+devSrlNo+
				"   Device srl number entered in the app is.."+srlNo);
		
		Assert.assertEquals(devSrlNo,srlNo );
		}
		//System.out.println(" Serial no is..."+srlNo);
		Logger.getLogger(PersonDetailsTest.class);
		
	}
	
	/*@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}*/


}
