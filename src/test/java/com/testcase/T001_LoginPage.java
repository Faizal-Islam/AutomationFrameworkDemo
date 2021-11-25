package com.testcase;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObject.LoginPage;
import com.utilities.readConfig;

public class T001_LoginPage extends BaseClass
{

	@Test
	public void login_test()
	{
		readConfig rd=new readConfig();
		LoginPage lp=new LoginPage(driver);
		log.info("Entering username");
		lp.enter_username(rd.getUsername());
		log.info("Entering password");
		lp.enter_password(rd.getPassword());
		log.info("Login on the website.");
		lp.login();


		if(isAlertPresent()==true)
		{
			log.info("Login Failed");
			driver.switchTo().alert().accept();
		}
		else
		{
			Assert.assertTrue(true);
			log.info("login successful");
			logout();
			driver.switchTo().alert().accept();	
		}
	}
}
