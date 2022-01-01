package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class utility 
{
	public static String getDataFromExcel(int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream MyFile = new FileInputStream("F:\\Velocity\\Selenium\\Excel\\Test.xlsx");
		   Sheet MySheet = WorkbookFactory.create(MyFile).getSheet("Sheet4");
		   String value=MySheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		   return value;
	}
	public static void captureScreenShot(WebDriver driver,int TCID) throws IOException
	{
		File Source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("F:\\Velocity\\Selenium\\SS\\TestID"+TCID+".png");
		FileHandler.copy(Source, Dest);	
	}
	public static String screenShot(WebDriver driver,String name) throws IOException
	{
		File Source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		String dest= System.getProperty("user.dir")+"\\ScreenShot\\"+name+"_"+getCurrentTime()+".png";
		File fileDest=new File(dest);
		FileUtils.copyFile(Source, fileDest);
		return dest;
	}
	
	public static String getCurrentTime()
	{
		String currentDate=new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}
}
