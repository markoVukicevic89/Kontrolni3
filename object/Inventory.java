package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Inventory {
	public static final String URL = "https://www.saucedemo.com/inventory.html";
	private static final String SORT_XPATH = "//*[@id=\"inventory_filter_container\"]/select/option[4]";
	
	public static void sortPage(WebDriver driver) {
		driver.findElement(By.xpath(SORT_XPATH)).click();
	}
	
	
	
}
