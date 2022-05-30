package data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JSONdataReader 
{
	public String fname, lname, email, pwd;
	public void JSONreader() throws IOException, ParseException
	{
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.json";
		File srcFile = new File(filePath);
			
		//JSON must have a parser to the file
		JSONParser parser = new JSONParser();		
		JSONArray jArray = (JSONArray)parser.parse(new FileReader(srcFile));
		
		//Looping on JSON File
		for(Object JSONObj : jArray)
		{
			JSONObject person = (JSONObject) JSONObj;
			fname = (String) person.get("FirstName");
			lname = (String) person.get("LastName");
			email = (String) person.get("email");
			pwd = (String) person.get("Password");
		}
		
		
	}
}
