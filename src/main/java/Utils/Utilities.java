package Utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.BasePage;

public class Utilities extends BasePage{

	public static void click(By by)
	{
		 driver.findElement(by).click();
	}
	
	public static  void explicitWait(By wait)
	{
		WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(prop.getProperty("explicittimeout"))));
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(wait));
	}
	
	public static void enterText(By by,String data)
	{

		explicitWait(by);
		driver.findElement(by).sendKeys(data);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
}
