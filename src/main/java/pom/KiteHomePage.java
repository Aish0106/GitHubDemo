package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage 
{
    @FindBy (xpath="//span[@class='user-id']") private WebElement UserID;
	
	@FindBy (xpath="//a[@target='_self']") private WebElement LogOutButton;
	
	
	
	public KiteHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public String UserIdValidation()
	{
		String ActualUserID=UserID.getText();
		return ActualUserID;
	}
	
	public void clickOnUserID()
	{
		UserID.click();
	}
	
	public void clickOnLogOutButton()
	{
		LogOutButton.click();
	}

}
