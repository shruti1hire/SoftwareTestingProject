package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutpage2 extends TestBase
{
	@FindBy(xpath="//span[@class='title']") private WebElement CheckOutpage2label;
	@FindBy(xpath="//button[@id='finish']") private WebElement finishBtn;
	@FindBy(xpath="//button[@id='cancel']") private WebElement cancelBtn;
	@FindBy(xpath="//div[@class='cart_quantity_label']") private WebElement QTYlabel;
	@FindBy(xpath="//div[@class='cart_desc_label']") private WebElement Descriptionlabel;
	@FindBy(xpath="//div[text()='Payment Information']") private WebElement paymentInfoTxt;
	@FindBy(xpath="//div[text()='Shipping Information']") private WebElement shippingInfoTxt;
	@FindBy(xpath="//div[text()='Price Total']") private WebElement pricetotalTxt;
	@FindBy(xpath="//div[@class='summary_info_label summary_total_label']") private WebElement totalTxt;
	
	public CheckOutpage2()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyLabel()
	{
		return CheckOutpage2label.getText();
		
		
	}
	public String clickonfinishBtn()
	{
		finishBtn.click();
		return driver.getCurrentUrl();
	}
	public String clickoncancelBtn()
	{
		cancelBtn.click();
		return driver.getCurrentUrl();
		
	}
	public String verifyDescriptionlabel()
	{
		return Descriptionlabel.getText() ;
	}
	public String verifyQTYlabel()
	{
		return QTYlabel.getText() ;
	}

	public boolean verifyshippingInfoTxt()
	{
		return shippingInfoTxt.isDisplayed() ;
	}
	
	public boolean verifypaymentInfoTxt()
	{
		return paymentInfoTxt.isDisplayed();
	}
	public boolean verifypricetotalTxt()
	{
		return pricetotalTxt.isDisplayed();
	}

	public boolean verifytotallabel()
	{
		return totalTxt.isDisplayed();
	}

	





	
}
