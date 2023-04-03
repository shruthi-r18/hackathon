package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "Login")
	public WebElement login;

	public void enterUsername(WebDriver driver, String userName) {

		if (username.isDisplayed()) {
			username.sendKeys(userName);
		} else {
			System.out.println("User name element is not visible");
		}
	}

	public void enterPassword(WebDriver driver, String pass) {
		if (password.isDisplayed()) {
			password.sendKeys(pass);
		} else {
			System.out.println("password element is not visible");
		}
	}
	
	public void clickLoginButton(WebDriver driver) {
		if (login.isDisplayed()) {
			login.click();
		} else {
			System.out.println("login button is not visible");
		}
	}

}
