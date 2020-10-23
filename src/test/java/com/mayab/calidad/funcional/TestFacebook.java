package com.mayab.calidad.funcional;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestFacebook {
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
  public void testFacebook() throws Exception {
    driver.get("https://www.facebook.com/");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=email | ]]
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("ivannamarcelle@gmail.com");
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
    driver.findElement(By.id("pass")).sendKeys("ma");
    driver.findElement(By.id("pass")).click();
    driver.findElement(By.id("pass")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=pass | ]]
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("marcelle60");
    driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    assertEquals("La contraseña que ingresaste es incorrecta. ¿Olvidaste tu contraseña?",driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]/div[2]/form/div/div[2]/div[2]")).getText());
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
