package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategory;
import pages.Subcategory;

public class ManageCategoryTest extends BaseClass {
	LoginPage login;
	HomePage home;
	ManageCategory managecategory;

	@Test
	public void verifyAddNewCategoryInManageCategory() throws IOException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		managecategory = home.clickOnManageCategory().clickOnNewButton().enterCategoryName().selectGroup()
				.chooseImage().clickOnRadioButtonForTopMenu().clickOnRadioButtonForBottomMenu().clickOnSaveButton();
		boolean isAlertPresent = managecategory.isAlertDisplayed();
		Assert.assertTrue(isAlertPresent, Constant.mc_verifUseraddNewCategory);
	}

	@Test
	public void verifyUserIsableToDeleteAnItem() throws IOException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		managecategory = home.clickOnManageCategory().ClickOndeleteItem();
		boolean isAlertPresent = managecategory.isAlertDisplayed();
		Assert.assertTrue(isAlertPresent, Constant.mc_DeleteAnItem);
	}
}