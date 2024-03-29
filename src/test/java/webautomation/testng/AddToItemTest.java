package webautomation.testng;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.Utility;

public class AddToItemTest {
	WebDriver driver;
	LoginPage lp;
	DashBoardPage dp;
	CheckOutPage checkoutpage;
	CheckOutOverviewPage checkOutOverviewPage;
	ThankYouPage thankYouPage;
	Utility cp = new Utility();

	@BeforeTest
	public void setUp() throws IOException {
		driver = DriverSetup.initDriver(cp.dataReaderFromPropertyFile("browser"));
		driver.get(cp.dataReaderFromPropertyFile("url"));
		lp = new LoginPage(driver);
		dp = new DashBoardPage(driver);
		checkoutpage = new CheckOutPage(driver);
		checkOutOverviewPage = new CheckOutOverviewPage(driver);
		thankYouPage = new ThankYouPage(driver);

	}

	@Test(dataProvider = "datafromJSON")
	public void addToCartSingleItem(String userdata) throws IOException {
		String[] user = userdata.split(",");
		lp.userName.sendKeys(cp.dataReaderFromPropertyFile("standard_userName"));
		lp.password.sendKeys(cp.dataReaderFromPropertyFile("standard_user"));
		lp.loginBtnClick();
		Assert.assertEquals(dp.navigationBar.isEnabled(), true);
		Assert.assertEquals(dp.shoppingCart.isDisplayed(), true);
		String itemName = dp.chekinItemName.getText();
		String itemAmount = dp.fetchItemAmount("Sauce Labs Backpack").getText();
		dp.clickOnItem("Sauce Labs Backpack").click();
		dp.shoppingCart.click();
		checkoutpage.checkout.click();
		Assert.assertEquals(checkoutpage.headerpage.getText(), "Checkout: Your Information");
		checkoutpage.firstname.sendKeys(user[0]);
		checkoutpage.lastname.sendKeys(user[1]);
		checkoutpage.postalcode.sendKeys(user[2]);
		checkoutpage.continuee.click();
		Assert.assertEquals(checkOutOverviewPage.overviewHeader.getText(), "Checkout: Overview");
		Assert.assertEquals(itemName, checkOutOverviewPage.checkedoutItem.getText());
		Assert.assertEquals(itemAmount, checkOutOverviewPage.checkedoutItemAmount.getText());
		checkOutOverviewPage.finish.click();
		Assert.assertEquals(thankYouPage.headerpage.getText(), "Checkout: Complete!");
		Assert.assertEquals(thankYouPage.orderMsg.getText(), "Thank you for your order!");
		thankYouPage.backtoproducts.click();
		dp.navigationBar.click();
		dp.logout.click();
	}

	@DataProvider(name = "datafromJSON")
	public String[] dataProviderJSON() throws IOException, ParseException {
		return cp.jsonReader();
	}

	@Test()
	public void addToCartMultipleItems() throws IOException {
		
		lp.userName.sendKeys(cp.dataReaderFromPropertyFile("standard_userName"));
		lp.password.sendKeys(cp.dataReaderFromPropertyFile("standard_user"));
		lp.loginBtnClick();
		Assert.assertEquals(dp.navigationBar.isEnabled(), true);
		Assert.assertEquals(dp.shoppingCart.isDisplayed(), true);
		String itemName = dp.chekinItemName.getText();
		String itemAmount = dp.fetchItemAmount("Sauce Labs Backpack").getText();
		dp.clickOnItem("Sauce Labs Backpack").click();
		dp.clickOnItem("Sauce Labs Bike Light").click();
		dp.shoppingCart.click();
		checkoutpage.checkout.click();
		Assert.assertEquals(checkoutpage.headerpage.getText(), "Checkout: Your Information");
		checkoutpage.firstname.sendKeys("Neymar");
		checkoutpage.lastname.sendKeys("Tripathi");
		checkoutpage.postalcode.sendKeys("23097");
		checkoutpage.continuee.click();
		Assert.assertEquals(checkOutOverviewPage.overviewHeader.getText(), "Checkout: Overview");
		Assert.assertEquals(itemName, checkOutOverviewPage.checkedoutItem.getText());
		Assert.assertEquals(itemAmount, checkOutOverviewPage.checkedoutItemAmount.getText());
		checkOutOverviewPage.finish.click();
		Assert.assertEquals(thankYouPage.headerpage.getText(), "Checkout: Complete!");
		Assert.assertEquals(thankYouPage.orderMsg.getText(), "Thank you for your order!");
		thankYouPage.backtoproducts.click();
		dp.navigationBar.click();
		dp.logout.click();
	}

	@AfterTest
	public void tearDown() {

		driver.manage().deleteAllCookies();
		driver.quit();
	}

}
