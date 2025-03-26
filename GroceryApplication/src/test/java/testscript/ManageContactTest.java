package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContact;
import pages.ManageNews;
import pages.Subcategory;

public class ManageContactTest extends BaseClass {
	LoginPage login;
	HomePage home;
	ManageContact managecontact;

	@Test
	public void AddindValidDetailsInContactUsPage() throws IOException {
		login = new LoginPage(driver);
		home = login.loginUsingExcelData();
		managecontact = home.clickOnManagecontactButton().clickOnNewButton().enterPhoneNumber().enterEmail()
				.enterAddress().enterDeliveryLimit().enterDeliveryLimit().clickOnUpdateButton();
		boolean isAlertPresent = managecontact.isAlertDisplayed();
		Assert.assertTrue(isAlertPresent, Constant.mc_AddindValidDetailsInContactUsPage);

	}

}
