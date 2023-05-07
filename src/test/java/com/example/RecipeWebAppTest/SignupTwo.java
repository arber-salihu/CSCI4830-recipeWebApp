package com.example;

import java.time.Duration;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class SignupTwo {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");

    // Enable verbose logging
    options.setCapability("goog:loggingPrefs", Collections.singletonMap("browser", "ALL"));

    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lee\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver(options);

    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testSignupTwo() throws Exception {
    driver.get("http://34.29.235.45/");
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.xpath("//input[@value='']")).click();
    driver.findElement(By.xpath("//div[@id='root']/div[2]/form/button[2]")).click();
    driver.findElement(By.linkText("Sign Up")).click();
    driver.findElement(By.xpath("//input[@value='']")).click();
    driver.findElement(By.xpath("//div[@id='root']/div[2]/form/label/input")).clear();
    driver.findElement(By.xpath("//div[@id='root']/div[2]/form/label/input")).sendKeys("testing@testing.com");
    driver.findElement(By.xpath("//div[@id='root']/div[2]/form")).click();
    driver.findElement(By.xpath("//input[@value='']")).click();
    driver.findElement(By.xpath("//div[@id='root']/div[2]/form/label[2]/input")).clear();
    driver.findElement(By.xpath("//div[@id='root']/div[2]/form/label[2]/input")).sendKeys("test2");
    driver.findElement(By.xpath("//input[@value='']")).click();
    driver.findElement(By.xpath("//div[@id='root']/div[2]/form/label[3]/input")).clear();
    driver.findElement(By.xpath("//div[@id='root']/div[2]/form/label[3]/input")).sendKeys("test2");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.xpath("//input[@value='']")).click();
    driver.findElement(By.xpath("//div[@id='root']/div[2]/form/label/input")).clear();
    driver.findElement(By.xpath("//div[@id='root']/div[2]/form/label/input")).sendKeys("test2");
    driver.findElement(By.xpath("//input[@value='']")).click();
    driver.findElement(By.xpath("//div[@id='root']/div[2]/form/label[2]/input")).clear();
    driver.findElement(By.xpath("//div[@id='root']/div[2]/form/label[2]/input")).sendKeys("test2");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
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

