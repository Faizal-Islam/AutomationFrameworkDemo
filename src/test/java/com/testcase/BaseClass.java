package com.testcase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.* ;

import com.google.j2objc.annotations.Property;
import com.utilities.readConfig;

public class BaseClass {

	readConfig rd=new readConfig();
	public static Logger log;
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser)
	{
		log=Logger.getLogger("Guru99Bank");
		PropertyConfigurator.configure("log4j.properties");

		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",rd.getChromePath());	
			 driver=new ChromeDriver();
		}

		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",rd.getFirefoxPath());	
			 driver=new FirefoxDriver();
		}

		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.IE.driver",rd.getIEPath());
			 driver=new InternetExplorerDriver();
		}
	}

	@AfterClass
	public void tearDown()
	{

	}
}
