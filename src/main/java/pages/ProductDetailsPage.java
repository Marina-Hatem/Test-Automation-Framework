package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage 
{
	WebDriver driver;
	
	public ProductDetailsPage(WebDriver d)
	{
		this.driver =d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "strong.current-item")
	public WebElement CurrentproductName;
	
	

}
