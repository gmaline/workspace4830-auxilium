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
		  driver.get("http://royalhunter.ddns.net:8080/webproject/HomePage.jsp");
		    driver.findElement(By.linkText("Login")).click();
		    driver.findElement(By.id("email")).click();
		    driver.findElement(By.id("email")).clear();
		    driver.findElement(By.id("email")).sendKeys("mp@kids.net");
		    driver.findElement(By.id("password")).click();
		    driver.findElement(By.id("password")).clear();
		    driver.findElement(By.id("password")).sendKeys("mariepop");
		    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		    driver.findElement(By.xpath("//input[@value='Submit']")).click();
		    Thread.sleep(1000);

		    driver.findElement(By.linkText("Donate")).click();
		    driver.findElement(By.id("type")).click();
		    new Select(driver.findElement(By.id("type"))).selectByVisibleText("Other");
		    driver.findElement(By.id("type")).click();
		    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		    driver.findElement(By.id("name")).click();
		    driver.findElement(By.id("name")).clear();
		    driver.findElement(By.id("name")).sendKeys("Umbrella");
		    driver.findElement(By.id("quality")).click();
		    new Select(driver.findElement(By.id("quality"))).selectByVisibleText("Heavily Used");
		    driver.findElement(By.id("quality")).click();
		    driver.findElement(By.id("description")).click();
		    driver.findElement(By.id("description")).clear();
		    driver.findElement(By.id("description")).sendKeys("It flies");
		    driver.findElement(By.xpath("//input[@value='Submit']")).click();
		    driver.findElement(By.xpath("(//a[contains(text(),'View')])[4]")).click();
		    Thread.sleep(1000);

		    driver.findElement(By.linkText("Listings")).click();
		    driver.findElement(By.linkText("Log Out")).click();
		    Thread.sleep(1000);

		    driver.findElement(By.linkText("Login")).click();
		    driver.findElement(By.id("email")).click();
		    driver.findElement(By.id("email")).clear();
		    driver.findElement(By.id("email")).sendKeys("godofthunder@avengers.com");
		    driver.findElement(By.id("password")).clear();
		    driver.findElement(By.id("password")).sendKeys("StrongestAvenger");
		    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		    Thread.sleep(1000);

		    driver.findElement(By.xpath("//input[@value='Submit']")).click();
	   }
	  
	  
	@Test
	public void testRequest() throws Exception {
	  doLogin();
	    Thread.sleep(1000);

	    driver.findElement(By.linkText("Listings")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'View')])[4]")).click();
	    driver.findElement(By.linkText("Request")).click();
	    
	    String actualUrl= "http://royalhunter.ddns.net:8080/webproject/Request.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		    
		String page = driver.getTitle();
		Assert.assertEquals(page, "Request Page");
	    
	    driver.findElement(By.id("id")).click();
	    driver.findElement(By.id("id")).clear();
	    driver.findElement(By.id("id")).sendKeys("13"); //:TODO every time you run it
	    driver.findElement(By.xpath("//input[@value='Submit']")).click();
	    Thread.sleep(1000);
	    
	    driver.findElement(By.linkText("Auxilium")).click();
	    actualUrl= "http://royalhunter.ddns.net:8080/webproject/HomePage.jsp";
		expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	    Thread.sleep(1000);
	    
	    driver.findElement(By.linkText("Log Out")).click();
	    driver.findElement(By.linkText("Login")).click();
	    driver.findElement(By.xpath("//div[@id='container']/div/div[2]")).click();
	    driver.findElement(By.id("email")).click();
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("mp@kids.net");
	    driver.findElement(By.id("password")).click();
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("mariepop");
	    try {
	    driver.findElement(By.xpath("//input[@value='Submit']")).click();
	    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	    Thread.sleep(1000);

	    driver.findElement(By.id("acceptRequest")).click();
	    Thread.sleep(1000);

	    driver.findElement(By.linkText("Log Out")).click();
	    }catch (Exception e) { /*Ignore*/ };
	    
		actualUrl= "http://royalhunter.ddns.net:8080/webproject/LogOut";
		expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		
		 page = driver.getTitle();
		 Assert.assertEquals(page, "Home Page");
		
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
