package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNews;

public class ManageNewsTest extends BaseClass {
	LoginPage login;
	HomePage home;
	ManageNews managenews;
	@Test
	public void verifyUserIsAbleToAddNewNews() throws IOException {
		login = new LoginPage(driver);
		home=login.loginUsingExcelData();
        managenews=home.clickOnManageNewsButton().clickOnNewButton();
        boolean isAlertPresent = managenews.isAlertDisplayed();
		Assert.assertTrue(isAlertPresent, Constant.mn_verifUserAddNews);

	}

	@Test
	public void VerifyUserIsAbleToSearchNoNExcistingNews() throws IOException {
		login = new LoginPage(driver);
		home=login.loginUsingExcelData();
        managenews=home.clickOnManageNewsButton().searchExistingNews().clickOnsearchButton();
		boolean isAlertPresent = managenews.isAlertDisplayed();
		Assert.assertTrue(isAlertPresent, Constant.mn_verifUserSearchingExsistingNews);
	}
	@Test
	public void verifyUserIsAbleToEditNews() throws IOException
	{
		login = new LoginPage(driver);
		home=login.loginUsingExcelData();
        managenews=home.clickOnManageNewsButton().clickOnEditButton(); 
		boolean isAlertPresent = managenews.isAlertDisplayed();
		Assert.assertTrue(isAlertPresent, Constant.mn_verifUserEditingNews);
	}
}