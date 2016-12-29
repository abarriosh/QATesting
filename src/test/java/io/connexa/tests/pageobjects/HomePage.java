//author andres

package io.connexa.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import org.openqa.selenium.Keys;


public class HomePage extends LoadableComponent<CreateEventPage>{

	//Fields
	private WebElement email;
	private WebElement password;
	
	//Buttons
	@FindBy (xpath = "/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/div/div/form/button")
	private WebElement signInButton;
	
	
	private WebDriver driver;
	private String url;

	
	/*CLASS CONSTRUCTOR*/
	public HomePage (WebDriver driver, String tenant){
		this.driver = driver;
		this.url = tenant ;		
		//touch = new TouchActions(driver);
		PageFactory.initElements(driver, this);
			
	}
	
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		assertTrue("Home Page is not loaded",
				this.isPageLoad());
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		this.driver.get(url);
	}

	public void signIn(String emailText, String passwordText) throws InterruptedException{
		
		email.sendKeys(emailText);
		password.sendKeys(passwordText);
		
					
		signInButton.click();
		
		//Wait for an Element after Sign In -- In this case Field for Global Search was used
		//MUST BE CHANGE TO A CALL TO TIMELINEPAGE WEBELEMENT
		 (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("term")));
		 
		
	}
	
	
	//PRIVATES METHODS
    
    //Verify the Presence of One Element Page to Load Method
    private boolean isPageLoad(){
        	
        try {
        	return email.isEnabled();
    	} catch (Exception e) {
    		return false;   
    	}
		  
    	
    }

	public void signInMobile(String string, String string2, AppiumDriver<WebElement> driver2) {
		// TODO Auto-generated method stub
		email.sendKeys(string);
		password.sendKeys(string2);
		
		
		driver2.getKeyboard().sendKeys(Keys.ENTER);
		
			
		//Wait for an Element after Sign In -- In this case Field for Global Search was used
		//MUST BE CHANGE TO A CALL TO TIMELINEPAGE WEBELEMENT
		 (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("term")));
		
		
	}
	
}
