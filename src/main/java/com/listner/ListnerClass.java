package com.listner;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ExtentReport.ExtentReport;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.Base;
import utility.utility;

public class ListnerClass extends ExtentReport implements ITestListener
{
	public void onTestStart(ITestResult result) 
	{
		test=extent.createTest(result.getName());
	}
	
	public void onTestFailure(ITestResult result) 
	{
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"Test Fails",ExtentColor.RED));
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+" - Test Case Fail", ExtentColor.RED));
		
		try {
			String path = utility.screenShot(Base.driver, result.getName());
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"Test Case Passed",ExtentColor.GREEN));
		
		try {
			String path = utility.screenShot(driver, result.getName());
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"Test Case Skip",ExtentColor.YELLOW));
	}
	

}
