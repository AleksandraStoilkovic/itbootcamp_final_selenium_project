package tests;

import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {
	@Test(priority = 1)
	public void visitsTheAdminCitiesPageAndListCities() {
		navPage.getLogInButton().click();
		loginPage.getEmailField().sendKeys("admin@admin.com");
		loginPage.getPasswordField().sendKeys("12345");
		loginPage.getLoginButton().click();
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		softAssert.assertEquals(driver.getCurrentUrl(), baseUrl + "/admin/cities", "You are not on cities page");
		softAssert.assertAll();
	}
}
