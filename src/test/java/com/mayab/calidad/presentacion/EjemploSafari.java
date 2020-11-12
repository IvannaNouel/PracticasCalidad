package com.mayab.calidad.presentacion;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

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
public class EjemploSafari {

	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  


	  final static String sauceUserName = System.getenv("ivannanouel");
	    final static String sauceAccessKey = System.getenv("ce1c7554-a4d4-4a93-a2df-a7538b3db960");
	    final static String sauceURL = "https://ivannanouel:ce1c7554-a4d4-4a93-a2df-a7538b3db960@ondemand.us-west-1.saucelabs.com:443/wd/hub";
		public static void main(String[] args) throws Exception {
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("username", sauceUserName);
	        capabilities.setCapability("accessKey", sauceAccessKey);
	        capabilities.setCapability("browserName", "Safari");
	        capabilities.setCapability("platform", "macOS 10.13");
	        capabilities.setCapability("version", "11");
	        capabilities.setCapability("build", "Onboarding Sample App - Java-Junit5");
	        capabilities.setCapability("name", "80-cross-browser");
	       WebDriver driver = new RemoteWebDriver(new URL(sauceURL), capabilities);
	       driver.get("https://mern-crud.herokuapp.com");
		  
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("Marcelle");
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("marcelle@gmail.com");
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

}