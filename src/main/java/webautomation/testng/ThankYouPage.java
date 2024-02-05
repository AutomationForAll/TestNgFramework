package webautomation.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankYouPage {
	WebDriver driver;
	
	@FindBy(id = "back-to-products")
	WebElement backtoproducts;
	@FindBy(xpath = "//*[text()='Checkout: Complete!']")
	WebElement headerpage;
	@FindBy(xpath = "//*[text()='Thank you for your order!']")
	WebElement orderMsg;
	
	
	public ThankYouPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
}
