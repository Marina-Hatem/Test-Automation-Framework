package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//This class loads the data file

public class LoadProperties
{
	//Load the properties file
	public static Properties userData = loadProperties(System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.properties/");

	public static Properties loadProperties(String path)
	{
		Properties pro = new Properties();
		//stream for reading the file
		try 
			{
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
			} 
		
		catch (FileNotFoundException e) 
			{
				System.out.println("Error occurred: " + e.getMessage());
			}
		catch (IOException e) 
			{
				System.out.println("Error occurred: " + e.getMessage());
			}		
		return pro;
	}
	
}
