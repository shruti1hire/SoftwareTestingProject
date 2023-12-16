package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase   //inheritance
{
	//object repository
	@FindBy(xpath="//input[@name='user-name']") private WebElement userTxtBox;    //encapsulation
	@FindBy(xpath="//input[@name='password']") private WebElement passwordTxtBox;
	@FindBy(xpath="//input[@name='login-button']") private WebElement loginBtn;
	
   public LoginPage()
   {
	   PageFactory.initElements(driver, this);   //constructor
   }
   public String loginToApplication() throws IOException
   {
	   logger=report.createTest("Login to Sauce Lab Application");
	   userTxtBox.sendKeys(ReadData.readPropertyFile("UserName"));
	   logger.log(Status.INFO,  "User Name is entered");
	   passwordTxtBox.sendKeys(ReadData.readPropertyFile("Passwoed"));
	   logger.log(Status.INFO,  "Password is entered");
	   loginBtn.click();
	   logger.log(Status.INFO,  "Login Button is Clicked");
	   logger.log(Status.INFO,  "Login is Successful");
	   return driver.getCurrentUrl();
   }
   public String loginToAppWithMulticreds(String un,String pass) 
   {
	   userTxtBox.sendKeys(un);
	   passwordTxtBox.sendKeys(pass);
	   loginBtn.click();
	   return driver.getCurrentUrl();
   }


   public String verifyTitleofApplication()
   {
	   return driver.getTitle();
   }
   public String verifyURLofApplication() 
   {
	  return driver.getCurrentUrl(); 
   }
}
