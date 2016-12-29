package io.connexa.qa.tests;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.connexa.qa.Init;

public class GlobalSearch {

	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		driver = (WebDriver) Init.setDriver("f", Init.TENANT_DOMAIN_CONNEXA, driver);
		Init.setCredentials(driver);
	}

	@Test
	/* *****************Do Global Search****************************************************/
	public void doGlobalSearch() {
			
		WebElement globalSearch = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("term")));
		
		globalSearch.clear();
		globalSearch.sendKeys("579094772 Automated Event");	
		globalSearch.submit();
		
		
	}

	@After
	public void tearDown() throws Exception {
		// Close the browser
		driver.quit();
	}
	
	
}
