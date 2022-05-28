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

import pages.EmailAFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.SearchResultsPage;
import pages.UserRegistrationPage;
import utilities.Helper;
import utilities.WebDrivers;

public class EmailAFriendTestC
{
	WebDriver driver;
	WebDrivers d = new WebDrivers();
	
	HomePage homeP ;
	UserRegistrationPage UReg ;
	LoginPage LoginP;
	MyAccountPage MyAccP;
	SearchPage searchObj;
	ProductDetailsPage ProductDetailsObj;
	SearchResultsPage SearchResultsObj;
	EmailAFriendPage EmailAFriendObj;
	
	String Fname ="Marina";
	String Lname ="Hatem";
	String Email = "Test1@gmail.com";
	String OldPassword ="1234GO";
	String searchValue="Apple MacBook Pro 13-inch";
	String FriendEmail ="Hany@gmail.com";
	String PersonalMessage ="This product is for you";
	
	
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
	
	@Test(priority =2)
	
	void GoBackHome()
	{
		MyAccP = new MyAccountPage(driver);
		MyAccP.BackHome();
	}
	
	@Test(priority =3)
	void UserCanSearchForProduct()
	{
		searchObj = new SearchPage(driver);
		ProductDetailsObj = new ProductDetailsPage(driver);
		SearchResultsObj = new SearchResultsPage(driver);
		
		searchObj.SearchOnMac(searchValue);
		SearchResultsObj.SelectProduct();
		Assert.assertTrue(ProductDetailsObj.CurrentproductName.getText().equalsIgnoreCase(searchValue));
	}
	
	
	
	@Test(priority = 4)
	void UserCanEmailAFriend()
	{
		ProductDetailsObj.OpenEmailAFriendPage();
		EmailAFriendObj = new EmailAFriendPage(driver);
		EmailAFriendObj.EmailAFriend(FriendEmail, PersonalMessage);
		Assert.assertEquals(EmailAFriendObj.SuccessMsg.getText(), "Your message has been sent.");
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
