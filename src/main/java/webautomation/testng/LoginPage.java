package webautomation.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	@FindBy(id = "login-button")
	WebElement signInBtn;
	@FindBy(id = "user-name")
	WebElement userName;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(className = "login_logo")
	WebElement logo;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void loginBtnClick() {
		signInBtn.click();

	}

	public String getLogoText() {
		String txt = logo.getText();
		return txt;
	}
	
	

}
