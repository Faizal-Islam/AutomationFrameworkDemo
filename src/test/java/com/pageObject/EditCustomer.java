package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomer {

	WebDriver driver;
	public EditCustomer(WebDriver edriver)
	{
		driver=edriver;
		PageFactory.initElements(edriver,this);
	}
	
	@FindBy(linkText ="Edit Customer")
	WebElement editCustomerLink;
	
	@FindBy(name="cusid")
	WebElement CustID;
	
	@FindBy(name="AccSubmit")
	WebElement submitbtn;
	
	@FindBy(name="city")
	WebElement EditCity;
	
	@FindBy(name="state")
	WebElement EditState;
	
	@FindBy(name="pinno")
	WebElement EditPincode;
	
	@FindBy(name="telephoneno")
	WebElement EditPhoneNo;
	
	@FindBy(name="emailid")
	WebElement EditEmail;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input[1]")
	WebElement submitEdit;
	
	public void clickEditCust()
	{
		editCustomerLink.click();
	}
	
	public void EnterEditCust(String CustId)
	{
		CustID.sendKeys(CustId);
	}
	
	public void clickCustSubmit()
	{
		submitbtn.click();
	}
	
	public void EnterEditCity(String Editcity)
	{
		EditCity.clear();
		EditCity.sendKeys(Editcity);
	}
	
	public void EnterEditState(String Editstate)
	{
		EditState.clear();
		EditState.sendKeys(Editstate);
	}
	
	public void EnterEditpin(String Editpin)
	{
		EditPincode.clear();
		EditPincode.sendKeys(Editpin);
	}
	public void EnterEditPhone(String Editphone)
	{
		EditPhoneNo.clear();
		EditPhoneNo.sendKeys(Editphone);
	}
	
	public void EnterEditemail(String editemail)
	{
		EditEmail.clear();
		EditEmail.sendKeys(editemail);
	}
	
	public void clickEditsubmit()
	{
		submitEdit.click();;
	}
}
