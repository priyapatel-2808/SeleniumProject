package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

public class CartPage {
	
	WebDriver driver;
	
	By cartTitleBy = By.className("title");
	By removeBtnBy = By.id("remove-sauce-labs-backpack");
	By continueShopingBy=By.id("continue-shopping");
	
	public  CartPage(WebDriver webDriver) {
		this.driver = webDriver;
	}
	
	public void verifyCartPage() {
		WebElement textElm = driver.findElement(cartTitleBy);
		Assert.assertEquals(textElm.isDisplayed(), true);
		Reporter.log("Cart Page Loaded succesfully");
	}
	
	public void clickRemoveBtn() {
		WebElement btnElm= driver.findElement(removeBtnBy);
		btnElm.click();
	}
	
	public void clickContinueShoppingBtn() {
		WebElement continueBtnElm= driver.findElement(continueShopingBy);
		continueBtnElm.click();
	}

}
