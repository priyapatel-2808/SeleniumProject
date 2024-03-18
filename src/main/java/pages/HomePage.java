package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class HomePage {
	
	WebDriver driver;
	By homePageTitle = By.xpath("//div[text()='Swag Labs']");
	By addToCartBy= By.id("add-to-cart-sauce-labs-backpack");
	By productFilterBy = By.className("product_sort_container");
	By productTitleBy=By.id("item_4_title_link");
	By cartBtnBy=By.className("shopping_cart_link");
	
	
	
	public HomePage(WebDriver webDriver) {
	 this.driver=webDriver;
	}
	
	
	public void verifyHomePageLoaded() {
		WebElement elm = driver.findElement(homePageTitle);
		Assert.assertEquals(elm.isDisplayed(), true);
		Reporter.log("Verified Loading of home page successfully");
	}
	
	public void addToCart() {
		WebElement clickElm=driver.findElement(addToCartBy);
		clickElm.click();
	}
	
	public void filterProduct(String value) {
		Select se = new  Select(driver.findElement(productFilterBy));
		se.selectByVisibleText(value);
		Reporter.log("Filter product by:"+value);
	}
	
	public void addItemTitle() {
		WebElement itemElm = driver.findElement(productTitleBy);
		itemElm.click();
	}
	
	public void addToCartPage() {
		WebElement cartElm=driver.findElement(cartBtnBy);
		cartElm.click();
	}

}
