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
	LoginPage login;           
	@BeforeMethod(alwaysRun = true)		   
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login= new LoginPage();          
	}
	@Test(priority=3,enabled=true, groups = "sanity")		
	public void verifyTitleofApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0, 0);  
		String actTitle=login.verifyTitleofApplication();
		Assert.assertEquals(expTitle, actTitle);
	}
	
	@Test(priority=2,enabled=true,groups = {"sanity","retesting"})
	public void verifyURLofApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0, 1);           
		String actURL=login.verifyURLofApplication();
		Assert.assertEquals(expURL, actURL);
	}
	@Test(priority=2,enabled=true,groups = "regression")   
	public void loginToApplicationTest() throws IOException
	{
		String expURL=ReadData.readExcel(0, 2);  
		String actURL=login.loginToApplication();
		Assert.assertEquals(expURL, actURL);
	}	
	@AfterMethod(alwaysRun = true)			
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
