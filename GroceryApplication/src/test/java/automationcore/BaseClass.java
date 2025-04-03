package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class BaseClass {
	Properties properties;
	FileInputStream file;
	WaitUtility waitutility = new WaitUtility();
	public WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception {

		properties = new Properties();
		file = new FileInputStream(Constant.CONFIGFILE);
		properties.load(file);
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Invalid Browser!!!");
		}
		driver.get(properties.getProperty("baseurl"));
		driver.manage().window().maximize();

		waitutility.implicitWait(driver);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void driverQuit(ITestResult iTestResult) throws IOException // ITestResult is an interface
	{
		driver.quit();
		if (iTestResult.getStatus() == iTestResult.FAILURE) {
			ScreenshotUtility screenshot = new ScreenshotUtility();
			screenshot.getScreenshot(driver, iTestResult.getName());// getname--->method name
		}
	}

}
