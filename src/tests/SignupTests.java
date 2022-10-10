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
		softAssert.assertEquals(signupPage.getNameField().getAttribute("type"), 
				"text", 
				"Type of name field shoul be text");
		softAssert.assertEquals(signupPage.getPasswordField().getAttribute("type"), 
				"password", 
				"Type of password field should be password");
		softAssert.assertEquals(signupPage.getConfirmPasswordField().getAttribute("type"), 
				"password", 
				"Type of confirm password field should be password");
		softAssert.assertAll();
	}
}
