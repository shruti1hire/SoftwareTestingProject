package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CheckOutpage1;
import pages.CheckOutpage2;
import pages.LoginPage;
import pages.cartPage;
import pages.inventory_page_2;
import utility.CaptureScreenshot;

public class CheckOutpage2_Test extends TestBase
{
	LoginPage login;
	inventory_page_2 invent;
	cartPage cart;
	CheckOutpage1 check1;
	CheckOutpage2 check2;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login= new LoginPage();   
		invent= new inventory_page_2();
		cart=new cartPage();
		check1=new CheckOutpage1();
		check2=new CheckOutpage2();
		login.loginToApplication();
		invent.add6products();
		invent.LoginToYourCart();
		cart.verifycheckoutBtn();
		check1.Inputinformation();
		
		
	}

	@Test(priority=8,enabled=true)
	public void verifyLabelTest()
	{
		String expLabel="Checkout: Overview";
		String actLabel= check2.verifyLabel();
		assertEquals(expLabel, actLabel);
		Reporter.log("label of checkout page 2="+actLabel);
		
	}
	@Test(priority=7,enabled=true)
	public void clickonfinishBtnTest()
	{
		String expURL="https://www.saucedemo.com/checkout-complete.html";
		String actURL= check2.clickonfinishBtn();
		assertEquals(expURL, actURL);
		Reporter.log("Url of Complete page= "+actURL);
		
	}
	@Test(priority=6,enabled=true)
	public void clickoncancelBtnTest()
	{
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL= check2.clickoncancelBtn();
		assertEquals(expURL, actURL);
		Reporter.log("Url of checkout page 2="+actURL);
		
	}

	@Test(priority=5,enabled=true)
	public void verifyDescriptionlabelTest()
	{
		String expLabel="Description";
		String actLabel= check2.verifyDescriptionlabel();
		assertEquals(expLabel, actLabel);
		Reporter.log("verify the description label="+actLabel);
		
	}

	@Test(priority=4,enabled=true)
	public void verifyQTYlabelTest()
	{
		String expLabel="QTY";
		String actLabel= check2.verifyQTYlabel();
		assertEquals(expLabel, actLabel);
		Reporter.log("verify the Qty label="+actLabel);
		
	}
	@Test(priority=3,enabled=true)
	public void verifyshippingInfoTxtTest()
	{
		boolean result=check2.verifyshippingInfoTxt();
		Assert.assertEquals(result, true); 
		Reporter.log("verify shipping info text ="+result);
	}
	@Test(priority=2,enabled=true)
	public void verifypaymentInfoTxtTest()
	{
		boolean result=check2.verifypaymentInfoTxt();
		Assert.assertEquals(result, true); 
		Reporter.log("verify payment info text ="+result);
	}
	@Test(priority=1,enabled=true)
	public void verifypricetotalTxtTest()
	{
		boolean result=check2.verifypricetotalTxt();
		Assert.assertEquals(result, true); 
		Reporter.log("verify price total text ="+result);
	}
	@Test(priority=9,enabled=true)
	public void verifytotallabelTest()
	{
		boolean result=check2.verifytotallabel();
		Assert.assertEquals(result, true); 
		Reporter.log("verify  total label ="+result);
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
