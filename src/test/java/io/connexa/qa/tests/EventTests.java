/*author @andres*/

package io.connexa.qa.tests;

import io.connexa.qa.general.Fecha;
import io.connexa.qa.general.Init;
import io.connexa.qa.general.Search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Random;

public class EventTests {

	static final String TENANT = Init.TENANT_DOMAIN_CONNEXA;
	private WebDriver driver;

	@Before
	public void setUp() {
		
		driver = (WebDriver) Init.setDriver("c", TENANT, driver);
		Init.setCredentials(driver);
	}
	
	
	//@Test
	/* ******************Check All Required Fields Validations in Create Event******************************************************/
	public void emptyFieldsValidation() {
		
		WebElement labelEventName = null ,labelShortDescription = null, labelStartDate = null, labelEndDate = null ,labelStartHour = null ,labelEndHour = null;
		WebElement eventSaveButton;
		
		driver.navigate().to(TENANT + "/#events/new");
		
		// Wait for the Existence of Element Name (Event Name)
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
		
		eventSaveButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/form/div[13]/button[2]"));
		eventSaveButton.click();
					 
		//Verify Existence Validation Messages (Requires a Wait after Submit with at least one Label)
		boolean isValidation = (new WebDriverWait(driver, 10))
				 .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/form/div[3]/p"),"can't be blank"));
				
		if (isValidation) {
		    labelEventName = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/form/div[2]/p"));
			labelShortDescription = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/form/div[3]/p"));
			labelStartDate = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/form/div[6]/div[1]/p"));
			labelEndDate = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/form/div[7]/div[1]/p"));
			labelStartHour = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/form/div[6]/div[2]/p"));
			labelEndHour = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/form/div[7]/div[2]/p"));

		}
		
		 assertEquals(labelEventName.getText(),"can't be blank");
		 assertEquals(labelShortDescription.getText(),"can't be blank");
		 assertEquals(labelStartDate.getText(),"can't be blank"); 
		 assertEquals(labelEndDate.getText(),"can't be blank");
		 assertEquals(labelStartHour.getText(),"can't be blank");
		 assertEquals(labelEndHour.getText(),"can't be blank");		
		 
				
	}
 
	@Test
	/**** Event Creation **********/
	public void createEvent(){
		
		WebElement eventName, eventShortDescription, eventStartDate, eventEndDate, eventStartHour, eventEndHour,
		eventSaveButton;
		
		driver.navigate().to(TENANT + "/#events/new");
		
		// Wait for the Existence of Element Name (Event Name)
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
		
		/* Fill the Fields */
		Random rnd = new Random();
     	int randomNumber = Math.abs(rnd.nextInt());
		eventName = driver.findElement(By.name("name"));
		eventName.clear();
		eventName.sendKeys( randomNumber + " Automated Event");
		
		eventShortDescription = driver.findElement(By.name("short_description"));
		eventShortDescription.clear();
		eventShortDescription.sendKeys("Short Description for "+randomNumber + " Automated Event");
		
		((JavascriptExecutor)driver).executeScript ("document.getElementById('start_date').removeAttribute('readonly',0);");
		eventStartDate = driver.findElement(By.name("start_date"));
		eventStartDate.clear();
		eventStartDate.sendKeys(Fecha.getStartDate());
		
		((JavascriptExecutor)driver).executeScript ("document.getElementById('start_hour').removeAttribute('readonly',0);");
		eventStartHour = driver.findElement(By.name("start_hour"));
		eventStartHour.clear();
		eventStartHour.sendKeys(Fecha.getStartHour());
		
		((JavascriptExecutor)driver).executeScript ("document.getElementById('end_date').removeAttribute('readonly',0);");
		eventEndDate = driver.findElement(By.name("end_date"));
		eventEndDate.clear();
		eventEndDate.sendKeys(Fecha.getEndDate());
		
		((JavascriptExecutor)driver).executeScript ("document.getElementById('end_hour').removeAttribute('readonly',0);");
		eventEndHour = driver.findElement(By.name("end_hour"));
		eventEndHour.clear();
		eventEndHour.sendKeys(Fecha.getEndHour());
		
		eventSaveButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/form/div[13]/button[2]"));
		eventSaveButton.click();
		
		//Wait to redirect to Discover Events
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.urlToBe(TENANT + "/#events/discover"));
		
		// Search the Event Created
		Search.doGlobalSearch(randomNumber + " Automated Event", driver);
		
		//Wait for the results
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("name")));
		
		//Search the event in List
		String link = (String) ((JavascriptExecutor)driver)
								.executeScript ("var links = document.getElementsByTagName('a');"
										+ "for(i = 0;i < links.length; i++)"
										+ "{if (links[i].innerHTML =" +"'"+ randomNumber + " Automated Event')"
										+ " return links[i].innerHTML     ;}");

		//Do the equality;
		assertEquals(randomNumber + " Automated Event",link);

		System.out.println(randomNumber + " Automated Event");
				
	}
	
	@After
	public void tearDown() throws Exception {
		// Close the browser
		driver.quit();
	}
	
	
	
}
