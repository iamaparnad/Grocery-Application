package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageCategory {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public ManageCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")
	WebElement newButton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement categoryTextBox;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement selectGroupBox;
	@FindBy(xpath = "//input[@type='file']")
	WebElement image;
	@FindBy(xpath = "//input[@type='radio' and @name='top_menu' and@value='yes']")
	WebElement radioButtonTopMenu;
	@FindBy(xpath = "//input[@type='radio' and @name='show_home' and@value='yes']")
	WebElement radioButtonLeftMenu;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath = "//i[@class='fas fa-trash-alt']")
	WebElement deleteItem;
	@FindBy(xpath = "//span[@class='badge bg-success']")
	WebElement statusButton;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-sync-alt']")
	WebElement resetButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMsg;

	public ManageCategory clickOnNewButton() {
		newButton.click();

		saveButton.click();
		return this;
	}

	public ManageCategory enterCategoryName() {
		categoryTextBox.sendKeys("Stationaries " + pageutility.generateCurrentDateAndTime());
		return this;
	}

	public ManageCategory selectGroup() {
		selectGroupBox.click();
		return this;
	}

	public ManageCategory chooseImage() {
		image.click();
		return this;
	}

	public ManageCategory clickOnRadioButtonForTopMenu() {

		if (!radioButtonTopMenu.isSelected())
			;
		{
			{
				radioButtonTopMenu.click();
			}

		}
		return this;
	}

	public ManageCategory clickOnRadioButtonForBottomMenu() {

		if (radioButtonLeftMenu.isSelected())
			;
		{
			radioButtonLeftMenu.click();
		}
		return this;
	}

	public ManageCategory clickOnSaveButton() {
		saveButton.click();
		return this;
	}
	public boolean isAlertDisplayed() 
	{
		return alertMsg.isDisplayed();
	}

	public ManageCategory ClickOndeleteItem() {
		deleteItem.click();
		driver.switchTo().alert().accept();
		return this;
	}

	public ManageCategory clickOnStatusButton() {
		statusButton.click();
		return this;
	}

	public void clickOnResetButton() {
		resetButton.click();
	}
}
