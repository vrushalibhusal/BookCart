package com.bookcart.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportGenerator {
	
	public static String timestamp = new SimpleDateFormat("dd-MM-yyyy-HH.mm.ss").format(new Date());
	
	public static String reportPath = "ExtentReports/eReport-"+timestamp+".html";
	
	public static ExtentReports getExtentReport(){
		
		ExtentReports report = new ExtentReports();
		
		File extentReportFile = new File(reportPath);
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		try {
			sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"\\src\\test\\resources\\extent-report-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		report.attachReporter(sparkReporter);
		
		return report;
		
	}

}
