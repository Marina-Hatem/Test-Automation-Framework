package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.UIActions;

public class LoginPage 
{
	WebDriver driver;

	
	public LoginPage(WebDriver d)
	{
		this.driver =d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email")
	WebElement EmailField;
	
	@FindBy(id ="Password")
	WebElement PassField;
	
	@FindBy(css = "button.button-1.login-button")
	WebElement LoginBtn;
	
	public void Login(String emailInput, String PassInput)
	{
		UIActions.setText(EmailField, emailInput);
		UIActions.setText(PassField, PassInput);
		UIActions.clickButton(LoginBtn);
		
	}

}
