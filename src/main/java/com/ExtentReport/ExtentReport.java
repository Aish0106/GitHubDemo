package com.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utility.utility;

import base.Base;

public class ExtentReport extends Base
{
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent()
	{
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"myReport_"+utility.getCurrentTime()+".html");
		htmlReporter.config().setDocumentTitle("Automation Report"); //Title of the report
		htmlReporter.config().setReportName("Functional Report");// Name of report
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "Local Host");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Tester Name", "Sohil Cherkulwar");
	}
	public static void endReport()
	{
		extent.flush();
	}
}
   