/*author @andres*/

package io.connexa.qa.tests;

import io.connexa.qa.general.Fecha;
import io.connexa.qa.general.Init;
import io.connexa.qa.general.Search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Random;

import io.connexa.tests.pageobjects.CreateEventPage;
import io.connexa.tests.pageobjects.HomePage;

public class EventsTest {

	static final String TENANT = Init.TENANT_DOMAIN_CONNEXA;
	private WebDriver driver;

	@Before
	public void setUp() throws InterruptedException {
		
		driver = (WebDriver) Init.setDriver("c", TENANT, driver);
		
		HomePage homePage =  new HomePage(driver,TENANT);
		homePage.get();
		homePage.signIn("andres@connexa.io", "hp692cie");
	
	}
	
	//@Test
	/* ******************Check All Required Fields Validations in Create Event******************************************************/
	public void emptyFieldsValidation() {
		
		CreateEventPage eventPage = new CreateEventPage(driver, TENANT);
		
		eventPage.get();
		eventPage.saveEvent();
					 
		//Verify Existence Validation Messages (Requires a Wait after Submit with at least one Label)
		boolean isValidation = eventPage.waitValidationMessageLoad();
				
		if (isValidation) {		    
			assertEquals(eventPage.getNameValidation(),"can't be blank");
			assertEquals(eventPage.getShortDescriptionValidation(),"can't be blank");
			assertEquals(eventPage.getStartDateValidation(),"can't be blank"); 
			assertEquals(eventPage.getStarHourValidation(),"can't be blank");
			assertEquals(eventPage.getEndDateValidation(),"can't be blank");
			assertEquals(eventPage.getEndHourValidation(),"can't be blank");	

		}
				
	}
 
	
	//@Test
	/**** Event Creation **********/
	public void createEvent(){
		
		/*Create a positive random number for the Event Name*/
		Random rnd = new Random();
     	int randomNumber = Math.abs(rnd.nextInt());
		
		CreateEventPage eventPage = new CreateEventPage(driver, TENANT);
		
		eventPage.get();
			
     	//Remove readonly attribute from dates and hours fields
     	eventPage.removeReadOnlyAttributes();
		
		eventPage.saveEvent(randomNumber + " Automated Event", "Short Description for "+randomNumber + " Automated Event", Fecha.getStartDate(), Fecha.getStartHour(),
				Fecha.getEndDate(),Fecha.getEndHour());
		
		
		/*FROM HERE IT MUST BE REFACTORED TO COMPLIANT A NESTED PAGE OBJECTS INSTANCES with a Discover Events Factory Page*/
		
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
		driver.close();
	}
	
	
	
}
