package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomer {

	WebDriver driver;
	public AddCustomer(WebDriver sdriver)
	{
		driver=sdriver;
		PageFactory.initElements(sdriver,this);
	}

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
	WebElement NewCust;

	@FindBy(name="name")
	WebElement CustName;

	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
	WebElement CustGender;

	@FindBy(name="dob")
	WebElement CustDOB;

	@FindBy(name="addr")
	WebElement CustAddress;

	@FindBy(name="city")
	WebElement CustCity;

	@FindBy(name="state")
	WebElement CustState;

	@FindBy(name="pinno")
	WebElement CustPincode;

	@FindBy(name="telephoneno")
	WebElement CustMobile;

	@FindBy(name="emailid")
	WebElement CustEmail;

	@FindBy(name="password")
	WebElement CustPassword;

	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[1]")
	WebElement CustSubmit;

	public void clickAddCust()
	{
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).click();
	}

	public void setCustName(String cname)
	{
		CustName.sendKeys(cname);
	}

	public void setCustGender(String value) 
	{
		Select s=new Select(CustGender);
		s.selectByValue(value);
	}

	public void setCustDOB(String cDOB)
	{
		CustDOB.sendKeys(cDOB);
	}

	public void setCustAddress(String cAddr)
	{
		CustAddress.sendKeys(cAddr);
	}

	public void setCustCity(String cCity)
	{
		CustCity.sendKeys(cCity);
	}

	public void setCustState(String cState)
	{
		CustState.sendKeys(cState);
	}

	public void setCustPin(String cPin)
	{
		CustPincode.sendKeys(cPin);
	}

	public void setCustMobile(String cMob)
	{
		CustMobile.sendKeys(cMob);
	}

	public void setCustEmail(String cEmail)
	{
		CustEmail.sendKeys(cEmail);
	}

	public void setCustPassword(String cPass)
	{
		CustPassword.sendKeys(cPass);
	}

	public void clickSubmit()
	{
		CustSubmit.click();
	}
}
