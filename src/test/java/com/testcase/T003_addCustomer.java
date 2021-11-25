package com.testcase;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageObject.AddCustomer;
import com.pageObject.LoginPage;
import com.utilities.XLUtils;
import com.utilities.readConfig;

public class T003_addCustomer extends BaseClass
{
	AddCustomer addCust=new AddCustomer(driver);

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
	public String[] setData() throws IOException
	{
		String path="./src/test/java/com/testData/TestData.xlsx";
		int rowCount=XLUtils.getRowCount(path,"AddCustData"); //3
		int colCount=XLUtils.getCellCount(path,"AddCustData",1); //10
		String[] data=new String[10];

		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				data[j]=XLUtils.getCellData(path, "AddCustData",i,j); //1 0

			}
		}
		return data;
	}
}
