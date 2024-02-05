package webautomation.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverviewPage {
	WebDriver driver;
	@FindBy(id = "finish")
	WebElement finish;
	@FindBy(id = "item_4_title_link")
	WebElement checkedoutItem;
	@FindBy(xpath= "//*[@id='item_4_title_link']//parent::div[contains(@class,'label')]//following::div[contains(@class,'price')]//child::div")
	WebElement checkedoutItemAmount;
	@FindBy(xpath = "//*[text()='Checkout: Overview']")
	WebElement overviewHeader;
	
	
	public CheckOutOverviewPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
}
