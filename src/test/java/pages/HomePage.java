package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	@FindBy(id="uh-signin")
	WebElement signInLink;

	
	public String applicationTitle()
	{
		return driver.getTitle();
	}
	
	public void clickOnSignInLink(){
		signInLink.click();
		
	}
}
