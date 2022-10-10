package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}
	public void waitForPopUpCreateBeVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-snack__content")));
	}
	public WebElement getElementsThatContainText(){
		return driver.findElement(By.xpath("//*[contains(@class, 'v-snack__content')]/ul/li"));
	}
	public WebElement getCancelButton(){
		return driver.findElement(By.xpath("//*[contains(@class, 'v-snack__content')]/button"));
	}
	public void waitVerifyYourAccountDialogToBeVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Close']")));
	}
	public WebElement getVerifyYourAccountText() {
		return driver.findElement(By.xpath("//*[contains(@class, 'v-snack__content')]/ul/li"));
	}
	public WebElement getCloseButton(){
		return driver.findElement(By.xpath("//*[text()='Close']"));
	}
}
