package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InvalidLogin {
	public static final String URL = "https://www.saucedemo.com/";
	private static final String USERNAME_INPUT = "//*[@id=\"user-name\"]";
	private static final String PASS_INPUT = "//*[@id=\"password\"]";
	private static final String BTN_XPATH = "//*[@id=\"login-button\"]";
	
	public static void inputUsername(WebDriver driver, String username) {
		driver.findElement(By.xpath(USERNAME_INPUT)).sendKeys("marko123");
	}
	public static void inputPass(WebDriver driver, String password) {
		driver.findElement(By.xpath(PASS_INPUT)).sendKeys("test123");
	}
	public static void pressLogin(WebDriver driver) {
		driver.findElement(By.xpath(BTN_XPATH)).click();
	}
}
