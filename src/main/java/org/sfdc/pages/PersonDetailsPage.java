package org.sfdc.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sfdc.base.TestBase;
import org.testng.annotations.BeforeMethod;

public class PersonDetailsPage extends TestBase {
	
	//Page factory-OR
	
		@FindBy(xpath="//select[@id='edit-field-subject-de']/option[3]")
		WebElement doyouhave;
		
		@FindBy(xpath="//select[@id='edit-field-title-de']/option[2]")
		WebElement title;
		
		@FindBy(id="edit-field-first-name-de-0-value")
		WebElement firstname ;
		//img[contains(@src,'/img/logo/new_logo.jpg')] 
		
		@FindBy(name="field_last_name[de][0][value]")
		WebElement surname;
		
		@FindBy(id="edit-field-age-de-0-value")
		WebElement age;
		
		@FindBy(id="edit-field-email-de-0-value")
		WebElement email;
		
		@FindBy(id="edit-field-address-de-0-value")
		WebElement street;
		

		@FindBy(id="edit-field-city-de-0-value")
		WebElement place;
		
		@FindBy(id="edit-field-zip-code-de-0-value")
		WebElement postcode;
		
		@FindBy(xpath="//select[@id='edit-field-country-de']/option[2]")
		WebElement country;
		
		@FindBy(id="edit-field-phone-de-0-value")
		WebElement phone;
		
		@FindBy(id="edit-field-child-name-de-0-value")
		WebElement childName;
		
		@FindBy(id="edit-field-child-last-name-de-0-value")
		WebElement childLastName;
		
		@FindBy(id="edit-field-child-age-de-0-value")
		WebElement childAge;
		
		@FindBy(xpath="//div[@id='edit-field-agree-info']/div[@class='form-item form-type-checkbox form-item-field-agree-info-de']//label[@class='option']")
		WebElement check;
		
		//@FindBy(css="input.form-submit.multipage-link-next")
		@FindBy(xpath="//form/div/div[2]/div/div[2]/div[2]/span/input[2]")
		//@FindBy(xpath="//input[@type='button'][@value='Zurück']")
		WebElement personalNext;
		
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
		
		public PersonDetailsPage()
		{
			PageFactory.initElements(driver, this);
		}
		
				
		public TreatmentPage enterPersonDetails(String firstName, String lastName,String adultage, String mail,String streetnum,String city,
				String postCode, String phoneNum,String childFirstName,String childLastname,String chAge)
		{
			doyouhave.click();
			title.click();
			firstname.sendKeys(firstName);
			surname.sendKeys(lastName);
			age.sendKeys(adultage);
			email.sendKeys(mail);
			street.sendKeys(streetnum);
			place.sendKeys(city);
			postcode.sendKeys(postCode);
			country.click();
			phone.sendKeys(phoneNum);
			childName.sendKeys(childFirstName);
			childLastName.sendKeys(childLastname);
			childAge.sendKeys(chAge);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", check );
			js.executeScript("window.scrollBy(0,250)",  check);  
			/*WebDriverWait wait = new WebDriverWait (driver, 10);
			wait.until(ExpectedConditions.visibilityOf(personalNext))*/;
			js.executeScript("arguments[0].click();", personalNext );
			
			/*Actions act=new Actions(driver);
			act.moveToElement(personalNext).build().perform();
			act.moveToElement(personalNext).click().build().perform();
	        act.perform();
*/								
			return new TreatmentPage();
		}

}
