package pages;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.UIActions;
public class HomePage 
{
	WebDriver driver;
	UIActions UIAc;
	JavascriptExecutor js;
	
	public HomePage(WebDriver d)
	{
		this.driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Register")
	WebElement registerLink;
	
	@FindBy(linkText = "Log in")
	WebElement LoginLink;
	
	@FindBy(linkText = "My account")
	WebElement MyAccountLink;

	@FindBy(linkText = "Contact us")
	WebElement ContactUsLink;
	
	public void OpenRegistrationPage()
	{
		UIActions.clickButton(registerLink);
	}
	
	public void OpenLoginPage()
	{
		UIActions.clickButton(LoginLink);
	}
	
	public void OpenMyAccountPage()
	{
		UIActions.clickButton(MyAccountLink);
	}
	
	public void OpenContactUsPage() throws InterruptedException
	{
		UIAc = new UIActions(driver, js);
		UIAc.ScrollDown(0,5200);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		UIActions.clickButton(ContactUsLink);
	}

}
