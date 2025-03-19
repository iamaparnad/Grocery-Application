package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class Subcategory {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	FileUploadUtility fileuplaod = new FileUploadUtility();
WaitUtility waitutility=new WaitUtility();
	public Subcategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement categoryDropDown;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subcategoryTextBox;
	@FindBy(xpath="//input[@id='main_img']")
	WebElement chooseFile;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMsg;
	@FindBy(xpath = "//i[@class='fas fa-trash-alt']")
	WebElement deleteItem;
	@FindBy(xpath = "//span[@class='badge bg-success']")
	WebElement statusButton;

	public Subcategory clickOnNewButton() {
		newButton.click();
		return this;// chaining of pages
	}

	public Subcategory selectCategoryFromDropdown() {
		pageutility.selectDropdownwithVisibleText(categoryDropDown, "veggies");
		return this;
//		Select select=new Select(categoryDropDown);
//		select.selectByVisibleText("veggies");
//		WebElement selectedElement=select.getFirstSelectedOption();
//		selectedElement.click();
	}

	public Subcategory enterSubCategory() {
		subcategoryTextBox.sendKeys("Leafy vegetables" + pageutility.generateCurrentDateAndTime());
		return this;
	}

	public Subcategory uploadImage() {
		//waitutility.elementToBeClickable(driver, chooseFile);
		String filepath = "C:\\Users\\User\\eclipse-workspace\\GroceryApplication\\src\\test\\resources\\Images\\leafy-veg.jpg";
		//fileuplaod.uploadFileUsingSendkeys(chooseFile, filepath);
		chooseFile.sendKeys(filepath);
		return this;
	}

	public Subcategory clickOnSaveButton() {
		saveButton.click();
		return this;
	}

	public void clickOnDeleteButton() {
		deleteItem.click();
		driver.switchTo().alert().accept();
	}

	public void clickOnStatusButton() {
		statusButton.click();
	}

	public boolean isAlertDisplayed() {
		return alertMsg.isDisplayed();
	}

}
