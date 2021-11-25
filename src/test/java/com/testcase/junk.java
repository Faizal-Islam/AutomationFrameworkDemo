package com.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class junk 
{
	
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver","./Drivers\\\\chromedriver.exe");	
		WebDriver driver=new ChromeDriver();	
		driver.get("http://demo.guru99.com/v4/manager/Managerhomepage.php");
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).click();;
	}
	
}
