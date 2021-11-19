package com.testcase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.* ;

import com.google.j2objc.annotations.Property;

public class BaseClass {

	public static Logger log;
	@BeforeClass
	public void setup(String browser)
	{
	log=Logger.getLogger("InetBanking");
	PropertyConfigurator.configure("log4j.properties");
	
	if(browser.equalsIgnoreCase("chrome"))
	{
	System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");	
	WebDriver driver=new ChromeDriver();
	}
	
	else if(browser.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver","./Drivers\\geckodriver.exe");	
				WebDriver driver=new FirefoxDriver();
	}
	
	else if(browser.equalsIgnoreCase("IE"))
	{
		System.setProperty("webdriver.IE.driver","./Drivers\\IEDriverServer.exe");
				WebDriver driver=new InternetExplorerDriver();
	}
	}
	
	@AfterClass
	public void tearDown()
	{
		
	}
}
