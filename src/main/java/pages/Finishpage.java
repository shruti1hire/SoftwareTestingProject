package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import base.TestBase;

public class Finishpage extends TestBase
{
	@FindBy(xpath="//span[text()='Checkout: Complete!']") private WebElement TitleofFinishpage;
	@FindBy(xpath="//img[@class='pony_express']") private WebElement img;
	@FindBy(xpath="//h2[@class='complete-header']") private WebElement ThankYouText;
	@FindBy(xpath="//div[@class='complete-text']") private WebElement completeText;
	@FindBy(xpath="//button[@id='back-to-products']") private WebElement BacktoHomeBtn;
	
	public Finishpage()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyTitleofFinishpage()
	{
		return TitleofFinishpage.getText();
		
	}
	public boolean verifyimg()
	{
		return img.isDisplayed();
	}
	public boolean verifyThankYouText()
	{
		return ThankYouText.isDisplayed();
	}
	public boolean verifycompleteText()
	{
		return completeText.isDisplayed();
	}

	
	public String clickonBacktoHomeBtn()
	{
		BacktoHomeBtn.click();
		return driver.getCurrentUrl();
	}
	
	
	
	
	
	
}
