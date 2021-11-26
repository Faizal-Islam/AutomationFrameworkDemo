package com.testcase;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageObject.AddCustomer;
import com.pageObject.LoginPage;
import com.utilities.XLUtils;
import com.utilities.readConfig;

//Adding customer using EXCEL SHEET

public class T003_addCustomer extends BaseClass
{
	@Test(priority=0)
	public void login()
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

	@Test(dataProvider="setData",priority=1,dependsOnMethods = "login")
	public void addCustomer(String[] data)
	{		
		AddCustomer addCust=new AddCustomer(driver);
		addCust.clickAddCust();
		addCust.setCustName(data[0]);
		addCust.setCustGender(data[1]);
		addCust.setCustDOB(data[2]);
		addCust.setCustAddress(data[3]);
		addCust.setCustCity(data[4]);
		addCust.setCustState(data[5]);
		addCust.setCustPin(data[6]);
		addCust.setCustMobile(data[7]);
		addCust.setCustEmail(data[8]);
		addCust.setCustPassword(data[9]);
		addCust.clickSubmit();
	}

	@DataProvider
	public Object[][] setData() throws IOException
	{
		String path="./src/test/java/com/testData/TestData.xlsx";
		int rowCount=XLUtils.getRowCount(path,"AddCustData"); //3
		int colCount=XLUtils.getCellCount(path,"AddCustData",1); //10
		Object[][] data=new Object[rowCount][colCount];

		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				data[i-1][j]=XLUtils.getCellData(path, "AddCustData",i,j); //1 0 

			}
		}
		return data;
	}
}
