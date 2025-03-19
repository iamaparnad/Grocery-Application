package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageNews {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public ManageNews(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	WebElement newButton;
	@FindBy(xpath = "//input[@placeholder='Title']")
	WebElement newsTextBox;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchAlongWithNewsTextBox;
	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	WebElement searchButton;
	@FindBy(xpath = "//textarea[@placeholder='Enter the news']")
	WebElement newsDescription;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMsg;
	@FindBy(xpath = "//i[@class='fas fa-trash-alt']")
	WebElement deleteItem;
	@FindBy(xpath="//i[@class='fas fa-edit']")WebElement editButton;
	@FindBy(xpath="//textarea[@id='news']")WebElement textArea;
	

	public ManageNews clickOnNewButton() {
		newButton.click();
		newsDescription.sendKeys("20% Discout" + pageutility.generateCurrentDateAndTime());
		saveButton.click();
		return this;
	}

	public ManageNews searchExistingNews() {
		searchButton.click();
		newsTextBox.sendKeys("Latest News 2025");
		searchAlongWithNewsTextBox.click();
		return this;
	}

	public ManageNews clickOnsearchButton() {
		searchButton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alertMsg.isDisplayed();
	}
	public ManageNews clickOnEditButton() 
	{
		editButton.click();
		textArea.sendKeys("Latest News"+ pageutility.generateCurrentDateAndTime());
		return this;
	}

	public ManageNews ClickOnDeleteButton() {
		deleteItem.click();
		driver.switchTo().alert().accept();
		return this;
	}

}
