package io.connexa.qa.general;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search {

	public static void doGlobalSearch(String criteria, WebDriver driver) {
		
		WebElement globalSearch  = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("term")));
		
		globalSearch.clear();
		globalSearch.sendKeys(criteria);		
		globalSearch.submit();
		
	}
	
}
