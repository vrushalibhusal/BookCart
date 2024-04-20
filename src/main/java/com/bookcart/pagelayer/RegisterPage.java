package com.bookcart.pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bookcart.testbase.TestBase;

public class RegisterPage extends TestBase {
	
	public RegisterPage() {
		
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder='First name']")private WebElement firstname_txtbox;
	@FindBy(css="[placeholder='Last Name']")private WebElement lastname_txtbox;
	@FindBy(css="[placeholder='User name']")private WebElement username_txtbox;
	@FindBy(css="[type=password][placeholder=Password]")private WebElement password_txtbox;
	@FindBy(css="[type=password][placeholder='Confirm Password']")private WebElement confirmpwd_txtbox;
	@FindBy(xpath="//span[text()='Register']")private WebElement register_btn;
	
	
	public RegisterPage setFirstName(String firstname)
	{
		firstname_txtbox.sendKeys(firstname);
		return this;
	}
	
	public RegisterPage setLastName(String lastname)
	{
		lastname_txtbox.sendKeys(lastname);
		return this;
	}
	
	public RegisterPage setUserName(String username)
	{
		username_txtbox.sendKeys(username);
		return this;
	}
	
	public RegisterPage setPassword(String password)
	{
		password_txtbox.sendKeys(password);
		return this;
	}
	
	public RegisterPage setConfirmPassword(String confirmpassword)
	{
		confirmpwd_txtbox.sendKeys(confirmpassword);
		return this;
	}

	public RegisterPage selectGender(String gender)
	{
		driver.findElement(By.cssSelector("[type=radio][value="+gender+"]")).click();
		return this;
	}
	
	public LoginPage clickOnRegisterButton()
	{
		register_btn.click();
		return new LoginPage();
	}

}
