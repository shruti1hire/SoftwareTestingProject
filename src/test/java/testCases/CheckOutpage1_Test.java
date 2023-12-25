package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CheckOutpage1;
import pages.LoginPage;
import pages.cartPage;
import pages.inventory_page_2;
import utility.CaptureScreenshot;

public class CheckOutpage1_Test extends TestBase
{
	LoginPage login;
	inventory_page_2 invent;
	cartPage cart;
	CheckOutpage1 check1;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login= new LoginPage();   
		invent= new inventory_page_2();
		cart=new cartPage();
		check1=new CheckOutpage1();
		login.loginToApplication();
		invent.add6products();
		invent.LoginToYourCart();
		cart.verifycheckoutBtn();
		
		
	}

	@Test(priority=3,enabled=true)
	public void verifyURLofCheckOutpage1Test()
	{
		String expURL="https://www.saucedemo.com/checkout-step-one.html";
		String actURL=check1.verifyURLofCheckOutpage1();
		assertEquals(expURL, actURL);
		Reporter.log("URL of checkout page 1" +actURL);
		
	}
	
	@Test(priority=2,enabled=true)
	public void verifyTitleofApplicationTest()
	{
		String expTitle="Checkout: Your Information";
		String actTitle=check1.verifyTitleofApplication();
		assertEquals(expTitle, actTitle);
		Reporter.log("Title of checkout page 1" +actTitle);
	}
	@Test(priority=1,enabled=true)
	public void InputinformationTest()
	{
		String expURL="https://www.saucedemo.com/checkout-step-two.html";
		String actURL=check1.Inputinformation();
		assertEquals(expURL, actURL);
		Reporter.log("Title of checkout page 2" +actURL);
		
	}
	
	
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenshot.Screenshot(it.getName());
		}
		driver.close();
	}
	
}
