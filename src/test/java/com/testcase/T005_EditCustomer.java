package com.testcase;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageObject.EditCustomer;
import com.pageObject.LoginPage;
import com.utilities.XLUtils;
import com.utilities.readConfig;

public class T005_EditCustomer extends BaseClass
{
	@Test(priority = 1)
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
	
	@Test(dataProvider = "CustData",priority = 2,dependsOnMethods = "login")
	public void EditCust(String[] data)
	{
		EditCustomer ed=new EditCustomer(driver);
		ed.clickEditCust();
		ed.EnterEditCust(rd.getUserID());
		ed.clickCustSubmit();
		ed.EnterEditCity(data[0]);
		ed.EnterEditState(data[1]);
		ed.EnterEditpin(data[2]);
		ed.EnterEditPhone(data[3]);
		ed.EnterEditemail(data[4]);
		ed.clickEditsubmit();
		
	}
	
	@DataProvider
	public String[][] CustData() throws IOException
	{ 
		String path="./src/test/java/com/testData/EditCustomerData.xlsx";
		int rowCnt=XLUtils.getRowCount(path, "EditCustData");
		int cellCnt=XLUtils.getCellCount(path, "EditCustData", 1);
		String data[][]=new String[rowCnt][cellCnt];
		for(int i=1;i<=rowCnt;i++)
		{
			for(int j=0;j<cellCnt;j++)
			{
				data[i-1][j]=XLUtils.getCellData(path, "EditCustData", i, j);
			}
		}
		return data;
	}
}
