//author andres

package io.connexa.tests.pageobjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AboutEventPage extends LoadableComponent <AboutEventPage>{

	
	@FindBy (xpath = "/html/body/div[1]/div/div/div/div[3]/div/div/div[2]/div/div/div/div/div/div[1]/div[2]/div/div/div/div[1]/h1")
	private WebElement labelEventName;
	
	private WebDriver driver;
	
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		assertTrue("About Event Page is not loaded",
				this.isPageLoad());
	}

	/*CLASS CONSTRUCTOR*/
	public AboutEventPage (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
			
	}
	
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div[2]/div/div/div/div/div/div[1]/div[2]/div/div/div/div[1]/h1")));
		this.driver.getCurrentUrl();
	}

	 private boolean isPageLoad(){
     	
	        try {
	        	return labelEventName.isEnabled();
	    	} catch (Exception e) {
	    		return false;   
	    	}
			  
	    	
	    }
	
	 public String getLabelEventName(){
			
			return labelEventName.getText();
	}
	 
}
