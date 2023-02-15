package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	By txtUsername = By.name("username");
	By txtPassword = By.name("password");
	By btnLogin    = By.cssSelector("button[type='submit']");
	By errorRequired = By.xpath("(//div/span)[1]");
	By errorInvalid = By.cssSelector("div[class='oxd-alert oxd-alert--error']");
	
	
	public LoginPage()
	{
		super();
	}
	
	public void enterUsername(String un)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(prop.getProperty("explicittimeout"))));
		WebElement userName = wait.until(ExpectedConditions.presenceOfElementLocated(txtUsername));
		userName.sendKeys(un);
	}
	public void enterPassword(String pwd)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(prop.getProperty("explicittimeout"))));
		WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(txtPassword));
		password.sendKeys(pwd);
	}
	public void clickOnLoginBtn()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(prop.getProperty("explicittimeout"))));
		WebElement loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(btnLogin));
		loginBtn.click();
	}
    
	public String getErrormsg()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(prop.getProperty("explicittimeout"))));
		return wait.until(ExpectedConditions.presenceOfElementLocated(errorRequired)).getText();
	}
	
	public String getErrorMsgForInvalidCredentials()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(prop.getProperty("explicittimeout"))));
		return wait.until(ExpectedConditions.presenceOfElementLocated(errorInvalid)).getText();
	}
	
	
	public LandingPage LoginToApp(String un,String pwd)
	{
		enterUsername(un);
		enterPassword(pwd);
		clickOnLoginBtn();
		return new LandingPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
