package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FileUploadUtility 
{
	public void uploadFileUsingSendkeys(WebElement element,String filepath) 
	{
		element.sendKeys(filepath);
	}
	public void uploadUsingRobotkeys(WebElement element,String filepath) throws AWTException
	{
		
		element.click();
		StringSelection ss=new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);//copying to clipboard to ss file
	  	   Robot robot = new Robot();
		     robot.delay(500);
		     robot.keyPress(KeyEvent.VK_CONTROL);//pressing ctrl
		     robot.keyPress(KeyEvent.VK_V);//pressing v
		     robot.delay(500);//delaying 500 milli seconds 
		     robot.keyRelease(KeyEvent.VK_CONTROL);//relesing ctrl
		     robot.keyRelease(KeyEvent.VK_V);//releasing v
		     robot.delay(500);//delaying 500 milli seconds 
		     robot.keyPress(KeyEvent.VK_ENTER);// pressing enter key
		     robot.keyRelease(KeyEvent.VK_ENTER);// releasing enter key
	}
	
}
