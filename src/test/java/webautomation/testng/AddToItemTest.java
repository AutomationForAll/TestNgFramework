package webautomation.testng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToItemTest {
	WebDriver driver;
	LoginPage lp;
	DashBoardPage dp;
	CheckOutPage checkoutpage;
	CheckOutOverviewPage checkOutOverviewPage;
	CommonPage cp= new CommonPage();
	
	
	@BeforeTest
	public void setUp() throws IOException {
		driver=DriverSetup.initDriver(cp.dataReaderFromPropertyFile("browser"));
		driver.get(cp.dataReaderFromPropertyFile("url"));
		
	}
	
	@Test
	public void addToCartItems() throws IOException {
		lp= new LoginPage(driver);
		dp= new DashBoardPage(driver);
		checkoutpage= new CheckOutPage(driver);
		checkOutOverviewPage= new CheckOutOverviewPage(driver);
		lp.userName.sendKeys(cp.dataReaderFromPropertyFile("standard_userName"));
		lp.password.sendKeys(cp.dataReaderFromPropertyFile("standard_user"));
		lp.loginBtnClick();
		Assert.assertEquals(dp.navigationBar.isEnabled(), true);
		Assert.assertEquals(dp.shoppingCart.isDisplayed(), true);
		dp.itembag.click();
		dp.shoppingCart.click();
		checkoutpage.checkout.click();
		Assert.assertEquals(checkoutpage.headerpage.getText(), "Checkout: Your Information");
		checkoutpage.firstname.sendKeys("Tom");
		checkoutpage.lastname.sendKeys("hardy");
		checkoutpage.postalcode.sendKeys("21345");
		checkoutpage.continuee.click();
		checkOutOverviewPage.finish.click();
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	

}
