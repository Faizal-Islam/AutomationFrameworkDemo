package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.readConfig;

public class LoginPage
{

	WebDriver driver;
	public LoginPage(WebDriver rdriver) 
	{
		driver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(xpath="/html/body/form/table/tbody/tr[1]/td[2]/input")
	@CacheLookup
	WebElement username;

	@FindBy(xpath="/html/body/form/table/tbody/tr[2]/td[2]/input")
	@CacheLookup
	WebElement password;

	@FindBy(xpath="/html/body/form/table/tbody/tr[3]/td[2]/input[1]")
	WebElement login_btn;

	public void enter_username(String uname) {
		username.sendKeys(uname);

	}
	public void enter_password(String pass) {
		password.sendKeys(pass);

	}
	public void login() {
		login_btn.click();
	}

}
