package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public static Properties prop;
	public static WebDriver driver;

	public BasePage() {
		String fileName = System.getProperty("user.dir") + "/src/test/resources/Config.properties";
		try {
			FileInputStream fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File Not Found...!!!" + fileName);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Config.properties not load...!!!" + fileName);
		}
	}

	public void init() {

		String browser;
		browser = System.getProperty("browser");

		if (browser == null)
			browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("CHROME")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else
			throw new RuntimeException("Ivalid browser..." + browser);

		driver.get(prop.getProperty("url"));

		boolean maximize = Boolean.parseBoolean(prop.getProperty("maximize"));

		if (maximize)
			driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("timeout"))));

	}

	public String getScreenshot(String testCaseName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		File file = new File(System.getProperty("user.dir") + "/src/test/resources/Reports/" + testCaseName + ".png");

		try {
			FileUtils.copyFile(source, file);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error in Copying source file....!!!");
		}

		return System.getProperty("user.dir") + "/src/test/resources/Reports/" + testCaseName + ".png";
	}

}
