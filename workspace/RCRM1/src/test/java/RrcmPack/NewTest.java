package RrcmPack;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class NewTest {
	// DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	// Set Marionette on so the Grid will use this instead of normal FirefoxDriver
	
	private WebDriver driver;

	

  @Test(priority = 1)
  public void verifyPageTitle() {
	  System.out.println("This is first test case");
	  driver.get("https://test.recruitcrm.io/");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  String title = driver.getTitle();
	  System.out.println(title);
	  Assert.assertTrue(title.contains("R-CRM - Login to RecruitCRM"));
	 
  }

 // @Test(enabled = true)
  @Test(priority = 2)
  public void userLogIn() throws InterruptedException {
	
	  driver.navigate().to("https://test.recruitcrm.io/");
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  System.out.println("2nd test case");
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("loginbtn")));

	  driver.findElement(By.id("loginbtn")).click();
	 try {
		 
	  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[3]/form/fieldset/div/div[1]/ul/li[1]/div/input")));
		  driver.findElement(By.xpath("//div[3]/form/fieldset/div/div[1]/ul/li[1]/div/input")).sendKeys("ykrishna019@gmail.com");
	//	  driver.findElement(By.cssSelector("input#session_key-login")).sendKeys("ykrishna019@gmail.com");
			driver.findElement(By.cssSelector("input#session_password-login")).sendKeys("km241193");
			driver.findElement(By.cssSelector("input.btn-signin")).click();
			Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector(".btn.btn-primary"));
		System.out.println("Login Success !!");
 }
	catch(Exception e) { 
		System.out.println("Please enter valid credentioals");
		
	}  
  }  
  @BeforeTest
  public void beforeTest() {
	//  final FirefoxProfile firefoxProfile = new FirefoxProfile();
	  //  firefoxProfile.setPreference("xpinstall.signatures.required", false);
	 // capabilities.setCapability("marionette", true);

	//  driver = new FirefoxDriver();
		 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		 ChromeOptions option = new ChromeOptions();
		 option.addArguments("disable-infobars");
		 option.addArguments("--start-maximized");
		 driver = new ChromeDriver(option);
		 
  }
  

  @AfterTest
  public void afterTest() {
	 // driver.quit();
  }

}
