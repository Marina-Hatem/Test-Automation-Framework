package steps;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import com.github.javafaker.Faker;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import utilities.WebDrivers;
//runs cucumber every detected feature as separated test
public class UserRegistration
{
	
	WebDriver driver;
	WebDrivers d ;
	
	HomePage homeP ;
	UserRegistrationPage UReg ;
	LoginPage LoginP;
	
	Faker fakeData = new Faker();
	String Fname = fakeData.name().firstName();
	String Lname = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String Password = fakeData.number().digits(8).toString();
	
	//@Parameters({"browser"})
	@Before
	public void StartDriver()
	{
		d = new WebDrivers();
		driver = d.InitializeDriver("chrome");
		driver.navigate().to("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}
	
	@Given("^The user is in the home page$")
	public void The_user_is_in_the_home_page()
	{	
		homeP = new HomePage(driver);
		homeP.OpenRegistrationPage();
	}
	
	@When("^He clicks on Register link$")
	public void He_clicks_on_Register_link()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	
	@And("^He Enters the user data$")
	public void He_Enters_the_user_data()
	{
		UReg = new UserRegistrationPage(driver);
		UReg.Register(Fname, Lname, email , Password);
	}
	
	@Then("^The registration page displayed successfully$")
	public void The_registration_page_displayed_successfully()
	{
		Assert.assertEquals("Your registration completed", UReg.sucssesMSG.getText());
	}
	

}
