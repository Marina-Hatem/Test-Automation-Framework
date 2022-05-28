package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.UIActions;

public class ContactUsPage 

{
	WebDriver driver;
	public ContactUsPage(WebDriver d)
	{
		this.driver = d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "FullName")
	WebElement NameField;
	
	@FindBy(id = "Email")
	WebElement EmailField;
	
	@FindBy(id = "Enquiry")
	WebElement EnquiryField;
	
	@FindBy(css = "button.button-1.contact-us-button")
	WebElement SubmitBtn;
	
	@FindBy(css = "div.result")
	public WebElement SuccessMsg;
	
	public void SubmitEnquiry(String nameTxt, String emailTxt, String EnquiryTxt)
	{
		UIActions.setText(NameField, nameTxt);
		UIActions.setText(EmailField, emailTxt);
		UIActions.setText(EnquiryField, EnquiryTxt);
		UIActions.clickButton(SubmitBtn);
	}
	
	
}
