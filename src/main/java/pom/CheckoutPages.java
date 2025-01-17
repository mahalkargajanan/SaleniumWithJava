package pom;

	import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

	public class CheckoutPages 
	{
		public WebDriver driver;
		
	
		@FindBy(xpath=("//div[@role='dialog']//div[1]/div[1]/div[1]/div[1]/div[1]/button"))
		private WebElement PopupUpButton;
		
		@FindBy(xpath=("//a[@aria-label='Select options for “Full Fit Propolis Light Ampoule”']//img[@alt='Add to cart']"))
		private WebElement AddToCart;
		
		@FindBy(xpath=("//*[@id=\\\"header\\\"]/div/div[2]/div[3]/div/div/div/div/div[1]/div/div[2]/div[3]/a[2]"))
		private WebElement CheckoutBtn;
		
		@FindBy(id=("bftCountryCurrencySelectorLink"))
		private WebElement Country;
		
		@FindBy(id=("bft_shipping_country"))
		private WebElement Dropdown1;
		
		@FindBy(xpath=("//button[text()='Save']"))
		private WebElement SaveButton;
		
		@FindBy(id=("billing_email"))
		private WebElement InputBillingAddress;
		
		@FindBy(name=("billing_first_name"))
		private WebElement InputfirstName;
		
		@FindBy(id=("billing_last_name"))
		private WebElement InputLastName;
		
		@FindBy(name=("billing_address_1"))
		private WebElement InputAddress;
		
		@FindBy(id=("billing_city"))
		private WebElement InputAddressCity;
		
		
		// for State
		
		@FindBy(xpath=("//span[@id='select2-billing_state-container']"))
		private WebElement StateDropDown;
		
	
		
		@FindAll(@FindBy(how = How.CSS, using = ".select2-results__options>li"))
		private List<WebElement> country_List;
	
		
		
		@FindBy(xpath=("//input[@id='billing_postcode']"))
		private WebElement InputzipCode;
		
		
		@FindBy(xpath=("//input[@id='billing_phone']"))
		private WebElement InputPhone;
		
		
		// For Stripe
		
		@FindBy(id=("payment_method_stripe_cc"))
		private WebElement PaymentBtn;
		
		
		@FindBy(xpath=("//*[@id=\\\"wc-stripe-card-element\\\"]/div/iframe"))
		private WebElement SwitchToFrame;
		
		
		@FindBy(xpath=("//*[@id=\\\"Field-numberInput\\\"]"))
		private WebElement InputStripe;

		@FindBy(xpath=("//*[@id=\\\"Field-expiryInput\\\"]"))
		private WebElement SendExpired;
		
		@FindBy(xpath=("//*[@id=\\\"Field-cvcInput\\\"]"))
		private WebElement SendCvv;
		
		
		@FindBy(id=("place_order"))
		private WebElement PlaceButton;
		
		
		
		// PayPal Button
		
		@FindBy(xpath=("/html/body/div[4]/div[2]/div/div/div/div/form/div/div[2]/div/div[2]/div/div[3]/div/div/iframe[1]"))
		private WebElement PayPalBtn;
	
		
		// constructor 
		
		public CheckoutPages (WebDriver driver) 
		{
			this.driver = driver;
			
			PageFactory.initElements(driver, this);
			
		}
		
		
	public void clickOnClosePopUp() 
	{
		
	  PopupUpButton.click();
		
	}
	
	public void clickToAdd()
	{
		AddToCart.click();
	}
	
	public void ClickToCheckout () 
	{
		
		CheckoutBtn.click();	
	}
	
	public void SelectCountrydropdown() 
	{
	
		Country.click();
				
	}
	
	public void DropDownClick(String Dropdown)
	{
		Select s = new Select(Dropdown1);
		
		 s.selectByValue(Dropdown);
	
	}
	
	
	public void select_Country(String countryName)
	{
	 	Dropdown1.click();
		try { Thread.sleep(2000);}
		catch (InterruptedException e) {}

		for(WebElement country : country_List){
			if(country.getText().equals(countryName)) {
				country.click();	
				try { Thread.sleep(3000);}
				catch (InterruptedException e) {}
				break;
			}
		}
	}
	 
	
	public void ClickOnSaveButton() 
	{
		SaveButton.click();
	}
	
	public void SendEmailID(String email) 
	{
		InputBillingAddress.sendKeys(email);
	}
	
	public void SendFirstName(String Name) 
	{
		InputfirstName.sendKeys(Name);
	}
	
	public void SendLastName(String LastName) 
	{
		InputLastName.sendKeys(LastName);
	}
	
	public void SendBilligAdd(String BillingAddress) 
	{
		InputAddress.sendKeys(BillingAddress);
	}
	
	public void SendCityName(String CityName)
	
	{
		InputAddress.sendKeys(CityName);
	}
	
	
	public void SelectState(String StateName)
	{
		InputAddress.click();
		
		}
	public void select_State(String StateName) 
	{
		StateDropDown.click();
		try { Thread.sleep(2000);}
		catch (InterruptedException e) {}

		for(WebElement State : country_List){
			if(State.getText().equals(StateName)) 
			{
				State.click();	
				try { Thread.sleep(3000);}
				catch (InterruptedException e) {}
				break;
			}
		}
	}
	
	public void SendZipCode(String ZipCode)
	{
		InputzipCode.sendKeys(ZipCode);
	}
	
	
	public void SendPhoneNo(String PhoneNo)
	{
		InputPhone.sendKeys(PhoneNo);
	}
	
	  
	   // Stripe iFrame
	
		   public void switchToIStripeframe() 
		   {
		        driver.switchTo().frame(SwitchToFrame);
		   
	       }
	
	public void clickOnStripe()
	{
		PaymentBtn.click();
		
	}
	
	public void SendStripeDetails(String CardNo)
	{
		InputStripe.sendKeys(CardNo);
	}
	
	public void SendExpiredDate(String ExpiredDate) 
	{
	
		SendExpired.sendKeys(ExpiredDate);
	}
	
	public void SendCvvNo(String CvvNo)
	{
		SendCvv.sendKeys(CvvNo);
	}
	
	public void ClickPlaceBtn() 
	{
		PlaceButton.click();
	}
	
	// PayPal 
	
	public void ClickPayPal()
	{
		PayPalBtn.click();
	}
	
	
	}
