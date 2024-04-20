package com.bookcart.testbase;

import java.time.Duration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.bookcart.pagelayer.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.bookcart.utilities.ExtentReportGenerator;
import com.bookcart.utilities.ReadConfigFile;


public class TestBase {
	public static WebDriver driver;
	public static Logger logger;
	public ReadConfigFile read_config;
	public LoginPage login;
	public HomePage home;
	public RegisterPage register;
	public BookDetailsPage bookdetails;
	public ShoppingCartPage shoppingcart;
	
	public ExtentReports report = ExtentReportGenerator.getExtentReport();
	public ExtentTest eTest = null;
	@BeforeMethod
	public void setUp()
	{	
		String br="Chrome";
		if(br.equalsIgnoreCase("Chrome"))
		{
//			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("Firefox"))
		{
//			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("Edge"))
		{
//			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Please provide correct browser name");
		}
		
		logger=LogManager.getLogger("BookCart");
		read_config = new ReadConfigFile();
		
		driver.get(read_config.getApplicationUrl());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("Browser launches, url, maximize");
		driver.manage().window().maximize();
		driver.get(read_config.getApplicationUrl());
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//It not exist in Selenium Version-3.141.59
		
		//------------------- Object Creation ----------------------------
		login=new LoginPage();
		home=new HomePage();
		register=new RegisterPage();
		bookdetails=new BookDetailsPage();
		shoppingcart=new ShoppingCartPage();
		
		//------------------- Login Steps --------------------------------
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
