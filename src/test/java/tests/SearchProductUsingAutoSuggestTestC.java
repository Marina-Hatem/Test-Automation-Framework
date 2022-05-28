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

import pages.ProductDetailsPage;
import pages.SearchPage;
import utilities.Helper;
import utilities.WebDrivers;

public class SearchProductUsingAutoSuggestTestC 

{
	
	WebDriver driver;
	WebDrivers d = new WebDrivers();
	
	SearchPage searchObj;
	ProductDetailsPage ProductDetailsObj;
	String searchValue ="mac";
	String ProductName="Apple MacBook Pro 13-inch";
	
	
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
	void UserCanSearchForProductWithAutoSuggest() throws InterruptedException
	{
		searchObj = new SearchPage(driver);
		ProductDetailsObj = new ProductDetailsPage(driver);
		searchObj.SearchWithAutoSuggest(searchValue);
		Assert.assertEquals(ProductDetailsObj.CurrentproductName.getText(), ProductName);
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
