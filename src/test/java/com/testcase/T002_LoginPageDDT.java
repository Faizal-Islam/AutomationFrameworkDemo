package com.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageObject.LoginPage;
import com.utilities.XLUtils;
import com.utilities.readConfig;

public class T002_LoginPageDDT extends BaseClass 
{

	XLUtils xlutil=new XLUtils();

	@Test(dataProvider="loginData")
	public void loginDDTtest(String uname,String pass)
	{
		readConfig rd=new readConfig();
		LoginPage lp=new LoginPage(driver);
		log.info("Entering username");
		lp.enter_username(uname);
		log.info("Entering password");
		lp.enter_password(pass);
		log.info("Login on the website.");
		lp.login();

		if(isAlertPresent()==true)
		{
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

	@DataProvider()
	public String[][] loginData() throws IOException
	{
		String path="./src/test/java/com/testData/LoginData.xlsx";
		int rowNum=xlutil.getRowCount(path,"Sheet1");
		int cellNum=xlutil.getCellCount(path,"Sheet1",2);
		String loginData[][]=new String[rowNum][cellNum];

		for(int i=1;i<=rowNum;i++)
		{
			for(int j=0;j<cellNum;j++)
			{
				loginData[i-1][j]=xlutil.getCellData(path, "Sheet1",i, j);
			}
		}

		return loginData;
	}
}
