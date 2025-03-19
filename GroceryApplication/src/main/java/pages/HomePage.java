package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[normalize-space()='Sub Category']")
	WebElement subcategoryButton;
	@FindBy(xpath = "//p[text()='Manage Contact']")
	WebElement managecontactButton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	WebElement managenews;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='active nav-link']")
	WebElement managecategoryButton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product' @class='nav-link']")
	WebElement manageProductButton;

	public Subcategory clickOnSubcategoryButton() {
		subcategoryButton.click();
		return new Subcategory(driver);
	}

	public ManageContact clickOnManagecontactButton() {
		managecontactButton.click();
		return new ManageContact(driver);
	}

	public ManageNews clickOnManageNewsButton() {
		managenews.click();
		return new ManageNews(driver);
	}

	public ManageCategory clickOnManageCategory() {
		managecategoryButton.click();
		return new ManageCategory(driver);
	}
}
