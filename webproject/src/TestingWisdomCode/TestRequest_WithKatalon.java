package TestingWisdomCode;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.hibernate.HibernateException;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestRequest_WithKatalon {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "lib/win/chromedriver.exe");
		driver = new ChromeDriver(); // FirefoxDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testRequest() throws Exception {
    driver.get("http://royalhunter.ddns.net:8080/webproject/HomePage.jsp");
    driver.findElement(By.linkText("Request")).click();
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("afolly@unomaha.edu");
    driver.findElement(By.id("input")).click();
    driver.findElement(By.id("input")).clear();
    driver.findElement(By.id("input")).sendKeys("Auxilium");
    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
    driver.findElement(By.linkText("Request")).click();
    driver.findElement(By.id("id")).click();
    driver.findElement(By.id("id")).clear();
/*    
    try {
    driver.findElement(By.id("id")).sendKeys("0");
    driver.findElement(By.name("requester")).click();
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
    driver.findElement(By.name("requester")).click();
    }catch (UnhandledAlertException e) {
         e.printStackTrace();	}
    
   try {
    driver.findElement(By.id("id")).clear();
    driver.findElement(By.id("id")).sendKeys("-1");
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
    driver.findElement(By.name("requester")).click();
    }catch (UnhandledAlertException e) {
         e.printStackTrace();	}
    
*/    
    driver.findElement(By.id("id")).clear();
    driver.findElement(By.id("id")).sendKeys("22");
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
    driver.findElement(By.linkText("Auxilium")).click();
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