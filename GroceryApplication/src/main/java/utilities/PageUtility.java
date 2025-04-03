package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public String selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public String selectDropdownByIndex(WebElement element, int index) {
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
		return dropdown.getFirstSelectedOption().getText();
	}

	public boolean isMultiSelectDropdown(WebElement element) {
		Select dropdown = new Select(element);
		return dropdown.isMultiple();
	}

	public void deselectAllOptions(WebElement element) {
		Select dropdown = new Select(element);
		if (dropdown.isMultiple()) {
			dropdown.deselectAll();
		}
	}

	public void hoverOverElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void rightClickElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public void dragAndDropElement(WebDriver driver, WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}

	public String selectDropdownwithVisibleText(WebElement element, String text) {
		Select object = new Select(element);
		object.selectByVisibleText(text);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}

	public String getCurrentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.format(new Date());
	}

	public String getCurrentTimestamp() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return formatter.format(new Date());
	}

	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

}
