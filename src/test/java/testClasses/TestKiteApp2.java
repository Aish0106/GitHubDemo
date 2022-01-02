package testClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pom.KiteHomePage;
import pom.KiteLoginPage;
import pom.KitePinPage;
import utility.utility;

public class TestKiteApp2 extends Base{
	KiteLoginPage login;
	KitePinPage pin;
	KiteHomePage home;
	@BeforeClass
	public void browserLaunch() throws InterruptedException
	{
		browserSetup();
		
		login=new KiteLoginPage(driver);
		pin=new KitePinPage(driver);
		home=new KiteHomePage(driver);
	}
	
	@BeforeMethod
	public void kiteLogin() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log("Login to kite", true);
		login.clickOnLoginButton();
	}
	
  @Test
  public void validationOfErrorMsgAfterPassTab() throws EncryptedDocumentException, IOException, InterruptedException 
  {  
	  String ActualErrorMsgAfterPassTab = login.errorMsgAfterPasswordTab();  
	  String ExpectedErrorMsgAfterPassTab = utility.getDataFromExcel(2, 3); //Intentionally failing TC
	  Assert.assertEquals(ActualErrorMsgAfterPassTab, ExpectedErrorMsgAfterPassTab, "Actual Error Msg After User ID Tab do not match Expected Error Msg After User ID Tab Test Case is failed");
	  Reporter.log("Test Case is passed", true);
  }
  
  
  @AfterClass
  public void closeBrowser()
  {
	  Reporter.log("closing Browser", true);
	  driver.close();
  }
}
