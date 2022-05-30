package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.opencsv.exceptions.CsvValidationException;

import data.JSONdataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import utilities.Helper;
import utilities.WebDrivers;

public class UserRegistrationTestCWithJavaFaker 
{
	WebDriver driver;
	WebDrivers d = new WebDrivers();
	
	HomePage homeP ;
	UserRegistrationPage UReg ;
	LoginPage LoginP;
	Faker fakeData = new Faker();
	String Fname = fakeData.name().firstName();
	String Lname = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String Password = fakeData.number().digits(8).toString();
	
	@Parameters({"browser"})
	@BeforeTest
	
	void StartDriver(String browser)
	{
		driver = d.InitializeDriver(browser);
		driver.navigate().to("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}
	
	
	@Test
	void UserCanRegisterSuccessFully() throws CsvValidationException, IOException, ParseException
	{
		
			JSONdataReader jsonReader = new JSONdataReader();
			jsonReader.JSONreader();
			UReg = new UserRegistrationPage(driver);
			homeP = new HomePage(driver);
			LoginP = new LoginPage(driver);
			
			//Register
			homeP.OpenRegistrationPage();
			UReg.Register(Fname, Lname, email, Password);
			//asserting on success Message
			Assert.assertEquals("Your registration completed", UReg.sucssesMSG.getText());
			
			//Log Out
			UReg.Logout();

			//Login
			homeP.OpenLoginPage();
			LoginP.Login(email, Password);
			//asserting that log out button is displayed after login
			Assert.assertTrue(UReg.LogOutBtn.isDisplayed());
			
			//Log Out again to rerun the test
			UReg.Logout();	
			
		
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
