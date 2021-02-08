package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import object.InvalidLogin;
import object.Inventory;
import object.Login;


public class Testing {
public static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumDriver\\ChromeDriver.exe");
		driver = new ChromeDriver();
	}
	@Test(priority = 1)
	public void invalidTestLogin() {
		driver.navigate().to(InvalidLogin.URL);
		InvalidLogin.inputUsername(driver, "marko123");
		InvalidLogin.inputPass(driver, "test123");
		InvalidLogin.pressLogin(driver);
		
		String actual = driver.getCurrentUrl();
		String expected = "https://www.saucedemo.com/";
		
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority = 2)
	public void testLogin() {
		File fl = new File("data.xlsx"); 
		try {
			InputStream inp = new FileInputStream(fl); 
			XSSFWorkbook wb = new XSSFWorkbook(inp); 
			Sheet sheet = wb.getSheetAt(0);
			
			SoftAssert sa = new SoftAssert();
			
			for(int i = 0; i < 2; i++) {
			
			Row row = sheet.getRow(i); 
			
			Cell c1 = row.getCell(0);
			Cell c2 = row.getCell(1);
		
			
			String username = c1.toString();
			String password = c2.toString();
			
			
			wb.close();
			
			driver.navigate().to(Login.URL);
			Login.inputUsername(driver, username);
			Login.inputPass(driver, password);
			Login.pressLogin(driver);
			
		
		}
			sa.assertAll();
			
		} catch (IOException e) {
			System.out.println("Nije pronadjen fajl!");
			e.printStackTrace();
		}
	}
	@Test(priority = 3)
	public void testSort() {
		driver.navigate().to(Inventory.URL);
		Inventory.sortPage(driver);
		
		String actual = driver.getCurrentUrl();
		String expected = Inventory.URL;
		
		Assert.assertEquals(actual, expected);
	}
	}
