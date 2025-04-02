package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.PageUtility;

public class ManageContact {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	FakerUtility fakerutility = new FakerUtility();

	public ManageContact(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fas fa-edit']")
	WebElement editButton;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement address;
	@FindBy(xpath = "//textarea[@name='del_time']")
	WebElement deliveryTime;
	@FindBy(xpath = "//input[@name='del_limit']")
	WebElement deliveryLimit;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateButton;
	@FindBy(xpath = "//a[text()='Reset']")
	WebElement resetButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMsg;

	public ManageContact clickOnNewButton() {
		editButton.click();
		return this;
	}

	public ManageContact enterPhoneNumber() {
		fakerutility.generatePhno();
		return this;
	}

	public ManageContact enterEmail() {
		fakerutility.generateEmail();
		return this;
	}

	public ManageContact enterAddress() {
		fakerutility.generateAddress();
		return this;
	}

	public ManageContact enterDeliveryTime() {
		pageutility.generateCurrentDateAndTime();
		return this;
	}

	public ManageContact enterDeliveryLimit() {
		fakerutility.generateRandomNumber();
		return this;
	}

	public ManageContact clickOnUpdateButton() {
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).perform();
		updateButton.click();
		return this;
	}

	public ManageContact clickOnResetButton() {
		
		resetButton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alertMsg.isDisplayed();
	}

}
