package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constants.FileConstants;
import file.utils.PropertiesFileutils;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.UserMenuPage;

public class LoginTest extends BaseTest {

	
	@Test(invocationCount = 1 )
	public void loginTest() throws IOException, InterruptedException {
		WebDriver driver =  BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		Assert.assertTrue(lp.launchApp(driver, "https://login.salesforce.com"), "Actual URL should match the expected URL");
		lp.enterUsername(driver, PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username"));
//		Assert.assertEquals(lp.getUsername(driver), PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username"));
		lp.enterPassword(driver, PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.password"));
		Assert.assertTrue(lp.selectRememberMeCheckbox(), "Remember me checkbox should be selected");
		lp.clickLoginButton(driver);
		Assert.assertTrue(lp.isHomePageDisplayed(), "Home page should be displayed");
		Assert.assertTrue(ump.logOut(driver), "Failed to logout");
		Assert.assertTrue(lp.isLoginPageDisplayed(driver), "Login page should be displayed");
		Assert.assertEquals(lp.getSavedUserName(driver), PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username"));
	}
	

//	@Test
	public void loginTest1() {
		WebDriver driver =  BaseTest.getDriver();
		driver.get("https://google.com");
	}
	
	

}
