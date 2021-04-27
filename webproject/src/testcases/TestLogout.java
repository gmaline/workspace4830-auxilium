package testcases;

import java.util.regex.Pattern;

import javax.print.DocFlavor.URL;
import javax.servlet.http.HttpSession;

import java.net.HttpURLConnection;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.Select;

public class TestLogout {
   private WebDriver driver;
   private String baseUrl;
   private boolean acceptNextAlert = true;
   private StringBuffer verificationErrors = new StringBuffer();

   @Before
   public void setUp() throws Exception {
      System.setProperty("webdriver.chrome.driver", "lib/win/chromedriver.exe");
      driver = new ChromeDriver();
      baseUrl = "https://opensource-demo.orangehrmlive.com";
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
      driver.manage().window().maximize();
   }

   public void doLogin() throws Exception {
	   driver.get("http://royalhunter.ddns.net:8080/webproject/SignIn.jsp");
	    driver.findElement(By.linkText("Login")).click();
	    driver.findElement(By.id("email")).click();
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("mp@kids.net");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("mariepop");
	    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	      Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@value='Submit']")).click();
   }

   @Test
   public void testLogout() throws Exception {
      doLogin();
      
    String actualUrl= "http://royalhunter.ddns.net:8080/webproject/Profile";
	String expectedUrl= driver.getCurrentUrl();
	Assert.assertEquals(actualUrl, expectedUrl);
	
	
    driver.findElement(By.linkText("Log Out")).click();
      Thread.sleep(2000);
      
     actualUrl= "http://royalhunter.ddns.net:8080/webproject/LogOut";
	 expectedUrl= driver.getCurrentUrl();
	 Assert.assertEquals(actualUrl, expectedUrl);
		
	 String page = driver.getTitle();
	 Assert.assertEquals(page, "Home Page");
	
      String expected = "Login";
      WebElement findElement = driver.findElement(By.linkText("Login"));
      String result = findElement.getText();
      Assert.assertEquals(expected, result);
      Thread.sleep(2000);
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
