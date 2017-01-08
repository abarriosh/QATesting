package io.connexa.qa.tests;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.WebDriver;

import io.connexa.qa.general.Fecha;
import io.connexa.qa.general.Init;
import io.connexa.tests.pageobjects.AboutEventPage;
import io.connexa.tests.pageobjects.CreateEventPage;
import io.connexa.tests.pageobjects.HomePage;

public class EventsBDDTest {

	static final String TENANT = Init.TENANT_DOMAIN_CONNEXA;
	protected WebDriver driver;
	private CreateEventPage eventPage;
	int randomNumber;
	String eventName;
	
	@Before
	public void setUp() throws InterruptedException{
		driver = (WebDriver) Init.setDriver("c", TENANT, driver);
		
		HomePage homePage =  new HomePage(driver,TENANT);
		homePage.get();
		homePage.signIn("andres@connexa.io", "hp692cie");
		
		eventPage = new CreateEventPage(driver, TENANT);
		
				
	}
	
	@Given ("the user is on Create New Event Page")
	public void theUserIsOnCreateNewEventPage() throws InterruptedException{
		
		eventPage.get();
		
		//Remove readonly attribute from dates and hours fields
     	eventPage.removeReadOnlyAttributes();
	}
	
	@When("he enters \"([^\"]*)\" as event name")
	public void  entersEventName(String name){
		
		if (name.equals("Automated Event")){
			
			/*Create a positive random number for the Event Name*/
			Random rnd = new Random();
	     	randomNumber = Math.abs(rnd.nextInt());

			name = randomNumber + " Automated Event";
		}	
		
		eventName = name;
		eventPage.setName(name);
	}
	
	@And("he enters \"([^\"]*)\" as short description")
	public void  entersShortDescription(String shortDescription){
		
		if (shortDescription.equals("Automated Event Short Description"))
			shortDescription = randomNumber + " Automated Event";
			
		eventPage.setShortDescription(shortDescription);
	}
	
	@And("he enters \"([^\"]*)\" as start date")
	public void  entersStartDate(String startDate){
		
		if (startDate.equals("YYYY/MM/DD"))
			startDate = Fecha.getStartDate();
		
		eventPage.setStartDate(startDate);
	}
	
	@And("he enters \"([^\"]*)\" as start hour")
	public void  entersStartHour(String startHour){
		
		if (startHour.equals("HH:MM"))
			startHour = Fecha.getStartHour();

		eventPage.setStarHour(startHour);
	}
	
	@And("he enters \"([^\"]*)\" as end date")
	public void  entersEndDate(String endDate){
		
		if (endDate.equals("YYYY/MM/DD"))
			endDate = Fecha.getEndDate();
		
		eventPage.setEndDate(endDate); 
	}
	
	@And("he enters \"([^\"]*)\" as end hour")
	public void  entersEndHour(String endHour){
		
		if (endHour.equals("HH:MM"))
			endHour = Fecha.getEndHour();
		
		eventPage.setEndHour(endHour);
	}
	
	@And("he clicks Save Button for Event Creation")
	public void  click(){
		eventPage.saveEvent();
	}
	
	@Then("ensure an error \"([^\"]*)\" message is displayed")
	public void checkValidationMessages(String msg){
		//Verify Existence Validation Messages (Requires a Wait after Submit with at least one Label)
				boolean isValidation = eventPage.waitValidationMessageLoad();
						
				if (isValidation) {		    
					assertEquals(eventPage.getNameValidation(),msg);
					assertEquals(eventPage.getShortDescriptionValidation(),msg);
					assertEquals(eventPage.getStartDateValidation(),msg); 
					assertEquals(eventPage.getStarHourValidation(),msg);
					assertEquals(eventPage.getEndDateValidation(),msg);
					assertEquals(eventPage.getEndHourValidation(),msg);	

				}
				
				
	}
	
	@Then("ensure the event is created")
	public void checkEventCreation(){
		
		AboutEventPage aboutEventPage = new AboutEventPage(driver);
		
		aboutEventPage.get();
		
		assertEquals(eventName,aboutEventPage.getLabelEventName());	

		}
				
			
	@After
	public void tearDown() throws Exception {
		// Close the browser
		driver.quit();
	}

	
	
	
}
