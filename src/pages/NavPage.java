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
		return driver.findElement(By.xpath("//*[contains(@class, 'btnAdminCities')]"));
	}
	
	public WebElement getUsersLink() {
		return driver.findElement(By.xpath("//*[contains(@class, 'btnAdminUsers')]"));
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
		return driver.findElement(By.xpath("//*[contains(@class, 'btnLocaleActivation')]/span"));
	}
	public WebElement getENButton() {
		return driver.findElement(By.xpath("//*[text()='EN']"));
	}
	public WebElement getESButton() {
		return driver.findElement(By.xpath("//*[text()='ES']"));
	}
	public WebElement getFRButton() {
		return driver.findElement(By.xpath("//*[text()='FR']"));
	}
	public WebElement getCNButton() {
		return driver.findElement(By.xpath("//*[text()='CN']"));
	}
	public WebElement getHeaderText() {
		return driver.findElement(By.tagName("h1"));
	}
}
