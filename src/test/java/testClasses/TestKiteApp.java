package testClasses;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pom.KiteHomePage;
import pom.KiteLoginPage;
import pom.KitePinPage;
import utility.utility;

public class TestKiteApp extends Base 
{
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
		login.enterUserId(utility.getDataFromExcel(0, 0));
		login.enterPassword(utility.getDataFromExcel(0, 1));
		login.clickOnLoginButton();
		Reporter.log("Entering pin", true);
		pin.enterPin(utility.getDataFromExcel(0, 2));
		pin.clickOnSubmitButton();
		
	}
	
  @Test
  public void validationOfUserID() throws EncryptedDocumentException, IOException, InterruptedException 
  {  
	  String ActualUserID = home.UserIdValidation();  
	  String ExpectedUserID = utility.getDataFromExcel(0, 0);
	  Assert.assertEquals(ActualUserID, ExpectedUserID, "Actual User Id do not match Expected User ID Test Case is failed");
	  Reporter.log("Test Case is passed", true);
  }
  
  
  @AfterMethod
  public void kiteLogout()
  {
	  Reporter.log("Log Out from Kite", true);
	  home.clickOnUserID();
	  home.clickOnLogOutButton();
  }
  
  @AfterClass
  public void closeBrowser()
  {
	  Reporter.log("closing Browser", true);
	  driver.close();
  }
}
