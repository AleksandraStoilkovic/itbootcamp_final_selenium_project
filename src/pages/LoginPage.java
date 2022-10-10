package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
	private WebDriverWait wait;

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}
	public WebElement getEmailField() {
		return driver.findElement(By.id("email"));
	}
	public WebElement getPasswordField() {
		return driver.findElement(By.name("password"));
	}
	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//span[text()='Login']"));
	}
	public void waitForHomePageToBeVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("/home"));
	}

}
