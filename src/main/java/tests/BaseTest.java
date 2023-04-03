package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
		
	
	@BeforeMethod
	public void setDriver() {
		WebDriver driver = BaseTest.getBrowserType("chrome", false);
		threadLocalDriver.set(driver);
	}
	
	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}

	@AfterMethod
	public void removeDriver() {
		BaseTest.getDriver().close();
		threadLocalDriver.remove();
	}

	/**
	 * This method configures the browser dynamically with headless mode.
	 * @param browserName should be either of the string 'chrome', 'firefox', 'edge', 'safari'
	 * @param headless set to true to run in headless mode
	 * @return driver object, on wrong param returns null
	 */
	public static WebDriver getBrowserType(String browserName, boolean headless) {
		
		WebDriver driver = null;
		String browserType = browserName.toLowerCase();
		
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			if(headless) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);
			} else {
				driver = new ChromeDriver();
			}
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Provide input either as Chrome or Safari");
			break;
		}
		return driver;
	}

}
