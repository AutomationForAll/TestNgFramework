package webautomation.testng;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.Utility;


public class LoginTest {
	WebDriver driver;
	LoginPage lp;
	Utility cp= new Utility();

	@BeforeTest
	public void setUp() {
		driver=DriverSetup.initDriver("chrome");
		driver.get("https://www.saucedemo.com/");    
	}

	@Test()
	public void pageCheckTest() {

		lp = new LoginPage(driver);
		Assert.assertEquals(lp.getLogoText(), "Swag Labs", "not matched string");
		Assert.assertEquals(lp.userName.isDisplayed(), true);
		Assert.assertEquals(lp.password.isEnabled(), true);
		lp.loginBtnClick();

	}
	
	@Test
	public void LogInTest() throws IOException {
		
		lp = new LoginPage(driver);
		lp.userName.sendKeys("standard_user");
		lp.password.sendKeys(cp.dataReaderFromPropertyFile("standard_user"));
		lp.loginBtnClick();

	}

	@AfterTest
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.close();

	}

}
