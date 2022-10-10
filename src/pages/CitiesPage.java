package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public CitiesPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getNewItemButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'btnNewItem')]"));
	}

	public WebElement getSearchInput() {
		return driver.findElement(By.id("search"));
	}

	public void waitForDialogForEditAndCreateBeVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'lgNewEditItem')]")));
	}

	public void waitForDialogForDeleteBeVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' Cancel ']")));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.xpath("//*[text()='Save']"));
	}

	public WebElement getDeleteButton() {
		return driver.findElement(By.xpath("//*[text()=' Delete ']"));
	}

	public void waitForSpecificNumberOfRowsToBeVisible(int row) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr['" + row + "']")));
	}
	public WebElement getCell(int row, int column) {
		return driver.findElement(By.xpath("//tbody/tr['" + row + "']/td['" + column + "']"));
	}
	public WebElement getEditButtonFromRow(int row) {
		return driver.findElement(By.xpath("//tbody/tr['" + row + "']/td[1]/div/button[1]"));
	}
	public WebElement getDeleteFromRow(int row) {
		return driver.findElement(By.xpath("//tbody/tr['" + row + "']/td[1]/div/button[2]"));
	}
	
	

}
