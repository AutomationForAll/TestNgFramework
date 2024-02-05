package webautomation.testng;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CommonPage {


	public String dataReaderFromPropertyFile(String key) throws IOException {
		String value;
		FileReader file = new FileReader(System.getProperty("user.dir")+"\\resources\\accepeteduserpassword.properties");
		Properties properties = new Properties();
		properties.load(file);
		value =properties.getProperty(key);
		return value;
	}

	

}
