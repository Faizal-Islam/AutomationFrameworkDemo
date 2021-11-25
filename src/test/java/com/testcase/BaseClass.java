package com.testcase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.* ;

import com.aventstack.extentreports.utils.FileUtil;
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
		log.info("opening browser");
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

			System.setProperty("webdriver.ie.driver",rd.getIEPath());
			driver=new InternetExplorerDriver();
		}
		driver.get(rd.getURL());
		log.info("maximazing browser");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown()
	{
		log.info("quitting browser");
	//	driver.quit();
	}
	
	public void logout()
	{
		WebElement logout=driver.findElement(By.linkText("Log out"));
		logout.click();
	}
	
	public boolean isAlertPresent()
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	public void takeScreenshot() throws IOException
	{
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File path=new File("./Screenshots");
		FileUtils.copyFile(f, path);
		
	}
}
