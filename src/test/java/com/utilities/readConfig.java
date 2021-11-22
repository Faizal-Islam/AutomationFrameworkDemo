package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {
	
	Properties pro;
	
	public readConfig()
	{
		try {
			pro=new Properties();
			File file=new File("/AutomationFramework001/Configuration/config.properties");
			FileInputStream fis=new FileInputStream(file);
			pro.load(fis);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String getURL()
	{
		String url=pro.getProperty("URL");
		return url;
	}
	
	public String getUsername()
	{
		String uname=pro.getProperty("username");
		return uname;
	}
	
	public String getPassword()
	{
		String pass=pro.getProperty("password");
		return pass;
	}
	
	public String getChromePath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getIEPath()
	{
		String Iepath=pro.getProperty("iepath");
		return Iepath;
	}
	
	public String getFirefoxPath()
	{
		String firefoxPath=pro.getProperty("firefoxpath");
		return firefoxPath;
	}
}
