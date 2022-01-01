package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KitePinPage 
{
	 @FindBy (xpath="//input[@type='password']") private WebElement Pin;
		
		@FindBy (xpath="//button[@type='submit']") private WebElement SubmitButton;
		
		public KitePinPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		public void enterPin(String pin)
		{
			Pin.sendKeys(pin);
		}
		
		public void clickOnSubmitButton()
		{
			SubmitButton.click();
		}

}
