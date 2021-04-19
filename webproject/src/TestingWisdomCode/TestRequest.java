package TestingWisdomCode;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestRequest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "lib/win/chromedriver.exe");
		driver = new ChromeDriver(); // FirefoxDriver();
		baseUrl = "https://www.unomaha.edu/registrar/students/before-you-enroll/class-search/index.php";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	  public void doLogin() throws Exception {
//		   driver.get("http://royalhunter.ddns.net:8080/webproject/LogOut");
		  driver.findElement(By.name("email")).click();
		    driver.findElement(By.name("email")).clear();
		    driver.findElement(By.name("email")).sendKeys("afolly@unomaha.edu");
		    driver.findElement(By.id("input")).click();
		    driver.findElement(By.id("input")).clear();
		    driver.findElement(By.id("input")).sendKeys("Auxilium");
		    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		      Thread.sleep(1000);
		    driver.findElement(By.xpath("//input[@value='Submit']")).click();
	   }
	  
	  
	@Test
	public void testRequest() throws Exception {
		
		 driver.get("http://royalhunter.ddns.net:8080/webproject/HomePage.jsp");
		    driver.findElement(By.linkText("Request")).click();
		    
	  doLogin();
      
	    String actualUrl= "http://royalhunter.ddns.net:8080/webproject/HomePage.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	
		
		 driver.findElement(By.linkText("Request")).click();
		 
		 actualUrl= "http://royalhunter.ddns.net:8080/webproject/Request";
		expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		 
		    driver.findElement(By.id("id")).click();
		    driver.findElement(By.id("id")).clear();
		    driver.findElement(By.id("id")).sendKeys("0");
		    driver.findElement(By.name("requester")).click();
		    driver.findElement(By.xpath("//input[@value='Submit']")).click();
		    driver.findElement(By.name("requester")).click();
		    driver.findElement(By.id("id")).clear();
		    driver.findElement(By.id("id")).sendKeys("-1");
		    driver.findElement(By.xpath("//input[@value='Submit']")).click();
		    driver.findElement(By.name("requester")).click();
		    driver.findElement(By.id("id")).clear();
		    driver.findElement(By.id("id")).sendKeys("22");
		    driver.findElement(By.xpath("//input[@value='Submit']")).click();
		    driver.findElement(By.linkText("Auxilium")).click();
		    
		    actualUrl= "http://royalhunter.ddns.net:8080/webproject/HomePage.jsp";
			expectedUrl= driver.getCurrentUrl();
			Assert.assertEquals(actualUrl, expectedUrl);
		
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
