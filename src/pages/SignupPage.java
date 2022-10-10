package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage {
	private WebDriver driver;

	public SignupPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getNameField() {
		return driver.findElement(By.name("name"));
	}

	public WebElement getEmailField() {
		return driver.findElement(By.name("email"));
	}

	public WebElement getPasswordField() {
		return driver.findElement(By.name("password"));
	}

	public WebElement getConfirmPasswordField() {
		return driver.findElement(By.name("confirmPassword"));
	}

	public WebElement getSignMeUpButton() {
		return driver.findElement(By.xpath("//*[text()='Sign me up']"));
	}
}
