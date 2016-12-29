package io.connexa.qa;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Prueba {

	static Calendar rightNow = Calendar.getInstance();
	
	
	 //Wait Validation Message Load Method
    /*public void waitPageLoad(WebDriver driver){
    	(new WebDriverWait(this.driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
    }*/
    
	
	 /*
    Set<String> contextNames = driver.getContextHandles(); //((AppiumDriver<WebElement>) driver).getContextHandles();
    for (String contextName : contextNames) {
          System.out.println(contextName);
          if (contextName.contains("WEBVIEW_1")){
            driver.context(contextName);
          }
    }*/
    
	//driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);	
	
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rightNow.getTime());
		
		SimpleDateFormat date = new SimpleDateFormat ("yyyy-MM-dd");
		SimpleDateFormat hour = new SimpleDateFormat ("HH:mm");
		
		System.out.println(date.format(rightNow.getTime()));
		System.out.println(hour.format(rightNow.getTime()));
		
		rightNow.add(Calendar.MINUTE,5);
		System.out.println(hour.format(rightNow.getTime()));
		
	}

}
