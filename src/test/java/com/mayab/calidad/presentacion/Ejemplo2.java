package com.mayab.calidad.presentacion;


import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Ejemplo2 {
	private static void pause(long mils) {
		  try {
			  Thread.sleep(mils);
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	  }

	

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
       WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[2]/button"));
		element.click();
		String name = "Ivanna2";
		String email = "hola@yahoo.com";
		String age = "19";

		element = driver.findElement(By.name("name"));
		element.sendKeys(name);
		element = driver.findElement(By.name("email"));
		element.sendKeys(email);
		element = driver.findElement(By.name("age"));
		element.sendKeys(age);
		element = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div"));
		element.click();
		element = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div/div[2]/div[1]"));
		element.click();
		element = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button"));
		element.click();
		pause(3000);

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