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

public class TestProfile {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "lib/win/chromedriver.exe");
		driver = new ChromeDriver(); // FirefoxDriver();
		baseUrl = "https://www.unomaha.edu/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	 public void doLogin() throws Exception {
		    driver.get("http://royalhunter.ddns.net:8080/webproject/HomePage.jsp");
		    driver.findElement(By.linkText("Login")).click();
		    driver.findElement(By.name("email")).click();
		    driver.findElement(By.name("email")).clear();
		    driver.findElement(By.name("email")).sendKeys("afolly@unomaha.edu");
		    driver.findElement(By.id("input")).clear();
		    driver.findElement(By.id("input")).sendKeys("Auxilium");
		    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		    driver.findElement(By.xpath("//input[@value='Submit']")).click();
	}
	 
	@Test
	public void testProfile() throws Exception {
		doLogin();

	    driver.findElement(By.linkText("Profile")).click();
	    String actualUrl= "http://royalhunter.ddns.net:8080/webproject/Profile";
	  	String expectedUrl= driver.getCurrentUrl();
	  	Assert.assertEquals(actualUrl, expectedUrl);
	      Thread.sleep(2000);
	      
	      String expected = "Profile";
	      WebElement findElement = driver.findElement(By.linkText("Profile"));
	      String result = findElement.getText();
	      Assert.assertEquals(expected, result);
	      Thread.sleep(2000);
	      
	      driver.findElement(By.linkText("Auxilium")).click();
	      Thread.sleep(1000);
	      
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
