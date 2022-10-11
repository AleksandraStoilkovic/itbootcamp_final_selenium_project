package tests;

import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest{
	
	@Test(priority = 1)
	public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/home");
		softAssert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "You are not on login page");
		softAssert.assertAll();
	}
}
