package utility;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBase;

//it is predefined code

public class CaptureScreenshot extends TestBase
{
	public static String getDate()
	{
		return new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
	}
	public static void Screenshot(String nameofMethod) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest =new File("C:\\Users\\USER\\eclipse-workspace\\Software_testing_framework\\Screenshot\\" +nameofMethod+"--" +getDate()+".jpeg"); //screenshot folder path nd last add \\ 
		FileHandler.copy(source, dest);
	}
}
