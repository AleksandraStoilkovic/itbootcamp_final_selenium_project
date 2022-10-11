package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
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
	@Test(priority = 3)
	public void createNewCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForDialogForEditAndCreateBeVisible();
		citiesPage.getNameInput().sendKeys("Aleksandra Stoilkovic’s city");
		citiesPage.getSaveButton().click();
		messagePopUpPage.waitForPopUpCreateBeVisible();
		softAssert.assertTrue(messagePopUpPage.getElementsThatContainTextWhenWeSaveNewCity().getText().contains("Saved successfully"), 
				"Message Pop Up should contain text Saved sucessfully");
	}
	@Test(priority = 4)
	public void editCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForDialogForEditAndCreateBeVisible();
		citiesPage.getNameInput().sendKeys("Aleksandra Stoilkovic’s city");
		citiesPage.getSaveButton().click();
		citiesPage.waitForSpecificNumberOfRowsToBeVisible(1);
		citiesPage.getEditButtonFromRow(1).click();
		Actions a = new Actions(driver);
		a.keyDown(Keys.CONTROL);
		a.keyDown("A");
		a.keyDown(Keys.DELETE);
		a.keyUp(Keys.CONTROL);
		a.keyUp("A");
		a.keyUp(Keys.DELETE);
		citiesPage.getNameInput().sendKeys("Aleksandra Stoilkovic’s city Edited");
		citiesPage.getSaveButton().click();
		messagePopUpPage.waitForPopUpCreateBeVisible();
		softAssert.assertTrue(messagePopUpPage.getElementsThatContainTextWhenWeSaveNewCity().getText().contains("Saved successfully"), 
				"Message Pop Up should contain text Saved sucessfully");
	}
	@Test(priority = 5)
	public void deleteCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Aleksandra Stoilkovic’s city Edited");
		citiesPage.waitForSpecificNumberOfRowsToBeVisible(1);
		softAssert.assertEquals(citiesPage.getCell(1, 2).getText(),
				"Aleksandra Stoilkovic’s city Edited",
				"Name column is not the same like search input");
		citiesPage.getDeleteFromRow(1).click();
		citiesPage.waitForDialogForDeleteBeVisible();
		citiesPage.getDeleteButton().click();
		messagePopUpPage.waitForPopUpCreateBeVisible();
		softAssert.assertTrue(messagePopUpPage.getElementsThatContainTextWhenWeSaveNewCity().getText().contains("Deleted successfully"), 
				"Message Pop Up should contain text Deleted successfully");
	}
}
