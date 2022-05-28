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
import utilities.Helper;
import utilities.WebDrivers;

public class ProductHoverMenuTestC
{
	

	WebDriver driver;
	WebDrivers d = new WebDrivers();
	HomePage homeP ;
	
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
	void UserCanHoverToNoteBooksPage() throws InterruptedException 
	{
		homeP = new HomePage(driver);
		homeP.HoverToNotebooksPage();
		Thread.sleep(5000);
		Assert.assertTrue(homeP.NotebookPath.getText().equals("Notebooks"));
		
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
