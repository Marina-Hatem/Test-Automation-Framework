package tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import utilities.Helper;
import utilities.WebDrivers;

public class UserRegistrationTestC 
{
	WebDriver driver;
	WebDrivers d = new WebDrivers();
	
	HomePage homeP ;
	UserRegistrationPage UReg ;
	LoginPage LoginP;
	
	String Fname ="Marina";
	String Lname ="Hatem";
	String Email = "Test1@gmail.com";
	String OldPassword ="1234GO";
	
	@Parameters({"browser"})
	@BeforeTest
	
	void StartDriver(String browser)
	{
		driver = d.InitializeDriver(browser);
		driver.navigate().to("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}

	@Test(priority = 1)
	void UserCanRegisterSuccessFully() throws InterruptedException
	{
		UReg = new UserRegistrationPage(driver);
		homeP = new HomePage(driver);
		
		homeP.OpenRegistrationPage();
		UReg.Register(Fname, Lname, Email , OldPassword);
		
		//asserting on success Message
		Assert.assertEquals("Your registration completed", UReg.sucssesMSG.getText());
	}
	
	@Test(dependsOnMethods = {"UserCanRegisterSuccessFully"})
	void RegisteredUserCanLogOut()
	{
		UReg.Logout();
	}

	
	@Test(dependsOnMethods = {"RegisteredUserCanLogOut"})
	void RegisteredUserCanLogin()
	{
		homeP.OpenLoginPage();
		LoginP = new LoginPage(driver);
		LoginP.Login(Email , OldPassword);
		//asserting that log out button is displayed after login
		Assert.assertTrue(UReg.LogOutBtn.isDisplayed());
	}


	@AfterTest
	void EndDriver()
	{
		d.CloseWebsite();
	}

	
	//Takes screenshot if any method fails and add it to the screenshots folder
	@AfterMethod
	//The ITestResult is an interface that has the result of testcases
	public void ScreenshotOnFailure(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed");
			System.out.println("Taking Screenshot...");
			Helper.CaptureScreenshot(driver, result.getName());
		}
	}

}
