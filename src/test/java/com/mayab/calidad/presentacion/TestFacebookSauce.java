package com.mayab.calidad.presentacion;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;


import java.net.URL;

public class TestFacebookSauce {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  public static final String URL = "https://ivannamarcelle:8f36c273-4326-4966-b697-2bb9497a28a3@ondemand.us-west-1.saucelabs.com:443/wd/hub";


  @Before
  public void setUp() throws Exception {

    
	  DesiredCapabilities caps = DesiredCapabilities.chrome();
	    caps.setCapability("platform", "Windows 10");
	    caps.setCapability("platform", "Linux");
	    caps.setCapability("platform", "macOS 10.13");
	    caps.setCapability("version", "latest");
	    caps.setCapability("name", "Test1");
	    caps.setCapability("extendedDebugging", "true");
	    caps.setCapability("buildNumber", "3.0");
	    WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
	    driver.get("https://www.facebook.com/");
	    
	    
	    driver.findElement(By.id("email")).click();
	    driver.findElement(By.id("email")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=email | ]]
	    driver.findElement(By.id("email")).click();
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("ivannamarcelle@hotmail.com");
	    driver.findElement(By.xpath("//div[@id='content']/div/div")).click();
	    driver.findElement(By.id("pass")).click();
	    driver.findElement(By.id("pass")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=pass | ]]
	    driver.findElement(By.id("pass")).click();
	    driver.findElement(By.id("pass")).clear();
	    driver.findElement(By.id("pass")).sendKeys("marcelle");
	    driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
	    driver.findElement(By.id("pass")).click();
	    driver.findElement(By.id("pass")).clear();
	
	   // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   // assertEquals("La contraseña que ingresaste es incorrecta. ¿Olvidaste tu contraseña?",driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]/div[2]/form/div/div[2]/div[2]")).getText());
	  //Close current browser
	  		driver.close();
	  		
	  		//Close all the browsers
	  		driver.quit();
	  	
  }

  @Test
  public void testFacebook() throws Exception {
	  
   
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
