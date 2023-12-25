package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutpage1 extends TestBase
{
	@FindBy(xpath="//span[@class='title']") private WebElement titleofCheckOutpage;
	@FindBy(xpath="//input[@name='firstName']") private WebElement firstnameTextBox;
	@FindBy(xpath="//input[@name='lastName']") private WebElement lastnameTextBox;
	@FindBy(xpath="//input[@name='postalCode']") private WebElement ZipcodeTextBox;
	@FindBy(xpath="//input[@name='continue']") private WebElement contineBtn;
	
	public CheckOutpage1()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyURLofCheckOutpage1()
	{
		return driver.getCurrentUrl();
	}
	public String verifyTitleofApplication()
	{
		return titleofCheckOutpage.getText();
	}
	public String Inputinformation() 
	{
		firstnameTextBox.sendKeys("shrutika");
		lastnameTextBox.sendKeys("Hire");
		ZipcodeTextBox.sendKeys("422605");
		contineBtn.click();
		return driver.getCurrentUrl();
	}
	
}
