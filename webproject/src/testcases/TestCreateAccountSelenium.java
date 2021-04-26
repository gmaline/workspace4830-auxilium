package testcases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCreateAccountSelenium {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "lib/win/chromedriver.exe");
	  driver = new ChromeDriver();
	  baseUrl = "https://www.google.com/";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCreateAccount() throws Exception {
    driver.get("http://localhost:8080/webproject/LogOut");
    driver.findElement(By.xpath("//body")).click();
    driver.findElement(By.linkText("Register")).click();
    driver.findElement(By.name("firstName")).click();
    driver.findElement(By.name("firstName")).clear();
    driver.findElement(By.name("firstName")).sendKeys("Test");
    driver.findElement(By.name("lastName")).clear();
    driver.findElement(By.name("lastName")).sendKeys("Tester");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("tester@test.edu");
    driver.findElement(By.name("age")).clear();
    driver.findElement(By.name("age")).sendKeys("27");
    driver.findElement(By.name("organization")).clear();
    driver.findElement(By.name("organization")).sendKeys("UNo");
    driver.findElement(By.name("organization")).click();
    driver.findElement(By.name("organization")).clear();
    driver.findElement(By.name("organization")).sendKeys("UNO");
    driver.findElement(By.id("input")).click();
    driver.findElement(By.id("input")).clear();
    driver.findElement(By.id("input")).sendKeys("pass");
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
	Thread.sleep(4000);
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
