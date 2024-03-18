package tests;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.Login;
import utils.GetUserDetailsUtility;
import utils.PropertyReadWrite;

public class CartTest extends BaseTest {
	
	private void login(String url,String userName,String password) throws IOException {
		Login loginpage=new Login(BaseTest.driver);		
		openURL(url);		
		loginpage.enterUsername(userName);
		loginpage.enterPassword(password);
		loginpage.loginSubmit();	
		loginpage.verifyHomepageLoded();
	}
	
	private void home() throws InterruptedException {
		HomePage homePage=new HomePage(BaseTest.driver);
		homePage.addToCart();	
		Thread.sleep(3000);
		homePage.addToCartPage();
	}
	
	@Parameters({"url"})
	@Test
	public void removeItem(String url) throws IOException, InterruptedException {
		String userName=GetUserDetailsUtility.getUserName("username1");
		String password=GetUserDetailsUtility.getPassword("password1");
		login(url,userName,password);
		home();
		Thread.sleep(5000);
		CartPage cartPage =new CartPage(BaseTest.driver);
		cartPage.clickRemoveBtn();
		Thread.sleep(5000);
	}
	
	@Parameters({"url"})
	@Test
	public void removeItemForAnotherUser(String url) throws IOException, InterruptedException {
		String userName=GetUserDetailsUtility.getUserName("username3");
		String password=GetUserDetailsUtility.getPassword("password3");
		login(url,userName,password);
		home();
		Thread.sleep(5000);
		CartPage cartPage =new CartPage(BaseTest.driver);
		cartPage.clickRemoveBtn();
		Thread.sleep(5000);
	}
	
	@Parameters({"url"})
	//@Test
	public void ContinueShoppingBtn(String url) throws IOException, InterruptedException {
		String userName=GetUserDetailsUtility.getUserName("username1");
		String password=GetUserDetailsUtility.getPassword("password1");
		login(url,userName,password);
		home();
		Thread.sleep(3000);
		CartPage cartPage =new CartPage(BaseTest.driver);
		cartPage.clickContinueShoppingBtn();
		Thread.sleep(5000);
	}
	
	

}
