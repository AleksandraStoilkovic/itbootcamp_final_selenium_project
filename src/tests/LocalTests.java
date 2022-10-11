package tests;

import org.testng.annotations.Test;

public class LocalTests extends BasicTest{
	@Test(priority = 1)
	public void setLocaleToES() {
		navPage.getLanguageButton().click();
		navPage.getESButton().click();
		softAssert.assertEquals(navPage.getHeaderText().getText(), "Página de aterrizaje", "Language is not set to ES");
		softAssert.assertAll();
	}
	@Test(priority = 2)
	public void setLocaleToEN() {
		navPage.getLanguageButton().click();
		navPage.getENButton().click();
		softAssert.assertEquals(navPage.getHeaderText().getText(), "Landing", "Language is not set to EN");
		softAssert.assertAll();
}
}