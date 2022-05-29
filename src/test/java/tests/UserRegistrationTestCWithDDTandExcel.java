package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import utilities.Helper;
import utilities.WebDrivers;

public class UserRegistrationTestCWithDDTandExcel 
{
	WebDriver driver;
	WebDrivers d = new WebDrivers();
	
	HomePage homeP ;
	UserRegistrationPage UReg ;
	LoginPage LoginP;
	
	@Parameters({"browser"})
	@BeforeTest
	
	void StartDriver(String browser)
	{
		driver = d.InitializeDriver(browser);
		driver.navigate().to("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}

	@DataProvider(name = "ExcelData")
	public Object[][] userRegisteredData() throws IOException
	{
		//get data from excel reader class
		ExcelReader eReader = new ExcelReader();
		return eReader.getExcelData();
	}
	
	@Test(priority = 1, dataProvider = "ExcelData")
	void UserCanRegisterSuccessFully(String fname, String Lname, String email, String pwd)
	{
		UReg = new UserRegistrationPage(driver);
		homeP = new HomePage(driver);
		LoginP = new LoginPage(driver);
		
		//Register
		homeP.OpenRegistrationPage();
		UReg.Register(fname, Lname, email , pwd);
		//asserting on success Message
		Assert.assertEquals("Your registration completed", UReg.sucssesMSG.getText());
		
		
		//Log Out
		UReg.Logout();
			

		//Login
		homeP.OpenLoginPage();
		LoginP.Login(email , pwd);
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
