package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage{

	By linkAdmin = By.xpath("(//div[@class='oxd-sidepanel-body']//a)[1]");
	AdminPage adminpage;
	public LandingPage()
	{
		super();
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public AdminPage clickOnAdmin()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(prop.getProperty("explicittimeout"))));
		wait.until(ExpectedConditions.presenceOfElementLocated(linkAdmin)).click();
		
		return new AdminPage();
	}
	
	
	public String getUrl()
	{
		return driver.getCurrentUrl();
	}
	
}