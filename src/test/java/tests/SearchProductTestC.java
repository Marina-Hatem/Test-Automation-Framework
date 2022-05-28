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
import pages.SearchResultsPage;
import utilities.Helper;
import utilities.WebDrivers;

public class SearchProductTestC 
{
	
	WebDriver driver;
	WebDrivers d = new WebDrivers();
	
	SearchPage searchObj;
	ProductDetailsPage ProductDetailsObj;
	SearchResultsPage SearchResultsObj;
	
	String searchValue="Apple MacBook Pro 13-inch";
	
	
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
	void UserCanSearchForProduct()
	{
		searchObj = new SearchPage(driver);
		ProductDetailsObj = new ProductDetailsPage(driver);
		SearchResultsObj = new SearchResultsPage(driver);
		
		searchObj.SearchOnMac(searchValue);
		SearchResultsObj.SelectProduct();
		Assert.assertTrue(ProductDetailsObj.CurrentproductName.getText().equalsIgnoreCase(searchValue));
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
