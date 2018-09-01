package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	@FindBy(id="uh-signin")
	WebElement signInLink;

	@FindBy(id="login-username")
	WebElement username;
	
	@FindBy(xpath="//input[@value='Next']")
	WebElement nextButton;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(id="login-signin")
	WebElement signIn;
	

	@FindBy(xpath="//input[@type='checkbox']")
	WebElement staySignedInCheckbox;
	
	@FindBy(xpath="//input[@name='disagree'][@type='submit']")
	WebElement disagreeButton;
	
	@FindBy(id="uh-avatar")
	WebElement selenium;
	
	@FindBy(xpath="//a[@id='uh-signout']")
	WebElement signOut;
	
	public void LoginApplication(String uid,String pass)
	{   
		signInLink.click();
		username.clear();
		username.sendKeys(uid);
        //staySignedInCheckbox.click();
	    nextButton.click();
	   
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
	    password.clear();
		password.sendKeys(pass);
	    signIn.click();
	    
	  //  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='disagree'][@type='submit']")));
	   // disagreeButton.click();
	   // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='uh-signout']")));
	  
    	selenium.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='uh-signout']")));
    	
	    signOut.click();
	}
	
	
}
