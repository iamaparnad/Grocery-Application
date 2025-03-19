package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility// used to capture the current report
{
	public void getScreenshot(WebDriver driver, String failedtestcase) throws IOException 
	{
		TakesScreenshot scrShot = (TakesScreenshot) driver;//TakesScreenshot is an interface
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//capture the screenshot and store it in a temporary path in file format
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");//creating a new folder in the current project directory
		if (!f1.exists()) 
		{
			f1.mkdirs(); // mkdir --> will create folder using java
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedtestcase + timeStamp+ ".png";//format of screenshot
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination);//copy from temporary path to project folder

	}
}
