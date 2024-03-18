package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

public class Login {
	
	WebDriver driver;
	By usernameBy=By.id("user-name");
	By passwordBy=By.id("password");
	By submitBy=By.id("login-button");
	By homePageTitle = By.xpath("//div[@class='app_logo']");
	By errorMsgBy= By.xpath("//div[@class='error-message-container error']/h3[text()='Epic sadface: Username and password do not match any user in this service']");
	
	
	public Login(WebDriver weDriver) {
		this.driver=weDriver;
	}
	
	public void enterUsername(String username) {
		//driver.findElement(usernameBy).sendKeys(username);
		WebElement userNameWebElm = driver.findElement(usernameBy);
		userNameWebElm.sendKeys(username);
		
	}
	
	public void enterPassword(String password) {
		//driver.findElement(passwordBy).sendKeys(password);
		WebElement passwordWebElm = driver.findElement(passwordBy);
		passwordWebElm.sendKeys(password);
	}
	
	public void loginSubmit() {
		//driver.findElement(submitBy).click();
		WebElement submitWebElm=driver.findElement(submitBy);
		submitWebElm.click();
		
	}
	
	public void verifyHomepageLoded() {
		WebElement homepageTitleElement= driver.findElement(homePageTitle);
		Assert.assertEquals(homepageTitleElement.isDisplayed(),true);
		Reporter.log("verified loading of home page successfully");
	}
	
	public void verifyErrorMsg() {
		WebElement errorElement = driver.findElement(errorMsgBy);
		Assert.assertEquals(errorElement.isDisplayed(), true);
		Reporter.log("Error message showing");
		
	}
	


}
