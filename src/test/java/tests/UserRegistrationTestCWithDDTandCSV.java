package tests;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import utilities.Helper;
import utilities.WebDrivers;

public class UserRegistrationTestCWithDDTandCSV
{
	WebDriver driver;
	WebDrivers d = new WebDrivers();
	//initializing an obj of CSV Reader class
	CSVReader reader;
	
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
	
	
	@Test
	void UserCanRegisterSuccessFully() throws CsvValidationException, IOException
	{
		//Get path for CSV file
		String CSV_File = System.getProperty("user.dir")+"/src/test/java/data/UserExcelDataCSV.csv";
		reader = new CSVReader(new FileReader(CSV_File));
		 
		//Reading from the file
		//1D because CSV is one string separated by commas.
		String[] csvCell;
		
		//while loop will be executed till the last value in CSV file
		
		while((csvCell = reader.readNext()) != null)
		{
			String Fname = csvCell[0];
			String Lname = csvCell[1];
			String Email = csvCell[2];
			String Pwd = csvCell[3];
			
			UReg = new UserRegistrationPage(driver);
			homeP = new HomePage(driver);
			LoginP = new LoginPage(driver);
			
			//Register
			homeP.OpenRegistrationPage();
			UReg.Register(Fname, Lname, Email , Pwd);
			//asserting on success Message
			Assert.assertEquals("Your registration completed", UReg.sucssesMSG.getText());
			
			//Log Out
			UReg.Logout();

			//Login
			homeP.OpenLoginPage();
			LoginP.Login(Email , Pwd);
			//asserting that log out button is displayed after login
			Assert.assertTrue(UReg.LogOutBtn.isDisplayed());
			
			//Log Out again to rerun the test
			UReg.Logout();	
			
		}	
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
