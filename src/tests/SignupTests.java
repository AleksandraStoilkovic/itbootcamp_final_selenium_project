package tests;

import org.testng.annotations.Test;

public class SignupTests extends BasicTest{
	@Test(priority = 1)
	public void visitsTheSignupPage() {
		navPage.getSignUpButton().click();
		softAssert.assertEquals(driver.getCurrentUrl(), baseUrl + "/signup", "You are not on signup page");
		softAssert.assertAll();
	}
	@Test(priority = 2)
	public void checksInputTypes() {
		navPage.getSignUpButton().click();
		softAssert.assertEquals(signupPage.getEmailField().getAttribute("type"), 
				"email", 
				"Type of name field should be text");
		softAssert.assertEquals(signupPage.getPasswordField().getAttribute("type"), 
				"password", 
				"Type of password field should be password");
		softAssert.assertEquals(signupPage.getConfirmPasswordField().getAttribute("type"), 
				"password", 
				"Type of confirm password field should be password");
		softAssert.assertAll();
	}
	@Test(priority = 3)
	public void displaysErrorsWhenUserAlreadyExists() {
		navPage.getSignUpButton().click();
		softAssert.assertEquals(driver.getCurrentUrl(), baseUrl + "/signup", "You are not on signup page");
		signupPage.getNameField().sendKeys("Another User");
		signupPage.getEmailField().sendKeys("admin@admin.com");
		signupPage.getPasswordField().sendKeys("12345");
		signupPage.getConfirmPasswordField().sendKeys("12345");
		signupPage.getSignMeUpButton().click();
		messagePopUpPage.waitVerifyYourAccountDialogToBeVisible();
		softAssert.assertTrue(messagePopUpPage.getVerifyYourAccountText().getText().contains("E-mail already exists"), 
				"The dialog is not dispayed");
		softAssert.assertEquals(driver.getCurrentUrl(), baseUrl + "/signup", "You are not on signup page");
		softAssert.assertAll();
	}
	@Test(priority = 4)
	public void signup() {
		navPage.getSignUpButton().click();
		signupPage.getNameField().sendKeys("Aleksandra Stoilkovic");
		signupPage.getEmailField().sendKeys("aleksandra.stoilkovic@itbootcamp.rs");
		signupPage.getPasswordField().sendKeys("12345");
		signupPage.getConfirmPasswordField().sendKeys("12345");
		signupPage.getSignMeUpButton().click();
		driver.get(baseUrl + "/home");
		softAssert.assertTrue(messagePopUpPage.getVerifyYourAccountText().getText().contains("IMPORTANT: Verify your account"), 
				"The dialog is not dispayed");
		softAssert.assertAll();
		messagePopUpPage.getCloseButton().click();
		navPage.getLogOutButton().click();
	}
}
