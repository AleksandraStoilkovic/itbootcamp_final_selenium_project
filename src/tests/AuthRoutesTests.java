package tests;

import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest{
	
	@Test(priority = 1)
	public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/home");
		softAssert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "You are not on login page");
		softAssert.assertAll();
	}
	@Test(priority = 2)
	public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/profile");
		softAssert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "You are not on login page");
		softAssert.assertAll();
	}
	@Test(priority = 3)
	public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/admin/cities");
		softAssert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "You are not on login page");
		softAssert.assertAll();
	}
	@Test(priority = 4)
	public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/admin/users");
		softAssert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "You are not on login page");
		softAssert.assertAll();
	}
}
