package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.Subcategory;

public class SubcategoryTest extends BaseClass {
	LoginPage login;
	HomePage home;
	Subcategory subcategory;

	@Test
	public void verifyAddNewSubcategoryWithValidDetails() throws IOException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		subcategory = home.clickOnSubcategoryButton().clickOnNewButton().selectCategoryFromDropdown().enterSubCategory().uploadImage()
				.clickOnSaveButton();

//	  subcategory.clickOnNewButton();
//	  subcategory.selectCategoryFromDropdown();
//	  subcategory.enterSubCategory();
//	  subcategory.clickOnSaveButton();
//	 
		boolean isAlertPresent = subcategory.isAlertDisplayed();
		Assert.assertTrue(isAlertPresent, Constant.sc_verifyAddNewSubcategoryWithValidDetails);
	}
	@Test
	public void verifyUserIsAbleToEditItem()
	{
		Subcategory subcategory = new Subcategory(driver);
		subcategory.clickOnEditButton();
		boolean isAlertPresent = subcategory.isAlertDisplayed();
		Assert.assertTrue(isAlertPresent, Constant.sc_verifyUserIsAbleToEditItem);
	}

	@Test
	public void VerifyUserIsAbleToDeleteItem() {
		Subcategory subcategory = new Subcategory(driver);
		subcategory.clickOnDeleteButton();
		boolean isAlertPresent = subcategory.isAlertDisplayed();
		Assert.assertTrue(isAlertPresent, Constant.sc_verifyUserIsAbleToDeleteItem);
	}
	

	
}
