package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constants.FileConstants;
import file.utils.PropertiesFileutils;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	
	@Test
	public void loginTest() throws IOException, InterruptedException {
		WebDriver driver =  BaseTest.getDriver();
		driver.get("https://login.salesforce.com");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(driver, PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username"));
		lp.enterPassword(driver, PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.password"));
		
		lp.clickLoginButton(driver);
		Thread.sleep(4000);
	}
	

	@Test
	public void loginTest1() {
		WebDriver driver =  BaseTest.getDriver();
		driver.get("https://google.com");
	}
	
	

}
