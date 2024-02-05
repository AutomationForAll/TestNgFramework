package webautomation.testng;

import java.time.Duration;
import org.openqa.selenium.WebDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

	public static WebDriver driver;
	
	public static WebDriver initDriver(String inputBrowser) {

		switch (inputBrowser) {
		case "chrome":
			driver = WebDriverManager.chromedriver().create();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			// driver.get("https://www.amazon.in/");
			return driver;
			
		case "firefox":
			driver = WebDriverManager.firefoxdriver().create();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			// driver.get("https://www.amazon.in/");
			return driver;

		default:
			driver = WebDriverManager.chromedriver().create();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			// driver.get("https://www.amazon.in/");
			return driver;
		}
	}

}
