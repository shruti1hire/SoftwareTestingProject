package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandleDropdownList 
{
	//public bz i wnt to use that method throughout the project then static bz i dnt this method face any issue in other class 
		public static void handleSelectClass(WebElement ele,String value) //in ele=dropdown n value=price(low to high)
		{
			Select sc = new Select(ele);
			sc.selectByVisibleText(value);
		}
}
