  package com.testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.pageObject.LoginPage;
import com.pageObject.MiniStatement;
import com.utilities.readConfig;

public class T006_MiniStatement extends BaseClass{

	@Test
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
	
	@Test
	public void miniStm()
	{
		MiniStatement mini=new MiniStatement(driver);
		mini.clickministm();
		mini.enterAccNum("101451");
		mini.clickministmSubmit();
		int row=driver.findElements(By.xpath("//*[@id=\"ministmt\"]/tbody/tr[1]")).size();
		int col= driver.findElements(By.xpath("//*[@id=\"ministmt\"]/tbody/tr[1]/th[1]")).size();
		
		for(int i=1;i<=row;i++)
		{
			for(int j=1;j<=0;j++)
			{
				System.out.print(driver.findElement(By.xpath("//*[@id=\"ministmt\"]/tbody/tr[i]/td[j]")).getText() + "|");
			}
			System.out.println();
		}
	}
}
