package com.testcase;

import org.testng.annotations.Test;

import com.pageObject.AddCustomer;
import com.pageObject.LoginPage;
import com.utilities.readConfig;

//Adding customer with hard coded data

public class T004_addCustomer extends BaseClass
{
	@Test
	public void LoginCust()
	{
		readConfig rd=new readConfig();
		LoginPage lp=new LoginPage(driver);
		log.info("Entering username");
		lp.enter_username(rd.getUsername());
		log.info("Entering password");
		lp.enter_password(rd.getPassword());
		log.info("Login on the website.");
		lp.login();
	}
	
	@Test
	public void addCust()
	{
		AddCustomer ad=new AddCustomer(driver);

		ad.clickAddCust();
		ad.setCustName("Ayan");
		ad.setCustGender("male");
	//	ad.setCustDOB("10","15","1985"); 
		ad.setCustAddress("RM NO 2918");
		ad.setCustCity("Mumbai");
		ad.setCustState("Maharashtra");
		ad.setCustPin("400001");
		ad.setCustMobile("897898765");
		ad.setCustEmail("Ayan@gmail.com");
		ad.setCustPassword("Ayan@123");
		ad.clickSubmit();
	}

}
