package tests;


import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.Login;
import utils.PropertyReadWrite;

public class LoginTest extends BaseTest {
	
	String dataPath = "C:\\Users\\Priya\\eclipse-workspace\\SeleniumFramework2\\src\\main\\resources\\testdata\\loginData.properties";
	PropertyReadWrite pr = new PropertyReadWrite();
	
	
	@Parameters({"url"})
	@Test(priority = 1)
	void testValidUsernamePassword(String url) throws InterruptedException, IOException {
		Login loginpage=new Login(BaseTest.driver);		
		openURL(url);
		String userName=pr.readProperty(dataPath,"username1");
		String password = pr.readProperty(dataPath, "password1");
		loginpage.enterUsername(userName);
		loginpage.enterPassword(password);
		loginpage.loginSubmit();
		Thread.sleep(3000);
		loginpage.verifyHomepageLoded();
	}
	
	@Parameters({"url"})
	//@Test(priority = 2)
	void testInvalidPassword(String url)throws InterruptedException  {
		Login loginpage = new Login(BaseTest.driver);
		openURL(url);
		loginpage.enterUsername("standard_user");
		loginpage.enterPassword("12345");
		loginpage.loginSubmit();
		Thread.sleep(2000);
		loginpage.verifyErrorMsg();
	}
	
	@Parameters({"url"})
	//@Test(priority = 3)
	void testInvalidUsername(String url) throws InterruptedException {
		Login loginpage = new Login(BaseTest.driver);
		openURL(url);
		loginpage.enterUsername("standard");
		loginpage.enterPassword("secret_sauce");
		loginpage.loginSubmit();
		Thread.sleep(2000);
		loginpage.verifyErrorMsg();
	}

}
