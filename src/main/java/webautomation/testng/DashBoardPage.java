package webautomation.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

	WebDriver driver;
	@FindBy(id = "react-burger-menu-btn")
	WebElement navigationBar;
	@FindBy(className = "shopping_cart_link")
	WebElement shoppingCart;
	@FindBy(xpath="//*[@id='item_4_title_link']//following::button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement itembag;
	@FindBy(xpath="//*[@id='item_4_title_link']")
	WebElement chekinItemName;
	@FindBy(xpath="//*[@id='item_4_title_link']//following::button[@id='add-to-cart-sauce-labs-backpack']/preceding-sibling::div")
	WebElement itemAmount;
	
	
	
	
	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	

}
