package com.example.RecipeWebAppTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.aspectj.bridge.MessageUtil.fail;

public class SignupTestCaseSuccess {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @BeforeEach
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testSignupTestCaseSuccess() throws Exception {
    driver.get(baseUrl + "chrome://newtab/");
    driver.get("http://34.29.235.45/");
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.linkText("Sign Up")).click();
    driver.findElement(By.xpath("//input[@value='']")).click();
    driver.findElement(By.xpath("//input[@value='hello@gmail.com']")).clear();
    driver.findElement(By.xpath("//input[@value='hello@gmail.com']")).sendKeys("hello@gmail.com");
    driver.findElement(By.xpath("//input[@value='hello']")).clear();
    driver.findElement(By.xpath("//input[@value='hello']")).sendKeys("hello");
    driver.findElement(By.xpath("//input[@value='testme']")).clear();
    driver.findElement(By.xpath("//input[@value='testme']")).sendKeys("testme");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
  }

  @AfterEach
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
