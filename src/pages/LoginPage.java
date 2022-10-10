package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver driver;
	

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
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

}
