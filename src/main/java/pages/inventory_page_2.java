package pages;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;
import utility.HandleDropdownList;
import utility.ReadData;


public class inventory_page_2 extends TestBase
{
	//object repository
	
	@FindBy(xpath="//div[@class='app_logo']") private WebElement AppLogo;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement addTocart;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement CartCount;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement dropDdown;
	@FindBy(xpath="//span[@class='title']") private WebElement ProductsLabel;
	@FindBy(xpath="//a[text()='Twitter']") private WebElement TwitterLogo;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement FacebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement LinkedInLogo;
	@FindBy(xpath="//div[@class='footer_copy']") private WebElement FooterText;
	@FindBy(xpath="//div[@class='bm-burger-button']") private WebElement OpenMenu;
	@FindBy(xpath="//a[@id='inventory_sidebar_link']") private WebElement allitemsidebarLink;
	@FindBy(xpath="//a[@id='about_sidebar_link']") private WebElement aboutsidebarLink;
	//add products
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backpackProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikelightProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement Tshirtproduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement jacketProduct ;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement onesieProduct;
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement TshirtRedProduct;
	//remove products
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement removebackpackProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement removebikelightProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement removeTshirtproduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement removejacketProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-onesie']") private WebElement removeonesieProduct;
	@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement removeTshirtRedProduct;
	
	
	//constructor
	public inventory_page_2()
	{
		PageFactory.initElements(driver, this);  
		
	}
	public String verifyProductsLabel()
	{
		
		return ProductsLabel.getText();
		
	}
	public String verifyAppLogo()
	{
		
		return AppLogo.getText();
		
	}


	
	public boolean verifyTwitterLogo()  
	{
		return TwitterLogo.isDisplayed(); 
		
	}
	public boolean verifyFacebookLogo()  
	{
		return TwitterLogo.isDisplayed();
		
	}
	public boolean verifyLinkedInLogo()  
	{
		return TwitterLogo.isDisplayed();
		
	}
	public String add6products()
	{
		HandleDropdownList.handleSelectClass(dropDdown, "Price (low to high)");
		backpackProduct.click();
		bikelightProduct.click();
		Tshirtproduct.click();
		jacketProduct.click();
		onesieProduct.click();
		TshirtRedProduct.click();
		return CartCount.getText();
		
	}
	public String remove2products() throws InterruptedException
	{
		add6products(); 
		Thread.sleep(3000);
		removebackpackProduct.click();
		removebikelightProduct.click();
		return CartCount.getText();

		
	}
	
		
	public boolean verifyCartLogo()  
	{
		return addTocart.isDisplayed();	
		
	}
	public String LoginToYourCart() 
	   {
		   
		addTocart.click();
		return driver.getCurrentUrl();
	   }
	
	

		

	
	
}
