package com.bookcart.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.internal.MethodHelper;

import com.aventstack.extentreports.Status;
import com.bookcart.testbase.TestBase;

import net.bytebuddy.implementation.auxiliary.MethodCallProxy;

public class ListenerSetup extends TestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		Capabilities capabilities = ((RemoteWebDriver)driver).getCapabilities();
		eTest = report.createTest(testName);
		eTest.assignAuthor(System.getProperty("user.name"));
		eTest.assignDevice(capabilities.getBrowserName()+"-"+capabilities.getBrowserVersion().substring(0,capabilities.getBrowserVersion().indexOf(".")));
		
		report.setSystemInfo("Browser Name : ", capabilities.getBrowserName());
		report.setSystemInfo("Browser Version : ", capabilities.getBrowserVersion());
		System.getProperties().list(System.out);
		report.setSystemInfo("Operating Version : ", System.getProperty("os.name"));
		report.setSystemInfo("Java Version : ", System.getProperty("java.version"));
		eTest.log(Status.INFO,testName+" execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test case execution completed - "+result.getName());
		String testName = result.getName();
		eTest.log(Status.PASS,testName+" got successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Test case execution failed - "+result.getName());
		String timestamp = new SimpleDateFormat("dd-MM-yyyy hh.mm.ss a").format(new Date());
		UtilClass.takeSS(result.getName()+"-"+timestamp);
		logger.info("Take Screenshot");
		String testName = result.getName();
		eTest.log(Status.FAIL,testName+" got failed");
		
		eTest.addScreenCaptureFromPath(UtilClass.takeScreenshot(testName,driver),testName);
		eTest.log(Status.INFO,result.getThrowable());
		UtilClass.takeSS("FirstPic");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Test case execution skipped - "+result.getName());
		String testName = result.getName();
		eTest.log(Status.SKIP,testName+" got skipped");
		eTest.log(Status.INFO,result.getThrowable());
	}

	//-0--------------------------------------------------------------------------
	

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
		File eReportFile = new File(ExtentReportGenerator.reportPath);
		
		try {
			Desktop.getDesktop().browse(eReportFile.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
