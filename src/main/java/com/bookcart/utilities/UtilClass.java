package com.bookcart.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.bookcart.testbase.TestBase;



public class UtilClass extends TestBase{
	
	public UtilClass()
	{
		PageFactory.initElements(driver, this);
	}

	public void acceptAlertPopup()
	{
		driver.switchTo().alert().accept();
	}
	
	public static void takeSS(String filename) 
	{
		String path = "./screenshots/";
		String timestamp = new SimpleDateFormat("dd/mm/yyyy-hh:mm:ss a").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(path + filename+".png");
		try 
		{
			FileHandler.copy(src, des);
		} 
		catch (IOException e) 
		{
			System.out.println("File not found");
			e.printStackTrace();
		}
	}
	public static String takeScreenshot(String testName,WebDriver driver) {
		
		File sourceScreenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationScreenshotFile = new File(System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png");
		try {
			FileUtils.copyFile(sourceScreenshotFile, destinationScreenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return destinationScreenshotFile.getAbsolutePath();
	
	}
}
