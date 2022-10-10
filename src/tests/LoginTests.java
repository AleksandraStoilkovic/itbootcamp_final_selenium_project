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
}
