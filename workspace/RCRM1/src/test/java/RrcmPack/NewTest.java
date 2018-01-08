package RrcmPack;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
	// DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	// Set Marionette on so the Grid will use this instead of normal FirefoxDriver
	
	private WebDriver driver;
  @Test
  public void f() {
	  
	  driver.navigate().to("https://test.recruitcrm.io/");
	  String title = driver.getTitle();
	  System.out.println(title);
	  Assert.assertTrue(title.contains("R-CRM - Login to RecruitCRM"));
  }
  @Test
  public void secondTest() {
	  driver.findElement(By.id("loginbtn")).click();
	  System.out.println("This is 2nd Test");
  }
  
  @Test(enabled = false)
  public void userLogIn() {
	  System.out.println("3rd test case");
	  driver.findElement(By.xpath("//div[3]/form/fieldset/div/div[1]/ul/li[1]/div/input")).sendKeys("ykrishna019@gmail.com");
		driver.findElement(By.cssSelector("input#session_password-login")).sendKeys("123");
		driver.findElement(By.cssSelector("input.btn-signin")).click();
  }
  @BeforeTest
  public void beforeTest() {
	//  final FirefoxProfile firefoxProfile = new FirefoxProfile();
	  //  firefoxProfile.setPreference("xpinstall.signatures.required", false);
	 // capabilities.setCapability("marionette", true);

	  driver = new FirefoxDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
