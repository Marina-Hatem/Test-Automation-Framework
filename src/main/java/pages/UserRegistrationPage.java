package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.*;

public class UserRegistrationPage 
{
	
	WebDriver driver;

	public UserRegistrationPage(WebDriver d)
	{
		this.driver = d;
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(id = "gender-male")
	 WebElement maleOption;
	 
	 @FindBy(id = "FirstName")
	 WebElement FirstName;
	 
	 @FindBy(id = "LastName")
	 WebElement LastName;
	 
	 @FindBy(id = "Email")
	 WebElement Email;
	 
	 @FindBy(id = "Password")
	 WebElement Password;
	 
	 @FindBy(id = "ConfirmPassword")
	 WebElement ConfirmPassword;
	 
	 @FindBy(id = "register-button")
	 WebElement RegBtn;
	 
	 @FindBy(linkText = "Log out")
	 public WebElement LogOutBtn;
	 
	 //I have to make it public because the default is private
	 //and i will have to use it in the testCase
	 @FindBy(css = "div.result")
	 public WebElement sucssesMSG;
 
	 public void Register(String Fname, String Lname, String email, String password)
	 {
		 UIActions.clickButton(maleOption);
		 UIActions.setText(FirstName, Fname);
		 UIActions.setText(LastName, Lname);
		 UIActions.setText(Email, email);
		 UIActions.setText(Password, password);
		 UIActions.setText(ConfirmPassword, password);
		 UIActions.clickButton(RegBtn);
		
	 }
	 
	 public void Logout()
	 {
		 UIActions.clickButton(LogOutBtn);
	 }
}
