package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import pages.cartPage;
import pages.inventory_page_2;
import utility.CaptureScreenshot;
import utility.ReadData;

public class cartPageTest  extends TestBase
{
	LoginPage login;
	inventory_page_2 invent;
	cartPage cart;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login= new LoginPage();   //nd here we declare that global variable
		invent= new inventory_page_2();
		cart=new cartPage();
		login.loginToApplication();
		invent.add6products();
		invent.LoginToYourCart();
		
		
	}
	
	@Test
	public void verifyYourCartLabelTest() throws EncryptedDocumentException, IOException 
	{
		String explabel=ReadData.readExcel(0,9); // your cart label
		String actLabel=cart.verifyYourCartLabel();
		Assert.assertEquals(explabel, actLabel);
		Reporter.log("Label Your Cart  ="+actLabel);
	}
	@Test
	public void verifyCartQTYLabelTest() throws EncryptedDocumentException, IOException 
	{
		String explabel=ReadData.readExcel(0,10); // QTY label //(0,10) we make it wrong for file
		String actLabel=cart.verifyCartQTYLabel();
		Assert.assertEquals(explabel, actLabel);
		Reporter.log(" Label of QTY  ="+actLabel);
	}
	@Test
	public void verifyCartDescriptionLabelTest() throws EncryptedDocumentException, IOException 
	{
		String explabel=ReadData.readExcel(0,11); // Description label
		String actLabel=cart.verifyCartDescriptionLabel();
		Assert.assertEquals(explabel, actLabel);
		Reporter.log("Label of Cart Description  ="+actLabel);
	}
	@Test
	public void verifycontinueshoppingBtnTest() throws EncryptedDocumentException, IOException 
	{
		String expURL=ReadData.readExcel(1, 0);  //url =https://www.saucedemo.com/inventory.html
		String actURL=cart.verifycontinueshoppingBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After Clicking On the Continue Shopping Button = "+actURL);
	}
	@Test
	public void verifycheckoutBtnTest() throws EncryptedDocumentException, IOException 
	{
		String expURL=ReadData.readExcel(1, 1);  //url =https://www.saucedemo.com/checkout-step-one.html
		String actURL=cart.verifycheckoutBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After Clicking On the Checkout Button = "+actURL);
	}
	
	@Test
	public void verifyapplogoTest()
	{
		boolean result=cart.verifyapplogo();
		Assert.assertEquals(result, true); //this true compare with this
		Reporter.log("Visibility of app Logo ="+result);
	}
	@Test
	public void LoginToYourCartTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0, 8) ;  // for url of cart  Your Cart
		String actURL=cart.LoginToYourCart();
		Assert.assertEquals(expURL, actURL);
	}
	@Test
	public void remove3productTest() 
	{
		String expcount="3";
		String actcount=cart.remove3product();
		Assert.assertEquals(expcount, actcount);
		Reporter.log("count after remove  = " +actcount);
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
