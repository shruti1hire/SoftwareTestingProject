package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class cartPage extends TestBase 
{
	
	//label
		@FindBy(xpath="//span[text()='Your Cart']") private WebElement YourCartLabel;
		@FindBy(xpath="//div[@class='cart_quantity_label']") private WebElement CartQTYLabel;
		@FindBy(xpath="//div[@class='cart_desc_label']") private WebElement CartDescriptionLabel;
		
		@FindBy(xpath="//button[@id='continue-shopping']") private WebElement continueshoppingBtn;
		@FindBy(xpath="//button[@id='checkout']") private WebElement checkoutBtn;
		@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement CartCounts;
		@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement Cartlogo;
		@FindBy(xpath="//div[@class='app_logo']") private WebElement applogo;
		
		
		
		//remove products

		@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement removebikelight;
		@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement removeTshirt;
		@FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement removejacket;
		@FindBy(xpath="//button[@id='remove-sauce-labs-onesie']") private WebElement removeonesieProduct;
		@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement removeTshirtRed;
		@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement removebackpack;
		
		public cartPage()
		{
			PageFactory.initElements(driver, this);  
			
		}
		

		public String verifyYourCartLabel()
		{
			
			return YourCartLabel.getText();
			
		}
		public String verifyCartQTYLabel()
		{
			
			return CartQTYLabel.getText();
			
		}
		public String verifyCartDescriptionLabel()
		{
			
			return CartDescriptionLabel.getText();
			
		}
		public String verifycontinueshoppingBtn()  
		{
			   continueshoppingBtn.click();
			   return driver.getCurrentUrl();		
		}
		public String verifycheckoutBtn()  
		{
			   checkoutBtn.click();
			   return driver.getCurrentUrl();		
		}
		
		public boolean verifyapplogo()  
		{
			return applogo.isDisplayed();
			
		}
		public String LoginToYourCart() 
		   {
			   
			Cartlogo.click();
			return driver.getCurrentUrl();
		   }
	/*	public String add6productscart()
		{
			
			backpackProduct.click();
			bikelightProduct.click();
			Tshirtproduct.click();
			jacketProduct.click();
			onesieProduct.click();
			TshirtRedProduct.click();
			return CartCount1.getText();
			
		} */
		
		public String remove3product()
		{
			removebikelight.click();
			removeTshirt.click();
			removebackpack.click();
			return CartCounts.getText();
			
		}
		
		


				

}
