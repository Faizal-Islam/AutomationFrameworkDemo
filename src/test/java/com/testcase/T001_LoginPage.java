package com.testcase;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
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


		if(driver.getPageSource().contains("Welcome To Manager's Page of Guru99 Bank"))
		{
			Assert.assertTrue(true);
			log.info("login successful");
		}
		else
		{
			log.info("login failed due to incorrect credentials");
			Assert.assertTrue(false);
		}
	}
}
