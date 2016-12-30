/*author @andres*/

package io.connexa.qa.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.connexa.qa.general.Fecha;
import io.connexa.qa.general.Init;
import io.connexa.qa.general.Search;
import io.connexa.tests.pageobjects.CreateEventPage;
import io.connexa.tests.pageobjects.HomePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;
import static org.junit.Assert.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTML;

public class MobileEventsTests {

	static final String TENANT = Init.TENANT_DOMAIN_CONNEXA;

	
	AppiumDriver<WebElement> driver;

	@Before
	public void setUp() throws MalformedURLException, InterruptedException {
		
		/*CREATE */
		// Set the desired capabilities for Android Device
		  DesiredCapabilities caps = DesiredCapabilities.android();
		  //caps.setCapability("deviceOrientation", "landscape");
		  caps.setCapability("platformVersion", "5.1");
		  caps.setCapability("platformName", "Android");
		  caps.setCapability("deviceName", "LGK33028b24184");
		  caps.setCapability("browserName", "Chrome");
		  caps.setCapability("hasTouchScreen", false);
		  caps.setCapability("automationName","Selendroid");
		  caps.setCapability("autoWebview", true);
				
			
		  // Create an instance of AndroidDriver for testing on Android platform
		  // connect to the local Appium server running on a different machine
		  // We will use WebElement type for testing the Web application
		    driver =  new AndroidDriver <WebElement> (new URL(
												"http://127.0.0.1:4723/wd/hub"), caps);
		
		 		    
		HomePage homePage =  new HomePage(driver,TENANT);
		homePage.get();
		try {
			
			homePage.signInMobile("andres@connexa.io", "hp692cie", driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	
	@Test
	/* ******************Check All Required Fields Validations in Create Event******************************************************/
	public void emptyFieldsValidation() {
		
		
		
		CreateEventPage eventPage = new CreateEventPage(driver, TENANT);
		
		eventPage.get();
		
		eventPage.saveEventMobile(driver);
					 
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
 
	
	@Test
	/**** Event Creation **********/
	public void createEvent(){
		
		/*Create a positive random number for the Event Name*/
		Random rnd = new Random();
     	int randomNumber = Math.abs(rnd.nextInt());
		
		CreateEventPage eventPage = new CreateEventPage(driver, TENANT);
		
		eventPage.get();
			
     	//Remove readonly attribute from dates and hours fields
     	eventPage.removeReadOnlyAttributes();
		
		eventPage.saveEvent(randomNumber + " Mobile Automated Event", "Short Description for "+randomNumber + " Mobile Automated Event", Fecha.getStartDate(), Fecha.getStartHour(),
				Fecha.getEndDate(),Fecha.getEndHour());
		
		
		/*FROM HERE IT MUST BE REFACTORED TO COMPLIANT A NESTED PAGE OBJECTS INSTANCES with a Discover Events Factory Page*/
		
		//Wait to redirect to Discover Events
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.urlToBe(TENANT + "/#events/discover"));
		
		// Search the Event Created
		Search.doGlobalSearch(randomNumber + " Mobile Automated Event", driver);
		
		//Wait for the results
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("name")));
		
		//Search the event in List
		String link = (String) ((JavascriptExecutor)driver)
								.executeScript ("var links = document.getElementsByTagName('a');"
										+ "for(i = 0;i < links.length; i++)"
										+ "{if (links[i].innerHTML =" +"'"+ randomNumber + " Mobile Automated Event')"
										+ " return links[i].innerHTML     ;}");

		//Do the equality;
		assertEquals(randomNumber + " Mobile Automated Event",link);

		System.out.println(randomNumber + " Mobile Automated Event");
				
	}
	
	@After
	public void tearDown() throws Exception {
		// Close the browser
		driver.quit();
	}
	
	
	
}
