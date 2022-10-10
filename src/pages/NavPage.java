package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage {
	private WebDriver driver;

	public NavPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getHomeLink() {
		return driver.findElements(By.xpath("//*[contains(@class, 'v-btn--router')]")).get(0);
	}

	public WebElement getAboutLink() {
		return driver.findElements(By.xpath("//*[contains(@class, 'v-btn--router')]")).get(1);
	}

	public WebElement getMyProfileLink() {
		return driver.findElement(By.xpath("//*[contains(@class, 'btnProfile')]"));
	}

	public WebElement getAdminButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'btnAdmin')]"));
	}

	public WebElement getCitiesLink() {
		return driver.findElement(By.id("list-item-346"));
	}

	public WebElement getUsersLink() {
		return driver.findElement(By.id("list-item-349"));
	}

	public WebElement getSignUpButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'v-btn--router')][4]/span"));
	}

	public WebElement getLogInButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'v-btn--router')][3]/span"));
	}

	public WebElement getLogOutButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'btnLogout')]/span"));
	}

	public WebElement getLanguageButton() {
		return driver.findElement(By.xpath("//*[text()=' en ']"));
	}
	public WebElement getENButton() {
		return driver.findElement(By.id("list-item-203"));
	}
	public WebElement getESButton() {
		return driver.findElement(By.id("list-item-205"));
	}
	public WebElement getFRButton() {
		return driver.findElement(By.id("list-item-207"));
	}
	public WebElement getCNButton() {
		return driver.findElement(By.id("list-item-209"));
	}
}
