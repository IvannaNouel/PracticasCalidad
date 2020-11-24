package com.mayab.calidad.funcional;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;


import org.junit.runner.Description;

import java.io.ObjectOutput;
import java.net.URL;
public class crudTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "/Users/ivannanouel/Documents/Uni/Calidad/chromedriver");
	    driver = new ChromeDriver();
	    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

 

  @Test
  public void testUntitledTestCase() throws Exception {

	    driver.get("https://mern-crud.herokuapp.com/");
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("prueba");
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("prueba@gmail.com");
	    driver.findElement(By.name("age")).click();
	    driver.findElement(By.name("age")).clear();
	    driver.findElement(By.name("age")).sendKeys("18");
	    driver.findElement(By.xpath("//div[3]/div[2]/div/div")).click();
	    driver.findElement(By.xpath("//div[3]/span")).click();
	    driver.findElement(By.xpath("//form/button")).click();
	    driver.findElement(By.xpath("//div[4]")).click();
	    driver.findElement(By.xpath("//div[4]/div/p")).click();
	    driver.findElement(By.xpath("//div[4]/div/p")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | //div[4]/div/p | ]]
	    driver.findElement(By.xpath("//div[4]/div/p")).click();
	    driver.findElement(By.xpath("//div[4]/div/p")).click();
	    driver.findElement(By.xpath("//div[4]/div/p")).click();
	    driver.findElement(By.xpath("//div[4]/div/p")).click();
	    driver.findElement(By.xpath("//div[4]/div/p")).click();
	    driver.findElement(By.xpath("//div[4]/div/p")).click();
	    driver.findElement(By.xpath("//div[4]/div/p")).click();
	    driver.findElement(By.xpath("//div[4]/div/p")).click();
	    driver.findElement(By.xpath("//div[4]/div/p")).click();
	    driver.findElement(By.xpath("//div[4]/div/p")).click();
	    driver.findElement(By.xpath("//div[4]/div/p")).click();
	    driver.findElement(By.xpath("//form/button")).click();
	    
	    String expected = "Successfully added!";
		String gotMessage="";
		WebElement result = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/p"));
		gotMessage = result.getText();
		assertThat(expected,is(equalTo(gotMessage)));
		boolean finalResult = false;
		if(gotMessage.equals("Successfully added!")) {
			finalResult = true;
		}else {
			finalResult = false;
		}
		if (finalResult){
		      ((JavascriptExecutor)driver).executeScript("sauce:job-result=passed");
		    }
		    else {
		      ((JavascriptExecutor)driver).executeScript("sauce:job-result=failed");
		    }
		driver.quit();
  }
		
		 @Test
		  public void edit() throws Exception {
			  driver.get("https://mern-crud.herokuapp.com/");
			  driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button")).click();
			    driver.findElement(By.name("name")).click();
			    driver.findElement(By.name("name")).clear();
			    driver.findElement(By.name("name")).sendKeys("prueba");
			    driver.findElement(By.name("email")).click();
			    driver.findElement(By.xpath("//div[2]/div/div[2]")).click();
			    driver.findElement(By.name("email")).clear();
			    driver.findElement(By.name("email")).sendKeys("prueba2@gmail.com");
			    driver.findElement(By.xpath("//div[3]/div[2]/div/div")).click();
			    driver.findElement(By.xpath("//div[3]/span")).click();
			    driver.findElement(By.xpath("//form/button")).click();
			    driver.findElement(By.xpath("//div[4]")).click();
			    driver.findElement(By.xpath("//div[4]/div/p")).click();
			    driver.findElement(By.xpath("//div[4]/div/p")).click();
			    driver.findElement(By.xpath("//div[4]/div/p")).click();
			    driver.findElement(By.xpath("//div[4]/div/p")).click();
			    driver.findElement(By.xpath("//div[4]/div/p")).click();
			    driver.findElement(By.xpath("//div[4]/div/p")).click();
			    driver.findElement(By.xpath("//div[4]/div/p")).click();
			    driver.findElement(By.xpath("//div[4]/div/p")).click();
			    driver.findElement(By.xpath("//div[4]/div/p")).click();
			    driver.findElement(By.xpath("//div[4]/div/p")).click();
			    driver.findElement(By.xpath("//div[4]/div/p")).click();
			    driver.findElement(By.xpath("//div[4]/div/p")).click();
			    driver.findElement(By.xpath("//div[4]/div/p")).click();
			    driver.findElement(By.xpath("//form/button")).click();
			    
			    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			    
			    assertEquals("Successfully updated!", driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/p")).getText());
				
		  }
		  
		  @Test
		  public void delete() throws Exception {

			  	boolean test=true;
			  
			    driver.get("https://mern-crud.herokuapp.com/");
			    String email=driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[2]")).getText();
			    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button[2]")).click();
			    driver.findElement(By.xpath("//div[3]/button")).click();
			    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    driver.get("https://mern-crud.herokuapp.com/");
			    String correo2=driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[2]")).getText();
			    System.out.println(email);
			    System.out.println(correo2);

			    if (email.equals(correo2)) {
			    	test=false;
			    }
			    
			    assertEquals(test, true);
				
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

