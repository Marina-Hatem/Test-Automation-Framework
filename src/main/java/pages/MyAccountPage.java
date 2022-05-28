package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.UIActions;

public class MyAccountPage 
{
	WebDriver driver;
	
	public MyAccountPage(WebDriver d)
	{
		this.driver = d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText = "Change password")
	WebElement ChangePwdLink;
	
	
	@FindBy (id = "OldPassword")
	WebElement OldPwdField;
	
	@FindBy (id = "NewPassword")
	WebElement NewPwdField;
	
	@FindBy (id = "ConfirmNewPassword")
	WebElement ConfirmPwdField;
	
	@FindBy (css = "button.button-1.change-password-button")
	WebElement SubmitBtn;
	
	@FindBy (css = "div.bar-notification.success")
	public WebElement PsswdChangedSuccMSG;
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[2]/div[1]/a")
	public WebElement HomeImgLink;
	
	
	public void OpenChangePwdPage()
	{
		UIActions.clickButton(ChangePwdLink);
	}
	
	public void ChanegPassword(String OldPwd, String NewPwd)
	{
		UIActions.setText(OldPwdField, OldPwd);
		UIActions.setText(NewPwdField, NewPwd);
		UIActions.setText(ConfirmPwdField, NewPwd);
		UIActions.clickButton(SubmitBtn);
	}
	

	public void BackHome() {

		UIActions.clickButton(HomeImgLink);
		
	}
	
	
}
