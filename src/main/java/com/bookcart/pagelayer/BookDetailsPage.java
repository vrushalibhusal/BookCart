package com.bookcart.pagelayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bookcart.testbase.TestBase;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class BookDetailsPage extends TestBase{
	
	public BookDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="table.table-lg tr:first-child td:last-child")private WebElement title_txt;
	@FindBy(css="table.table-lg tr:nth-child(2) td:last-child")private WebElement author_txt;
	@FindBy(css="table.table-lg tr:nth-child(3) td:last-child")private WebElement category_txt;
	@FindBy(css="table.table-lg tr:last-child td:last-child")private WebElement price_txt;
	@FindBy(css="table.table-lg+div span.mdc-button__label")private WebElement addToCart_btn;
	@FindBy(css="div.mdc-snackbar__label")private WebElement itemAddedValidation_txt;
	@FindBy(css="[ng-reflect-router-link='/shopping-cart']")private WebElement cartIcon_btn;
	
	public String getTitleOfBookText()
	{
		return title_txt.getText();
	}
	
	public String getAuthorNameOfBook()
	{
		return author_txt.getText();
	}
	
	public String getCategoryOfBook()
	{
		return category_txt.getText();
	}
	
	public String getPriceOfBook()
	{
		return price_txt.getText();
	}
	
	public BookDetailsPage clickOnAddToCartButton()
	{
		addToCart_btn.click();
		return this;
	}
	
	public String getItemAddedValidationText()
	{
	return itemAddedValidation_txt.getText().trim();    //One Item added to cart	
	}
	
	public ShoppingCartPage clickOnCartIconButton()
	{
		cartIcon_btn.click();
		return new ShoppingCartPage();
	}
}
