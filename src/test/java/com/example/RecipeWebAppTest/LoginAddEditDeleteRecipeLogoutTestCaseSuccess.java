package com.example.RecipeWebAppTest;

import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginAddEditDeleteRecipeLogoutTestCaseSuccess {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testLoginAddEditDeleteRecipeLogoutTestCaseSuccess() throws Exception {
    driver.get("http://34.29.235.45/");
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.xpath("//input[@value='']")).click();
    driver.findElement(By.xpath("//input[@value='hello']")).clear();
    driver.findElement(By.xpath("//input[@value='hello']")).sendKeys("hello");
    driver.findElement(By.xpath("//input[@value='']")).click();
    driver.findElement(By.xpath("//input[@value='testme']")).clear();
    driver.findElement(By.xpath("//input[@value='testme']")).sendKeys("testme");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("New Recipe")).click();
    driver.findElement(By.id("title")).click();
    driver.findElement(By.id("title")).clear();
    driver.findElement(By.id("title")).sendKeys("Toast");
    driver.findElement(By.id("description")).click();
    driver.findElement(By.id("description")).clear();
    driver.findElement(By.id("description")).sendKeys("1. It is toast.");
    driver.findElement(By.id("ingredients")).click();
    driver.findElement(By.id("ingredients")).clear();
    driver.findElement(By.id("ingredients")).sendKeys("1. Toast.");
    driver.findElement(By.id("instructions")).click();
    driver.findElement(By.id("instructions")).clear();
    driver.findElement(By.id("instructions")).sendKeys("1. Put bread in toaster.\n2. Enjoy");
    driver.findElement(By.id("calorieCount")).click();
    driver.findElement(By.id("calorieCount")).clear();
    driver.findElement(By.id("calorieCount")).sendKeys("50");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//div[@id='root']/div[2]/div[8]/a/div/div/h2")).click();
    driver.findElement(By.linkText("Edit")).click();
    driver.findElement(By.id("ingredients")).click();
    driver.findElement(By.id("ingredients")).clear();
    driver.findElement(By.id("ingredients")).sendKeys("1. Bread.");
    driver.findElement(By.id("calorieCount")).click();
    driver.findElement(By.id("calorieCount")).clear();
    driver.findElement(By.id("calorieCount")).sendKeys("100");
    driver.findElement(By.id("instructions")).click();
    driver.findElement(By.id("instructions")).click();
    driver.findElement(By.id("instructions")).clear();
    driver.findElement(By.id("instructions")).sendKeys("1. Put bread in toaster.\n2. Put butter on toast\n3. Enjoy");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//div[@id='root']/div[2]/div[8]/a/div/div/h2")).click();
    driver.findElement(By.linkText("Edit")).click();
    driver.findElement(By.xpath("//div[@id='root']/div[2]/form/button[2]")).click();
    driver.findElement(By.linkText("Profile")).click();
    driver.findElement(By.xpath("//div[@id='root']/div[2]/div/button")).click();
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
