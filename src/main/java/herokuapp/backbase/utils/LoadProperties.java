package herokuapp.backbase.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	
	/**
	 * load the properties
	 * 
	 * @return the properties
	 */
	public  Properties loadProperties(String sconfigName) throws IOException
	{
		Properties properties = new Properties();
		FileInputStream Locator = new FileInputStream(System.getProperty("user.dir")+"/Configs/"+sconfigName+".properties");				
		properties.load(Locator);
		return properties;
	}
}
