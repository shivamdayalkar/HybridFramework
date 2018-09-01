package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyHomePage {
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
	    driver = BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getconfig().getApplicationUrl());
	}
	@Test
	public void testHomePage() 
	{
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title = home.applicationTitle();
		Assert.assertTrue(title.contains("Yahoo"));
		System.out.println("My application Title is"+title);
		
		
		
	}
   
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser();
	}
	


}
