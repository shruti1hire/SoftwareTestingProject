package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utility.CaptureScreenshot;
import utility.ReadData;

public class LoginPageTest extends TestBase
{
	LoginPage login;           //we take login as global not local bz we want to access it in all code
	@BeforeMethod(alwaysRun = true)		   // before executing testcase method we w8 here(all setup code,clickonurl,openbrowser etc)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login= new LoginPage();          //nd here we declare that global variable
	}
	@Test(priority=3,enabled=true, groups = "sanity")		//,dependsOnMethods ="verifyURLofApplicationTest"		            // here we w8 testcases(our test case is verify the title so add)
	public void verifyTitleofApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0, 0);  //Swag Labs(0,0)
		String actTitle=login.verifyTitleofApplication();
		Assert.assertEquals(expTitle, actTitle);
	}
	
	@Test(priority=2,enabled=true,groups = {"sanity","retesting"})
	public void verifyURLofApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0, 1); //https://www.saucedemo.com/(0,1)           // so basically 1st we w8 this this bt then to give data from excel we use this
		String actURL=login.verifyURLofApplication();
		Assert.assertEquals(expURL, actURL);
	}
	@Test(priority=2,enabled=true,groups = "regression") // ,dependsOnMethods ="verifyURLofApplicationTest" //depends on method means if this urlofapl fail then other 2 test case will also skip even if it wa right bz it depends on that test case 
	public void loginToApplicationTest() throws IOException
	{
		String expURL=ReadData.readExcel(0, 2); //https://www.saucedemo.com/inventory.html(0,2) //we make it wrong bz it will fail take ss
		String actURL=login.loginToApplication();
		Assert.assertEquals(expURL, actURL);
	}	
	@AfterMethod(alwaysRun = true)			//after executing testcase method we w8 here(close browser)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			CaptureScreenshot.Screenshot(it.getName());
		}
		report.flush();
		driver.close();
	}
}
