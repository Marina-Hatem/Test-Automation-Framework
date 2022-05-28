package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UIActions 
{

	public JavascriptExecutor js;
	WebDriver driver;
	public Select select;
	public Actions action;
	
	
	public UIActions(WebDriver d)
	{
		this.driver = d;
		js = (JavascriptExecutor) d;
		action = new Actions(d);		
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
	
	//DropDownList by visible text
	public void SelectFromDropDownByVisibleText(WebElement e, String Txtvalue)
	{
		select = new Select(e);
		select.selectByVisibleText(Txtvalue);
	}
	
	//DropDownList by visible index
	public void SelectFromDropDownByIndex(WebElement e, int index)
	{
		select = new Select(e);
		select.selectByIndex(index);
	}
	
	//Hover
	public void Hover(WebElement a, WebElement b)
	{
		action.moveToElement(a).moveToElement(b).click().build().perform();
	}
	
	
}
