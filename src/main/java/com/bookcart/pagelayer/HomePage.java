package com.bookcart.pagelayer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bookcart.testbase.TestBase;

public class HomePage extends TestBase {
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(xpath="//span[normalize-space()='Login']")private WebElement login_btn;
	@FindBy(xpath="//*[.='account_circle']/following-sibling::span/span")private WebElement profileUsername_txt;
	@FindBy(css="[type=search]")private WebElement search_txtbox;
	@FindBy(css="//span[normalize-space()='Add to Cart']") private WebElement addToCart_btn;
	@FindBy(css="a[href^='/books/details']>strong") private WebElement bookDetails_link;
	
	public LoginPage clickOnLoginButton()
	{
		login_btn.click();
		return new LoginPage();
	}
	public String getProfileUserName()
	{
		return profileUsername_txt.getText().trim();
	}
	
	public HomePage setSearchItem(String itemname)
	{
		search_txtbox.sendKeys(itemname,Keys.ARROW_DOWN,Keys.ENTER);
		return this;
	}
	
	public BookDetailsPage clickOnBookDetailsLink()
	{
		bookDetails_link.click();	
		return new BookDetailsPage();
	}
	public HomePage clickOnAddToCartButton()
	{
		addToCart_btn.click();
		return this;
	}
	

}
