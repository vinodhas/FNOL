package org.sfdc.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sfdc.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver=null;
	public static Properties prop=null;
	
	public TestBase()
	{
		try{
			prop=new Properties();
			FileInputStream fis= new FileInputStream("/Users/vinodha.s/workspace/POC/api/src/main/java/"
					+ "org/sfdc/config/config.properties");
			prop.load(fis);
		}
		catch(FileNotFoundException f)
		{
			f.printStackTrace();
		}
		catch(IOException f)
		{
			f.printStackTrace();
		}
		
	}
	
	public static void initialisation()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","//C:/Users/vinodha.s/Downloads/chromedriver.exe");
			//ChromeOptions options = new ChromeOptions();
			//setting the English language
			//options.addArguments("--lang=en-us");
			driver= new ChromeDriver();
		}
		if(browserName.equals("ff"))
		{
			System.setProperty("webdriver.gecko.driver","//C:/Users/vinodha.s/Downloads/geckodriver.exe");
			//ChromeOptions options = new ChromeOptions();
			//setting the English language
			//options.addArguments("--lang=en-us");
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("urlGER"));
		
	}
	
	

}
