package utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;

public class WebDrivers 
{
	WebDriver driver;
	//optional annotation means that if nothing is passed make chrome the default
	public WebDriver InitializeDriver(@Optional("chrome") String dName)
	{
		//Setting all the Web drivers
		if(dName.equals("chrome"))
		{
			String chromepath = System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromepath);
			driver = new ChromeDriver();
		}
		else if(dName.equals("firefox"))
		{
			String Firefoxpath = System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", Firefoxpath);
			driver = new FirefoxDriver();
		}
		else if(dName.equals("edge"))
		{
			String EdgePath = System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe";
			System.setProperty("webdriver.edge.driver", EdgePath);
			driver = new EdgeDriver();
		}
		return driver;
	}
	
	
	public void CloseWebsite()
	{
		driver.quit();
		//System.out.println("We close");
	}
	
}
