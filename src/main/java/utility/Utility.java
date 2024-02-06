package utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Utility {

	public String dataReaderFromPropertyFile(String key) throws IOException {
		String value;
		FileReader file = new FileReader(
				System.getProperty("user.dir") + "\\resources\\accepeteduserpassword.properties");
		Properties properties = new Properties();
		properties.load(file);
		value = properties.getProperty(key);
		return value;
	}

	public  String[] jsonReader() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader file = new FileReader(System.getProperty("user.dir") + "\\data\\userdata.json");
		Object obj = jsonParser.parse(file);

		JSONObject jsonObject = (JSONObject) obj;
		JSONArray jsonArray = (JSONArray) jsonObject.get("userDetails");

		String arr[] = new String[jsonArray.size()];

		for (int i = 0; i <jsonArray.size(); i++) {

			JSONObject userdetails = (JSONObject) jsonArray.get(i);
			String firstname = (String) userdetails.get("firstName");
			String lastname = (String) userdetails.get("lastName");
			String zip = (String) userdetails.get("zip");
			
			arr[i]=firstname+","+lastname+","+zip;
			
		}
		return arr;
		
	}

}
