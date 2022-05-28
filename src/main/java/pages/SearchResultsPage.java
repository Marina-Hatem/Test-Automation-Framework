package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.UIActions;

public class SearchResultsPage 
{

	WebDriver driver;
	public SearchResultsPage(WebDriver d)
	{
		this.driver =d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement DemandedSearchResultLink;
	
	public void SelectProduct()
	{
		UIActions.clickButton(DemandedSearchResultLink);
	}
	
}
