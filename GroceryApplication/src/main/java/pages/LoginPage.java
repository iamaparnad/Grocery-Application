package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='form-control' and @name='username']")
	WebElement usernameField;
	@FindBy(xpath = "//input[@class='form-control' and @name='password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInButton;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkBox;
	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement homepageText;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertMsg;

	public void enterUsernameOnUsernameField(String username) {
		usernameField.sendKeys(username);
	}

	public void enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
	}

	public HomePage clickOnLoginButton() {
		signInButton.click();
		return new HomePage(driver);
	}

	public boolean ishomePageLoaded() {
		return homepageText.isDisplayed();
	}

	public boolean isAlertDisplayed() {
		return alertMsg.isDisplayed();
	}

	public HomePage loginUsingExcelData() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "GA_LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "GA_LoginPage");
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		signInButton.click();
		return new HomePage(driver);
	}

}
