package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.BasePage;
import Pages.LandingPage;
import Pages.LoginPage;

public class LoginPageTest extends BasePage {

	LoginPage loginpage;
	LandingPage landingpage;
	
	@BeforeMethod
	public void setUp()
	{
		init();
		loginpage = new LoginPage();
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void verifyLoginPageWithValidCredentials()
	{
		
		landingpage = loginpage.LoginToApp("Admin","admin123");
		String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(landingpage.getUrl(),expUrl,"landing page url does not matching with " + expUrl);
	}
	
	@Test(dataProvider="getCredentials")
	public void verifyLoginPageWithInvalidCredentials(String un, String pwd)
	{
		loginpage.enterUsername(un);
		loginpage.enterPassword(pwd);
		loginpage.clickOnLoginBtn();
		
		if(un.isBlank() || pwd.isBlank())
		{
			Assert.assertEquals("Required", loginpage.getErrormsg(),"Wrong ErrorMessage for Blank Username/psasword!!!");
		}
		else 
			Assert.assertEquals("Invalid credentials",loginpage.getErrorMsgForInvalidCredentials(),"Wrong ErrorMessage for Invalid username and password !!!");
				
	}
	
	
	@DataProvider(name="getCredentials")
	public Object[][] getData()
	{
		Object[][] data = {
				{"abc","abc"},
				{" ","abc"},
				{"abc"," "}
		};
		return data;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
