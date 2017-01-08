/*author @andres*/

package io.connexa.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import static org.junit.Assert.*;

public class CreateEventPage extends LoadableComponent<CreateEventPage>{
	
	//Fields
	private WebElement name;
	private WebElement short_description;
	private WebElement start_date;
	private WebElement end_date;
	private WebElement start_hour;
	private WebElement end_hour;
	
	//Labels
	@FindBy(xpath = "/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/form/div[2]/p") 
	@CacheLookup
	private WebElement labelEventName; 
	
	@FindBy(xpath = "/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/form/div[3]/p" )
	@CacheLookup
	private WebElement labelShortDescription; 
	
	@FindBy(xpath = "/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/form/div[6]/div[1]/p")
	@CacheLookup
	private WebElement labelStartDate;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/form/div[7]/div[1]/p")
	@CacheLookup
	private WebElement labelEndDate;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/form/div[6]/div[2]/p" )
	@CacheLookup
	private WebElement labelStartHour;
	
	@FindBy (xpath = "/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/form/div[7]/div[2]/p" )
	@CacheLookup
	private WebElement labelEndHour;
	
	//Buttons
	@FindBy (xpath = "/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/form/div[14]/button[2]")
	private WebElement eventSaveButton;
	
	
	
	
	private WebDriver driver;

	private String url;
		
	/*CLASS CONSTRUCTOR*/
	public CreateEventPage (WebDriver driver, String tenant){
		this.driver = driver;
		this.url = tenant + "/#events/new";
		PageFactory.initElements(driver, this);
			
	}

	
	@Override
	protected void load(){
		
		this.driver.navigate().to(url);
	}
	
	
	@Override
	protected void isLoaded() throws Error {
			assertTrue("Create Event Page not loaded",
				this.isPageLoad());
		}
	
	
	//Getters
	public String getNameValidation(){
		
		return labelEventName.getText();
	}
	
	public String getShortDescriptionValidation(){
		
		return labelShortDescription.getText();
	}
	
	public String getStartDateValidation(){
		
		return labelStartDate.getText();
	}
	
    public String getStarHourValidation(){
		
		return labelStartHour.getText();
	}
	
    public String getEndDateValidation(){
		
		return labelEndDate.getText();
	}
    
    public String getEndHourValidation(){
		
		return labelEndHour.getText();
	}
   
   //Setters
  	public void setName(String eventName){
  		
  		name.sendKeys(eventName);
  	}
  	
  	public void setShortDescription(String shortDescription){
  		
  		short_description.sendKeys(shortDescription);
    			
  	}
  	
  	public void  setStartDate(String startDate){
  		
  		start_date.sendKeys(startDate);
  	}
  	
      public void setStarHour(String startHour){
  		
    	  start_hour.sendKeys(startHour);
  	}
  	
      public void setEndDate(String endDate){
  		
    	  end_date.sendKeys(endDate);
  	}
      
      public void setEndHour(String endHour){
  		
    	   	end_hour.sendKeys(endHour);
    	    
  	}
    
    //Others Methods
    
    //PRIVATES METHODS
    
    //Verify the Presence of One Element Page to Load Method
    private boolean isPageLoad(){
        	
        try {
        	return name.isEnabled();
    	} catch (Exception e) {
    		return false;   
    	}
		  
    	
    }
    
    
    //PUBLICS METHODS
    public void saveEvent(String eventName, String shortDescription, String startDate, String startHour, String endDate, String endHour){
		
   		name.sendKeys(eventName);
    	short_description.sendKeys(shortDescription);
    	start_date.sendKeys(startDate);
    	start_hour.sendKeys(startHour);
    	end_date.sendKeys(endDate);		
    	end_hour.sendKeys(endHour);
    				
    	//eventSaveButton.click();
    	eventSaveButton.sendKeys(Keys.ENTER);
    }
		
     public void saveEvent(){
		
    	 eventSaveButton.sendKeys(Keys.ENTER);
    	
	}
    
     public void saveEventMobile(AppiumDriver<WebElement> driver2){
    	
       	eventSaveButton.sendKeys(Keys.ENTER);
    	 
 	}
   
  
    //Wait Validation Message Load Method
    public boolean waitValidationMessageLoad(){
    	
    	return (new WebDriverWait(this.driver, 10))
				 .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/form/div[3]/p"),"can't be blank"));
	
    }
    
    public void removeReadOnlyAttributes(){
    	
    	((JavascriptExecutor)driver).executeScript ("document.getElementById('start_date').removeAttribute('readonly',0);");
		((JavascriptExecutor)driver).executeScript ("document.getElementById('start_hour').removeAttribute('readonly',0);");
		((JavascriptExecutor)driver).executeScript ("document.getElementById('end_date').removeAttribute('readonly',0);");
		((JavascriptExecutor)driver).executeScript ("document.getElementById('end_hour').removeAttribute('readonly',0);");
    }
    
 
}
