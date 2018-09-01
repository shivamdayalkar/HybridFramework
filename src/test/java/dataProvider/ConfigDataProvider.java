package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	public ConfigDataProvider()
	{
		File f = new File("C:\\AutomationProject\\workspace\\com.automation.hybrid\\Configuration\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(f);
		    pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is"+e.getMessage());
		}
	}
	public String getApplicationUrl()
	{
		String url = pro.getProperty("url");
		return url;
	}
	public String getChromePath()
	{ 
		String url = pro.getProperty("chromePath");
	    return url;
		
	}
}
