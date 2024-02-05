package webautomation.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	WebDriver driver;
	@FindBy(id = "checkout")
	WebElement checkout;
	@FindBy(id = "first-name")
	WebElement firstname;
	@FindBy(id = "last-name")
	WebElement lastname;
	@FindBy(id = "postal-code")
	WebElement postalcode;
	@FindBy(xpath = "//*[text()='Checkout: Your Information']")
	WebElement headerpage;
	@FindBy(id = "continue")
	WebElement continuee;
	
	public CheckOutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
}
