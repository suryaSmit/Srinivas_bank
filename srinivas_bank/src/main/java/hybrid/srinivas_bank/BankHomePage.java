package hybrid.srinivas_bank;
//page object model

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BankHomePage {
	WebDriver driver;
	
	public BankHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//username
	public WebElement username() {
		 return driver.findElement(By.id("txtuId"));
	}
	
	//password
	public WebElement password() {
		return driver.findElement(By.id("txtPword"));
	}
	
	//login
	public WebElement loginButton() {
		return driver.findElement(By.id("login"));
	}
	
	//clear user name
	public void clearUsername() {
		this.username().clear();
	}
	
	//clear password
	public void clearPassword() {
		this.password().clear();
	}
	
	//fill username
	public void fillUsername(String username) {
		this.username().sendKeys(username);
	}
	
	//fill password
	public void fillPassword(String password) {
		this.password().sendKeys(password);
	}
	
	//click login button
	public void clickLoginButton() {
		this.loginButton().click();
	}

}
