package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.UIActions;

public class ProductReviewPage 
{

	WebDriver driver;
	
	public ProductReviewPage(WebDriver d)
	{
		this.driver =d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "AddProductReview_Title")
	public WebElement ReviewTitleField;

	@FindBy(id = "AddProductReview_ReviewText")
	public WebElement ReviewBodyField;
	
	@FindBy(id ="addproductrating_4")
	public WebElement RadioBtnRating;
	
	@FindBy(css = "button.button-1.write-product-review-button")
	public WebElement SubmitBtn;
	
	@FindBy(css= "div.result")
	public WebElement SuccMsg;
	
	
	public void ReviewProduct(String ReviewTitleTxt, String ReviewBodyTxt )
	{
		UIActions.setText(ReviewTitleField, ReviewTitleTxt);
		UIActions.setText(ReviewBodyField, ReviewBodyTxt);
		UIActions.clickButton(RadioBtnRating);
		UIActions.clickButton(SubmitBtn);
	}
	
}
