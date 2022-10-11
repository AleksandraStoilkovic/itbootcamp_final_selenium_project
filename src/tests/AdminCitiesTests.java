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
	
	@Test(priority = 2)
	public void checksInputTypesForCreateOrEditNewCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForDialogForEditAndCreateBeVisible();
		softAssert.assertEquals(citiesPage.getNameInput().getAttribute("type"), "text", "Type of name field should be text");
		softAssert.assertAll();
	}
}
