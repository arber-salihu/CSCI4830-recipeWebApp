package com.example.RecipeWebAppTest;

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

public class EditPassword {
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
  public void testEditPassword() throws Exception {
    driver.get("http://34.29.235.45/");
    driver.findElement(By.linkText("Login")).click();
    Thread.sleep(1500);
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    Thread.sleep(1500);
    driver.findElement(By.id("username")).sendKeys("firstuser");
    Thread.sleep(1500);
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    Thread.sleep(1500);
    driver.findElement(By.id("password")).sendKeys("first1");
    Thread.sleep(1500);
    driver.findElement(By.id("login-button")).click();
    Thread.sleep(1500);
    driver.findElement(By.linkText("Profile")).click();
    Thread.sleep(1500);
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    Thread.sleep(1500);
    driver.findElement(By.id("password")).sendKeys("first10");
    Thread.sleep(1500);
    driver.findElement(By.id("saveChangesButton")).click();
    Thread.sleep(1500);
    driver.findElement(By.id("logoutButton")).click();
    Thread.sleep(1500);
    driver.findElement(By.linkText("Login")).click();
    Thread.sleep(1500);
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    Thread.sleep(1500);
    driver.findElement(By.id("username")).sendKeys("firstuser");
    Thread.sleep(1500);
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    Thread.sleep(1500);
    driver.findElement(By.id("password")).sendKeys("first10");
    Thread.sleep(1500);
    driver.findElement(By.id("login-button")).click();
    Thread.sleep(1500);
    driver.findElement(By.linkText("Profile")).click();
    Thread.sleep(1500);
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    Thread.sleep(1500);
    driver.findElement(By.id("password")).sendKeys("first1");
    Thread.sleep(1500);
    driver.findElement(By.id("saveChangesButton")).click();
    Thread.sleep(1500);
    driver.findElement(By.id("logoutButton")).click();
    Thread.sleep(1500);
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
