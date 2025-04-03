package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public void fluentWaitElements(WebDriver driver, WebElement element, String attribute, String attributeValue,
			int total) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
	}

	public void waitForWebElementAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void elementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void invisibilityOfAnElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForElementToContainText(WebDriver driver, WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public void waitForElementToBeEnabled(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(element, "disabled", "true")));
	}

	public void waitForTitleToContain(WebDriver driver, String titleText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains(titleText));
	}

	public void waitForUrlToContain(WebDriver driver, String urlText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains(urlText));
	}

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
