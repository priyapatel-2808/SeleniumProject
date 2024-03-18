package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	    public static WebDriver driver;

		@BeforeSuite
		public void browserSetup() {
			WebDriverManager.chromedriver().setup();
			
		}
		
		@BeforeMethod
		public void driverInstanceSetup() {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		public void openURL(String url) {
			driver.get(url);
		}
		
		@AfterMethod
		public void closeBrowser() {
			driver.close();
			Reporter.log("close chrome driver instance");
		}
		
		@AfterSuite
		public void quiteTest() {
			driver.quit();
			Reporter.log("Quitted the chrome driver instance");
		}

}
