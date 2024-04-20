package com.bookcart.pagelayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bookcart.testbase.TestBase;

//github used in this project.....

public class LoginPage extends TestBase{
	
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath=" //span[text()='Register']") private WebElement register_btn;
	@FindBy(css="[placeholder=Username]") private WebElement username_txtbox;
	@FindBy(css="[placeholder=Password]") private WebElement password_txtbox;
	@FindBy(xpath="//span[text()='Login']")private WebElement login_btn;
	
	public RegisterPage clickOnRegisterButton()
	{
		register_btn.click();
		return new RegisterPage();
	}
	
	public LoginPage setUserName(String username)
	{
		username_txtbox.sendKeys(username);
		return this;
	}
	
	public LoginPage setPassword(String password)
	{
		password_txtbox.sendKeys(password);
		return this;
	}
	
	public HomePage clickOnLoginButton()
	{
		login_btn.click();
		return new HomePage();
	}

}
