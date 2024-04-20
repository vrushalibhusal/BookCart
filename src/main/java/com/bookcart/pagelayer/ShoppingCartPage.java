package com.bookcart.pagelayer;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bookcart.testbase.TestBase;

public class ShoppingCartPage extends TestBase {
	
	public ShoppingCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="table[role=table]>tbody>tr>td:nth-child(5)")private List<WebElement> totalPrices_txt;
	@FindBy(xpath="//strong[starts-with(.,'Cart Total')]/../following-sibling::td/strong")private WebElement cartTotal_txt;
	@FindBy(xpath="//button[.='add_circle']")private List<WebElement> addquantity_btn;
	@FindBy(css="tbody[role=rowgroup]>tr>td:nth-child(4)>div>div:nth-child(2)")private List<WebElement> quantity_txt;
	@FindBy(xpath="//table[@role='table']//td[3]")private List<WebElement> priceOfAddedBooks_text;
	@FindBy(xpath="//span[normalize-space()='Clear cart']")private WebElement clearCart_btn;
	public List<String> getTotalPricesText()
	{
		List<String> TotalPricesText= new ArrayList<>(); //₹705.00
		for(int i=0;i<totalPrices_txt.size();i++)
		{
			System.out.println(totalPrices_txt.get(i).getText());
			TotalPricesText.add(totalPrices_txt.get(i).getText().trim().substring(totalPrices_txt.get(i).getText().trim().indexOf("₹")+1).replace(",",""));
		}
		return TotalPricesText;
	}
	
	public String getCartTotal()
	{
		return cartTotal_txt.getText().trim().substring(cartTotal_txt.getText().trim().indexOf("₹")+1).replace(",","");
	}
	
	public void clickOnAddQuantityButton() throws InterruptedException
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		for(int x=0;x<addquantity_btn.size();x++)
		{
			js.executeScript("arguments[0].scrollIntoView(false)",addquantity_btn.get(x));
			Thread.sleep(2000);
			addquantity_btn.get(x).click();
		}
	}
	public List<String> getQuantityOfItemText()
	{
		List<String> QuantityOfItemText =new ArrayList<>();
		for(int y=0;y<quantity_txt.size();y++)
		{
			QuantityOfItemText.add(quantity_txt.get(y).getText());
		}
		
		return QuantityOfItemText;
	}
	 
	public List<String> getPriceOfAddedBooksText()   // ₹235.00 
	{
		List<String> PriceOfAddedBooksText =new ArrayList<>();
		for(int z=0;z<priceOfAddedBooks_text.size();z++)
		{
			PriceOfAddedBooksText.add(priceOfAddedBooks_text.get(z).getText().trim().substring(priceOfAddedBooks_text.get(z).getText().trim().indexOf("₹")+1).replace(",",""));
		}
		return PriceOfAddedBooksText;
	}
	
	public void clickOnClearCartButton() throws InterruptedException
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(false)",clearCart_btn);
		Thread.sleep(2000);
		clearCart_btn.click();
	}

}
