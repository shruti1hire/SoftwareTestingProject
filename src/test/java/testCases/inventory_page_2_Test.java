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
import pages.inventory_page_2;
import utility.CaptureScreenshot;
import utility.ReadData;

public class inventory_page_2_Test extends TestBase
{
	LoginPage login;
	inventory_page_2 invent;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login= new LoginPage();   //nd here we declare that global variable
		invent= new inventory_page_2();
		login.loginToApplication();
	}
	@Test(priority=0,enabled=true,groups = "sanity")
	public void verifyProductsLabelTest() throws EncryptedDocumentException, IOException
	{
		String explabel=ReadData.readExcel(0, 3); //Products(0,3) //we make it fail for file
		String actLabel=invent.verifyProductsLabel();
		Assert.assertEquals(explabel, actLabel);
		Reporter.log("Label of Inventory page ="+actLabel);
	}
	
	@Test(priority=9,enabled=true,groups = "regression")
	public void verifyTwitterLogoTest()
	{
		boolean result=invent.verifyTwitterLogo();
		Assert.assertEquals(result, true); //this true compare with this
		Reporter.log("Visibility of Twitter Logo ="+result);
	}
	@Test(priority=8,enabled=true)
	public void verifyAppLogoTest()
	{
		String expLogo="Swag Labs";
		String actLogo=invent.verifyAppLogo();
		Assert.assertEquals(expLogo, actLogo);
	}
	
	@Test(priority=7,enabled=true)
	public void verifyFacebookLogoTest()
	{
		boolean result=invent.verifyFacebookLogo();
		Assert.assertEquals(result, true); //this true compare with this
		Reporter.log("Visibility of Facebook Logo ="+result);
	}
	@Test(priority=6,enabled=true)
	public void verifyLinkedInLogoTest()
	{
		boolean result=invent.verifyTwitterLogo();
		Assert.assertEquals(result, true); //this true compare with this
		Reporter.log("Visibility of LinkedIn Logo ="+result);
	}
	@Test(priority=5,enabled=true)
	public void add6productsTest() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0, 4); //6  (0,4)
		String actCount=invent.add6products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total Products Added To Cart = "+actCount);
	}
	@Test(priority=4,enabled=true)
	public void remove2productsTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0, 5); //4 (0,5)
		String actCount=invent.remove2products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("count of product after removing = "+actCount);
	}
	@Test(priority=3,enabled=true)
	public void verifyCartLogoTest()
	{
		boolean result=invent.verifyCartLogo();
		Assert.assertEquals(result, true); //this true compare with this
		Reporter.log("Visibility of cart Logo ="+result);
	}
	@Test(priority=2,enabled=true)
	public void LoginToYourCartTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0, 8) ;  // for url of cart  Your Cart
		String actURL=invent.LoginToYourCart();
		Assert.assertEquals(expURL, actURL);
	}
	

	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenshot.Screenshot(it.getName());
		}
		driver.close();
	}
}
