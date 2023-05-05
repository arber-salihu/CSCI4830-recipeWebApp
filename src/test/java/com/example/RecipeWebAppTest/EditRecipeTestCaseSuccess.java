package com.example.RecipeWebAppTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.aspectj.bridge.MessageUtil.fail;

public class EditRecipeTestCaseSuccess {
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
  public void testEditRecipeTestCaseSuccess() throws Exception {
    driver.get("http://34.29.235.45/");
    driver.findElement(By.xpath("//div[@id='root']/div[2]/div[8]/a/div/div/h2")).click();
    driver.findElement(By.linkText("Edit")).click();
    driver.findElement(By.id("instructions")).click();
    driver.findElement(By.id("instructions")).clear();
    driver.findElement(By.id("instructions")).sendKeys("1. Mix in all ingredients\n2. Put away all ingredients");
    driver.findElement(By.id("calorieCount")).click();
    driver.findElement(By.id("calorieCount")).clear();
    driver.findElement(By.id("calorieCount")).sendKeys("300");
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
