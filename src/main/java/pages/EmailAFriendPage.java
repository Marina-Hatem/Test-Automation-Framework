package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.UIActions;

public class EmailAFriendPage 
{
	WebDriver driver;
	UIActions UIAc;

	public EmailAFriendPage(WebDriver d)
	{
		this.driver = d;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id ="FriendEmail")
	WebElement FriendEmailField;
	
	@FindBy(id ="PersonalMessage")
	WebElement PersonalMessageField;
	
	@FindBy(css = "button.button-1.send-email-a-friend-button")
	WebElement SubmitBtn;
	
	@FindBy(css = "div.result")
	public WebElement SuccessMsg;
	
	public void EmailAFriend(String FriendEmail, String PersonalMsg)
	{
		UIActions.setText(FriendEmailField, FriendEmail);
		UIActions.setText(PersonalMessageField, PersonalMsg);
		UIActions.clickButton(SubmitBtn);
		
	}
}
