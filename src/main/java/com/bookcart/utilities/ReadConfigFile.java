package com.bookcart.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {
	
	Properties pro;
	
	public ReadConfigFile()
	{
		String path = ".\\src\\test\\resources\\configs\\Config.properties";
		try 
		{
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			pro = new Properties();
			pro.load(fis);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public String getApplicationUrl()
	{
		String url = pro.getProperty("url");
		return url;
	}
	
	public String getUsername()
	{
		return pro.getProperty("username");
	}
	
	public String getPassword()
	{
		return pro.getProperty("password");
	}

}
