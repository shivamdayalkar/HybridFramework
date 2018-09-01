package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;
import utility.Helper;

public class VerifyLoginPage {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	@BeforeMethod
	public void setup()
	{
		report = new ExtentReports("C:\\AutomationProject\\workspace\\com.automation.hybrid\\Reports\\LoginPageReport.html",true);
		logger = report.startTest("Verify Test Login");
		
	    driver = BrowserFactory.getBrowser("chrome");
		driver.get(DataProviderFactory.getconfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Application is up and running");
	}
	@Test
	public void testLoginPage() 
	{
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title = home.applicationTitle();
		Assert.assertTrue(title.contains("Yahoo"));
		System.out.println("My application Title is"+ title);
		logger.log(LogStatus.INFO, "HomePage loaded and verified");
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		logger.log(LogStatus.INFO, "Click On sign Link");
	//	logger.log(LogStatus.INFO, "Login to Application");
		//logger.log(LogStatus.INFO, "SignOut successfully");
		login.LoginApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
		logger.log(LogStatus.INFO, "Login to Application");
		logger.log(LogStatus.INFO, "SignOut successfully");
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenshot(driver, "Validation2")));
		
	}
   
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path = Helper.captureScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		BrowserFactory.closeBrowser();
		report.endTest(logger);
		report.flush();
	    report.close();
		
	}
	

}
