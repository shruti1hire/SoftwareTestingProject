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
import pages.CheckOutpage2;
import pages.Finishpage;
import pages.LoginPage;
import pages.cartPage;
import pages.inventory_page_2;
import utility.CaptureScreenshot;

public class Finishpage_Test extends TestBase
{
	LoginPage login;
	inventory_page_2 invent;
	cartPage cart;
	CheckOutpage1 check1;
	CheckOutpage2 check2;
	Finishpage finish;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login= new LoginPage();   //nd here we declare that global variable
		invent= new inventory_page_2();
		cart=new cartPage();
		check1=new CheckOutpage1();
		check2=new CheckOutpage2();
		finish=new Finishpage();
		login.loginToApplication();
		invent.add6products();
		invent.LoginToYourCart();
		cart.verifycheckoutBtn();
		check1.Inputinformation();
		check2.clickonfinishBtn();
		
		
	}

	@Test(priority=5,enabled=true)
	public void verifyTitleofFinishpageTest()
	{
		String expTitle="Checkout: Complete!";
		String actTitle= finish.verifyTitleofFinishpage();
		assertEquals(expTitle, actTitle);
		Reporter.log("label of complete page="+actTitle);
		
	}
	@Test(priority=4,enabled=true)
	public void verifyimgTest()
	{
		boolean result=finish.verifyimg();
		assertEquals(result, true);
		Reporter.log("Visibility of img ="+result);
	}
	@Test(priority=3,enabled=true)
	public void verifyThankYouTextTest()
	{
		boolean result=finish.verifyThankYouText();
		assertEquals(result, true);
		Reporter.log("Visibility of Thank You Text ="+result);
	}
	@Test(priority=2,enabled=true)
	public void verifycompleteTextTest()
	{
		boolean result=finish.verifycompleteText();
		assertEquals(result, true);
		Reporter.log("Visibility of Complete Text ="+result);
	}
	@Test(priority=1,enabled=true)
	public void clickoncancelBtnTest()
	{
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL= finish.clickonBacktoHomeBtn();
		assertEquals(expURL, actURL);
		Reporter.log("Url of Back to Home="+actURL);
		
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
