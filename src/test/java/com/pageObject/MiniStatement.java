package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MiniStatement {

	WebDriver driver;
	public MiniStatement(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(linkText = "Mini Statement")
	WebElement miniStatementbtn;

	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[2]/input")
	WebElement acctno;

	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input[1]")
	WebElement acctsubmit;

	@FindBy(xpath="//*[@id=\"ministmt\"]")
	WebElement table;

	public void clickministm()
	{
		miniStatementbtn.click();
	}

	public void enterAccNum(String acctnum)
	{
		acctno.sendKeys(acctnum);
	}

	public void clickministmSubmit()
	{
		acctsubmit.click();
	}
}
