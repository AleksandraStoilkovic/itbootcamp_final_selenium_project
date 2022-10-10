package tests;

import org.testng.annotations.Test;

public class LoginTests extends BasicTest {
	@Test(priority = 1)
	public void visitsTheLoginPage() {
		navPage.getLanguageButton().click();
		navPage.getENButton().click();
		navPage.getLogInButton().click();
		softAssert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "You are not on log in page");
		softAssert.assertAll();
	}
	@Test(priority = 2)
	public void checksInputTypes() {
		navPage.getLogInButton().click();
		softAssert.assertEquals(loginPage.getEmailField().getAttribute("type"), 
				"email", 
				"Type of email field shoul be email");
		softAssert.assertEquals(loginPage.getPasswordField().getAttribute("type"), 
				"password", 
				"Type of password field shoul be password");
		softAssert.assertAll();
	}
	@Test(priority = 3)
	public void displaysErrorsWhenUserDoesNotExist() {
		navPage.getLogInButton().click();
		loginPage.getEmailField().sendKeys("non-existing-user@gmal.com");
		loginPage.getPasswordField().sendKeys("password123");
		loginPage.getLoginButton().click();
		messagePopUpPage.waitForPopUpCreateBeVisible();
		softAssert.assertTrue(messagePopUpPage.getElementsThatContainText().getText().contains("User does not exists"), 
				"Pop up message is not visible");
		softAssert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "You are not on log in page");
		softAssert.assertAll();
	}
	@Test(priority = 4)
	public void displaysErrorsWhenPasswordIsWrong() {
		navPage.getLogInButton().click();
		loginPage.getEmailField().sendKeys("admin@admin.com");
		loginPage.getPasswordField().sendKeys("password123");
		loginPage.getLoginButton().click();
		messagePopUpPage.waitForPopUpCreateBeVisible();
		softAssert.assertTrue(messagePopUpPage.getElementsThatContainText().getText().contains("Wrong password"), 
				"Pop up message is not visible");
		softAssert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "You are not on log in page");
		softAssert.assertAll();
	}
	@Test(priority = 5)
	public void login() {
		navPage.getLogInButton().click();
		loginPage.getEmailField().sendKeys("admin@admin.com");
		loginPage.getPasswordField().sendKeys("12345");
		loginPage.getLoginButton().click();
		loginPage.waitForHomePageToBeVisible();
		softAssert.assertEquals(driver.getCurrentUrl(), baseUrl + "/home", "You are not on home page");
		softAssert.assertAll();
	}
	@Test(priority = 6)
	public void logout() {
		softAssert.assertTrue(navPage.getLogOutButton().isDisplayed(), "Log out button is visible");
		navPage.getLogOutButton().click();
		
	}
}
