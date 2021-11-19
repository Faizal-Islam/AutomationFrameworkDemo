package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(name="uid")
	@CacheLookup
	WebElement username;

	@FindBy(name="password")
	@CacheLookup
	WebElement password;

	@FindBy(name="btnLogin")
	WebElement login_btn;
	
	public void login() {
		username.sendKeys("mngr367255");
		password.sendKeys("mevAgEs");
		login_btn.click();
	}

}
