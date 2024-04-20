package com.bookcart.testlayer;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bookcart.testbase.TestBase;
import com.bookcart.utilities.ReadExcelData;

public class BookCartPriceTest extends TestBase{
	
	DecimalFormat decfor = new DecimalFormat("0.00");
	
	@DataProvider
	public Object[][] getTotalCartPriceTest() throws Exception
	{
		return ReadExcelData.excelTestData("TotalCartPriceTest");
	}
	
	@DataProvider
	public Object[][] getModifyCartTest() throws Exception
	{
		return ReadExcelData.excelTestData("ModifyCartTest");
	}
	@Test(dataProvider = "getTotalCartPriceTest",priority = 1)
	public void verifyTotalCartPriceTest( String searchitem1,String searchitem2,String searchitem3,String searchitem4,String searchitem5,String numberOfProducts,
			String expectedItemAddedValidationText) throws InterruptedException
	{
		String[] searchitems= {searchitem1,searchitem2,searchitem3,searchitem4,searchitem5};
	 String actualUsername=home.clickOnLoginButton().setUserName(read_config.getUsername()).setPassword(read_config.getPassword()).clickOnLoginButton().getProfileUserName();
	 Assert.assertEquals(actualUsername, read_config.getUsername().toLowerCase());
	 Thread.sleep(2000);
	 for(int a=0;a<searchitems.length;a++)
	 {
	 String titleofbook=home.setSearchItem(searchitems[a]).clickOnBookDetailsLink().getTitleOfBookText();
	 logger.info("Title Of Book : "+titleofbook );
	 String authorofbook=bookdetails.getAuthorNameOfBook();
	 logger.info("Author Of Book : "+authorofbook );
	 String category=bookdetails.getCategoryOfBook();
	 logger.info("Category Of Book : "+category );
	 String price=bookdetails.getPriceOfBook();
	 logger.info("Price Of Book : "+price );
	 Thread.sleep(2000);
	 for(int k=0;k<Integer.parseInt(numberOfProducts);k++)
	 {
		 bookdetails.clickOnAddToCartButton();
		 logger.info("Book Added in to cart" );
		 Thread.sleep(700);
		 String actualItemAddedValidationText=bookdetails.getItemAddedValidationText();
		 Assert.assertEquals(actualItemAddedValidationText, expectedItemAddedValidationText);
	 }
	}
	 Thread.sleep(2000);
	 List<String> TotalPricesText= bookdetails.clickOnCartIconButton().getTotalPricesText();
	 double TotalPrices = 0;
	 for(int l=0; l<TotalPricesText.size(); l++) {
		 TotalPrices+=Double.parseDouble(TotalPricesText.get(l).replace(",",""));
	 }
	 String sumOfTotalPricesText = decfor.format(TotalPrices);
	 
	 logger.info("Sum of Total Prices : "+sumOfTotalPricesText);
	 
	 Assert.assertEquals(shoppingcart.getCartTotal(), sumOfTotalPricesText);
			 
	 Thread.sleep(2000);
	 
	 shoppingcart.clickOnClearCartButton();
	 logger.info("cart is clear");
	 
		
	}
	@Test(dataProvider = "getModifyCartTest",priority = 2)
	public void verifyModifyCartTest(String searchitem1,String searchitem2,String searchitem3,String searchitem4,String searchitem5,String numberOfProducts,
			String expectedItemAddedValidationText) throws InterruptedException
	{
		 String[] searchitems= {searchitem1,searchitem2,searchitem3,searchitem4,searchitem5};
		 String actualUsername=home.clickOnLoginButton().setUserName(read_config.getUsername()).setPassword(read_config.getPassword()).clickOnLoginButton().getProfileUserName();
		 Assert.assertEquals(actualUsername, read_config.getUsername().toLowerCase());
		 Thread.sleep(2000);
		 for(int a=0;a<searchitems.length;a++)
		 {
		 String titleofbook=home.setSearchItem(searchitems[a]).clickOnBookDetailsLink().getTitleOfBookText();
		 logger.info("Title Of Book : "+titleofbook );
		 String authorofbook=bookdetails.getAuthorNameOfBook();
		 logger.info("Author Of Book : "+authorofbook );
		 String category=bookdetails.getCategoryOfBook();
		 logger.info("Category Of Book : "+category );
		 String price=bookdetails.getPriceOfBook();
		 logger.info("Price Of Book : "+price );
		 Thread.sleep(2000);
		 for(int k=0;k<Integer.parseInt(numberOfProducts);k++)
		 {
			 bookdetails.clickOnAddToCartButton();
			 logger.info("Book Added in to cart" );
			 Thread.sleep(700);
			 String actualItemAddedValidationText=bookdetails.getItemAddedValidationText();
			 Assert.assertEquals(actualItemAddedValidationText, expectedItemAddedValidationText);
		 }
		}
		 Thread.sleep(2000);
		 List<String> TotalPricesText= bookdetails.clickOnCartIconButton().getTotalPricesText();
		 List<String> PricesOfBookS=shoppingcart.getPriceOfAddedBooksText();
		 List<String> quantiyOfBooks=shoppingcart.getQuantityOfItemText();
		 for(int m=0;m<PricesOfBookS.size();m++)
		 {
			 Assert.assertEquals(Double.parseDouble(PricesOfBookS.get(m))* Double.parseDouble(quantiyOfBooks.get(m)),Double.parseDouble(TotalPricesText.get(m)));
		 }
		 Thread.sleep(2000);	
		 
		shoppingcart.clickOnAddQuantityButton();
		 
		 Thread.sleep(2000);
		 
		 shoppingcart.clickOnClearCartButton();
		 logger.info("cart is clear");
		 

	}

}
