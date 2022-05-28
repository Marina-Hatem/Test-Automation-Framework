package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper 
{

	//Method to take screenshot when the test cases fail
	//static so i can use it without creating an object
	//takes a webdriver that will be used in the testcase
	//creates a name to the screenshot with the name of the testcase
	public static void CaptureScreenshot(WebDriver driver, String screenshotName) 
	{
		//Where i will save the screenshot
		Path destination = Paths.get("./Screenshots", screenshotName+".png");
		try 
		{
			Files.createDirectories(destination.getParent());
			FileOutputStream out = new FileOutputStream(destination.toString());
			//the driver will take the screenshot as BYTES To be saved
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		}
		catch (IOException e) 
		{
			System.out.println("Exception while taking screenshot"+ e.getMessage());
		}
		
		
	}
	
}
