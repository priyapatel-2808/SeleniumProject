package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import base.BaseTest;

public class InventoryItemPage extends BaseTest {

	WebDriver driver;
	By btnAddtoCartBy = By.id("add-to-cart-sauce-labs-backpack");
	By btnBackBy=By.xpath("//button[@name=\"back-to-products\"]");
	
	
	public InventoryItemPage(WebDriver webDriver) {
		this.driver=webDriver;
	}
	
	public void verifyInventoryPage() {
		WebElement findTitle = driver.findElement(btnBackBy);
		Assert.assertEquals(findTitle.isDisplayed(), true);
		Reporter.log("Inventory page loadded");
	}
	public void clickAddToCartBtn() {
		WebElement btnElm = driver.findElement(btnAddtoCartBy);
		btnElm.click();
	}
	
	public void backToHomePageBtn() {
		WebElement backBtnElm = driver.findElement(btnBackBy);
		backBtnElm.click();
	}
	
	
}
