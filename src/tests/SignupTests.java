package tests;

import org.testng.annotations.Test;

public class SignupTests extends BasicTest{
	@Test(priority = 1)
	public void visitsTheSignupPage() {
		navPage.getSignUpButton().click();
		softAssert.assertEquals(driver.getCurrentUrl(), baseUrl + "/signup", "You are not on signup page");
		softAssert.assertAll();
	}
}
