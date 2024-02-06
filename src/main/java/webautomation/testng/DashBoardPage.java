package webautomation.testng;

import org.openqa.selenium.By;
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
	WebElement itembag;
	@FindBy(xpath="//*[@id='item_4_title_link']")
	WebElement chekinItemName;
	WebElement itemAmount;
	@FindBy(id="logout_sidebar_link")
	WebElement logout;
	
	
	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public WebElement fetchItemAmount(String itemName) {
		
		itemAmount=driver.findElement(By.xpath("//*[text()='"+itemName+"']//ancestor::div[contains(@class,'inventory_item_description')]//child::div[contains(@class,'inventory_item_price')]"));
		
		return itemAmount;
	}
	
	public WebElement  clickOnItem(String itemName) {
		
		WebElement itembag =driver.findElement(By.xpath("//*[text()='"+itemName+"']//ancestor::div[contains(@class,'inventory_item_description')]//child::button[@id='add-to-cart-sauce-labs-backpack']"));
		
		return itembag;
	}
}
