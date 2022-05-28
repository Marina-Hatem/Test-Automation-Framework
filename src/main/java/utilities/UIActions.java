package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UIActions 
{

	public JavascriptExecutor js;
	WebDriver driver;
	
	public UIActions(WebDriver d, JavascriptExecutor javaObj)
	{
		this.driver = d;
		this.js = javaObj;
		js = (JavascriptExecutor) driver;
	}
	
	//click()
	public static void clickButton(WebElement button)
	{
		button.click();
	}
	
	//sendKeys()
	public static void setText(WebElement element, String value)
	{
		element.sendKeys(value);
	}
	
	//ScrollDown()
	public void ScrollDown(int x, int y)
	{
			try 
			{
				js.executeScript("scrollBy("+x+","+y+")");
				
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}		
	}
	
	
}
