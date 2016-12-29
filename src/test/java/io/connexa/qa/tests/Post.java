package io.connexa.qa.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.connexa.qa.Init;

public class Post {

	private WebDriver driver;
	WebElement post, postButton;
	
	@Before
	public void setUp() {
		
		driver = (WebDriver) Init.setDriver("firefox", Init.TENANT_DOMAIN_SWIP, driver);
		Init.setCredentials(driver);
	}
	
	@Test

	/** ******************Create a Post******************************************************/
	public void createPost() {
		
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("body")));
				
		post = driver.findElement(By.id("body"));
		post.clear();
		post.sendKeys("Automated Post using WebDriver API");
		
		postButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div[1]/div/div[1]/form/div[1]/div[3]/div[3]/div[2]/a"));
		postButton.click();
		
		
	   /* VERIFICAR METODO DE ESPERA DE LA CREACION DEL POST Y CRITERIOS DE ACEPTACION  ** ***/
		
		new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase()
						.startsWith("selenium testing tools cookbook");
			}
		});
		
	}

	@After
	public void tearDown() throws Exception {
		// Close the browser
		driver.quit();
	}
	
}
