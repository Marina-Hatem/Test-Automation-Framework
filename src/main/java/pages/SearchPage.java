package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.UIActions;

public class SearchPage 
{
	WebDriver driver;
	public SearchPage(WebDriver d)
	{
		this.driver =d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "small-searchterms")
	WebElement SearchBox;
	
	@FindBy(css = "button.button-1.search-box-button")
	WebElement SearchBtn;
	
	@FindBy(id = "ui-id-1")
	List<WebElement> SuggestionList;
	
	public void SearchOnMac(String ProductName)
	{
		UIActions.setText(SearchBox, ProductName);
		UIActions.clickButton(SearchBtn);
	}
	
	public void SearchWithAutoSuggest(String ProductName) throws InterruptedException
	{
		UIActions.setText(SearchBox, ProductName);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4000);
		SuggestionList.get(0).click();
	}

}
