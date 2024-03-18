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

public class HomeTest extends BaseTest {
	
	

	@Parameters({ "url" })
	// @Test
	public void addToCart(String url) throws IOException, InterruptedException {
		Login loginpage = new Login(BaseTest.driver);
		openURL(url);
		HomePage homePage = new HomePage(BaseTest.driver);
		String userName = GetUserDetailsUtility.getUserName("username1");
		String password = GetUserDetailsUtility.getPassword("password1");
		loginpage.enterUsername(userName);
		loginpage.enterPassword(password);
		loginpage.loginSubmit();
		loginpage.verifyHomepageLoded();
		homePage.addToCart();
		homePage.filterProduct("Price (low to high)");
		Thread.sleep(5000);
	}

}
