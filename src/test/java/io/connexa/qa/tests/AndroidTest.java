/*author @andres*/

package io.connexa.qa.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.connexa.qa.general.Fecha;
import io.connexa.qa.general.Init;
import io.connexa.qa.general.Search;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;
import static org.junit.Assert.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import io.connexa.tests.pageobjects.CreateEventPage;
import io.connexa.tests.pageobjects.HomePage;

public class AndroidTest {

	
	private AndroidDriver driver;

	//@Before
	public void setUp() throws MalformedURLException, InterruptedException {
		
		
		
		
		
		File appDir = new File ("C:/");
		File app = new File (appDir,"fribourg.apk");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		 
		  caps.setCapability("device", "Android");
		  //caps.setCapability("platformVersion", "5.1");
		  caps.setCapability("platformName", "Android");
		  caps.setCapability("deviceName", "LGK33028b24184");
		  caps.setCapability("app", app.getAbsolutePath());
		
		  driver = new AndroidDriver(new URL(
					"http://127.0.0.1:4723/wd/hub"), caps);
			
			
	}
	
	//@Test
	/* ************************************************************************/
	public void test() {
		
		String app_package_name = "com.hegfribourg";
		
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Sign In']")));
		
		By signIn = By.xpath("//android.widget.TextView[@text='Sign In']");
		
		driver.findElement(signIn).click();
		
	}
 
		
	//@After
	public void tearDown() throws Exception {
		// Close the browser
		driver.quit();
	}
	
	
	
}
