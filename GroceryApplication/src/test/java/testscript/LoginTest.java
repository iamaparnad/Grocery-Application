package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.BaseClass;
import constants.Constant;
import pages.LoginPage;

public class LoginTest extends BaseClass {
	@Test
	public void verifyUsingValidCredentials() throws IOException {
		LoginPage login = new LoginPage(driver);// constructor call
		login.loginUsingExcelData();
		boolean ishomepageLoaded = login.ishomePageLoaded();
		Assert.assertTrue(ishomepageLoaded, Constant.lp_verifyLoginWithValidData);
	}

	@Test
	public void verifyUserloginwithValidUsernameandInvalidPassword() {
		LoginPage login = new LoginPage(driver);
		String username = "admin";
		String password = "@#$%^";
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLoginButton();
		boolean isAlertPresent = login.isAlertDisplayed();
		Assert.assertTrue(isAlertPresent, Constant.lp_verifyLoginWithValidUsernameandInvalidPassword);

	}

	@Test
	public void verifyUserloginwithInvalidUsernameandValidPassword() {
		LoginPage login = new LoginPage(driver);
		String username = "qwert";
		String password = "admin";
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLoginButton();
		boolean isAlertPresent = login.isAlertDisplayed();
		Assert.assertTrue(isAlertPresent, Constant.lp_verifyUserloginwithInvalidUsernameandValidPassword);
	}

	@Test(dataProvider = "Dp")
	public void verifUserLoginwithInvalidCredentials(String username, String password) {
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLoginButton();
		boolean isAlertPresent = login.isAlertDisplayed();
		Assert.assertTrue(isAlertPresent, Constant.lp_verifUserLoginwithInvalidCredentials);
	}

	@DataProvider(name = "Dp")
	public Object[][] Dpmethod() {
		return new Object[][] { { "admin", "admin" }, { "admin!@#", "admin123" }, { "!@#$%", "!@#$WER" },
				{ "ASDF", "1q2w3e4r@#$" } };
	}

}
