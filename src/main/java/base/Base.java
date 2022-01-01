package base;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.ExtentReport.ExtentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Base
{
	protected static WebDriver driver;
	//in base class we setup browser
	public void browserSetup() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Velocity\\Selenium\\Chrome Driver\\Chrome Drive exe\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--disable-notifications");
		driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://kite.zerodha.com/");
	}
	
	//Extent Report 
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void beforeTest()
	{
		ExtentReport.setExtent();
	}
	
	@AfterTest
	public void AfterTest()
	{
		ExtentReport.endReport();
	}
	
}
