package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.UIActions;

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
	
	@FindBy(css = "button.button-2.email-a-friend-button")
	public WebElement EmailAFriendBtn;
	
	@FindBy(id = "price-value-4")
	public WebElement priceValue;
	
	@FindBy(linkText = "Add your review")
	public WebElement AddReviewBtn;
	
	public void OpenEmailAFriendPage()
	{
		UIActions.clickButton(EmailAFriendBtn);
	}
	
	public void OpenReviewPage()
	{
		UIActions.clickButton(AddReviewBtn);
	}
}
