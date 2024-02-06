package webautomation.testng;

import java.time.Duration;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

	public static WebDriver driver;
	static final int waitTime=3;

	public static WebDriver initDriver(String inputBrowser) {
		
		switch (inputBrowser) {
		case "chrome":
			driver = WebDriverManager.chromedriver().create();
			return driverSetup(driver);

		case "firefox":
			driver = WebDriverManager.firefoxdriver().create();
			return driverSetup(driver);
		default:
			driver = WebDriverManager.chromedriver().create();
			return driverSetup(driver);
		}
	}

	public static WebDriver driverSetup(WebDriver driver) {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
		return driver;

	}

}

