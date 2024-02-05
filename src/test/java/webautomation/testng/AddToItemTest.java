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
	ThankYouPage thankYouPage;
	CommonPage cp= new CommonPage();
	
	
	@BeforeTest
	public void setUp() throws IOException {
		driver=DriverSetup.initDriver(cp.dataReaderFromPropertyFile("browser"));
		driver.get(cp.dataReaderFromPropertyFile("url"));
		
	}
	
	@Test
	public void addToCartSingleItem() throws IOException {
		lp= new LoginPage(driver);
		dp= new DashBoardPage(driver);
		checkoutpage= new CheckOutPage(driver);
		checkOutOverviewPage= new CheckOutOverviewPage(driver);
		thankYouPage= new ThankYouPage(driver);
		lp.userName.sendKeys(cp.dataReaderFromPropertyFile("standard_userName"));
		lp.password.sendKeys(cp.dataReaderFromPropertyFile("standard_user"));
		lp.loginBtnClick();
		Assert.assertEquals(dp.navigationBar.isEnabled(), true);
		Assert.assertEquals(dp.shoppingCart.isDisplayed(), true);
		String itemName=dp.chekinItemName.getText();
		String itemAmount=dp.itemAmount.getText();
		dp.itembag.click();
		dp.shoppingCart.click();
		checkoutpage.checkout.click();
		Assert.assertEquals(checkoutpage.headerpage.getText(), "Checkout: Your Information");
		checkoutpage.firstname.sendKeys("Tom");
		checkoutpage.lastname.sendKeys("hardy");
		checkoutpage.postalcode.sendKeys("21345");
		checkoutpage.continuee.click();
		Assert.assertEquals(checkOutOverviewPage.overviewHeader.getText(),"Checkout: Overview");
		Assert.assertEquals(itemName,checkOutOverviewPage.checkedoutItem.getText());
		Assert.assertEquals(itemAmount,checkOutOverviewPage.checkedoutItemAmount.getText());
		checkOutOverviewPage.finish.click();
		Assert.assertEquals(thankYouPage.headerpage.getText(),"Checkout: Complete!");
		Assert.assertEquals(thankYouPage.orderMsg.getText(),"Thank you for your order!");
		thankYouPage.backtoproducts.click();
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	

}
