package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage 
{
	//1. Declaration of Variables
	
			@FindBy(id="userid") private WebElement UserID;
			
			@FindBy (id="password") private WebElement Password;
			
			@FindBy (xpath="//button[@type='submit']") private WebElement Login;
			
			@FindBy (xpath="//p[@class='error text-center']") private WebElement ErrorMsg;
			
			@FindBy (xpath="(//span[@class='su-message'])[1]") private WebElement ErrorMsg1;
			
			@FindBy (xpath="(//span[@class='su-message'])[2]") private WebElement ErrorMsg2;
			
			//2. Initialization of Variable
			
			public KiteLoginPage (WebDriver driver)
			{
				PageFactory.initElements(driver,this);
			}
			
			//3. Variable Usage Using Methods
			
			public void enterUserId(String userid)
			{
				UserID.sendKeys(userid);
			}
			
			public void enterPassword(String password)
			{
				Password.sendKeys(password);
			}
			
			public void clickOnLoginButton()
			{
				Login.click();
			}
			
			public String errorMsgAfterLoginButton()
			{
				String ActualErrorMsg=ErrorMsg.getText();
				return ActualErrorMsg;
			}
			
			public String errorMsgAfterUserIDTab()
			{
				String ActualErrorMsg = ErrorMsg1.getText();
				return ActualErrorMsg;
			}
			
			public String errorMsgAfterPasswordTab()
			{
				String ActualErrorMsg = ErrorMsg2.getText();
				return ActualErrorMsg;
			}

}
