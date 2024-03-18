package tests;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.InventoryItemPage;
import pages.Login;
import utils.GetUserDetailsUtility;
import utils.PropertyReadWrite;

public class InventoryItemTest extends BaseTest {
	
	public void login(String url, String userName,String password) throws InterruptedException {
		Login loginpage = new Login(BaseTest.driver);
		openURL(url);	
		loginpage.enterUsername(userName);
		loginpage.enterPassword(password);
		loginpage.loginSubmit();
		Thread.sleep(3000);
		loginpage.verifyHomepageLoded();
	}
	
	public void home() {
		HomePage homePage = new HomePage(BaseTest.driver);
		homePage.addItemTitle();
	}
	
	@Parameters({ "url" })
	@Test
	public void addToCard(String url) throws InterruptedException, IOException {
		String userName =GetUserDetailsUtility.getUserName("username1");
		String password =GetUserDetailsUtility.getPassword("password1");
		login(url, userName, password);
		home();
		InventoryItemPage inventoryPage = new InventoryItemPage(BaseTest.driver);
		inventoryPage.verifyInventoryPage();
		inventoryPage.clickAddToCartBtn();
		Thread.sleep(2000);

	}

	@Parameters({ "url" })
	@Test
	public void BackToProduct(String url) throws IOException, InterruptedException {
		String userName =GetUserDetailsUtility.getUserName("username1");
		String password =GetUserDetailsUtility.getPassword("password1");
		login(url, userName, password);
		home();
		InventoryItemPage inventoryPage = new InventoryItemPage(BaseTest.driver);
		inventoryPage.verifyInventoryPage();
		Thread.sleep(3000);
		inventoryPage.backToHomePageBtn();
		Thread.sleep(3000);
	}
}
