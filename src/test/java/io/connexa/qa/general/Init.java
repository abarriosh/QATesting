package io.connexa.qa.general;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Init {

	static public final String TENANT_DOMAIN_CONNEXA = "http://demo.staging.connexa.io";
	static public final String TENANT_DOMAIN_SWIP = "http://net.staging.swip.world";
	
		
	public static Object setDriver(String browser, String tenant, WebDriver driver){
	
        switch (browser){
        	case "f" : 	System.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/geckodriver.exe");
        						driver = new FirefoxDriver();
        	break;
        
        	case "c": 	System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
        						driver = new ChromeDriver();
		   	break;
        
        }
		
	   
        // Maximize the browser window
        driver.manage().window().maximize();
		// Navigate to Tenant
		driver.get(tenant);
	
		return driver;
		
	}
	
	
	@Deprecated
	public static void setCredentials(WebDriver driver){
		
		WebElement email, password, signIn;
		
		//Setting the credentials
		email = driver.findElement(By.name("email"));
		email.clear();
		email.sendKeys("andres@connexa.io");
		
		password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("hp692cie");
		
		
		signIn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div[3]/div/div/form/button"));
		signIn.click(); 

		
		
		//Wait for an Element after Sign In -- In this case Field for Global Search was used
		 (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("term")));
		 
	}
	
}
