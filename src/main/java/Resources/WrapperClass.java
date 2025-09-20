package Resources;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class WrapperClass {
	
	public WebDriver driver;
	public void logResult(String actual, String expected)
	{
		Assert.assertEquals(actual, expected);
	}
	public void logResult(boolean actual, boolean expected,String message)
	{  	
		Assert.assertEquals(actual, expected, message);
	}
	public void logResult(String actual, String expected,String message) {
		// TODO Auto-generated method stub
		Assert.assertEquals(message,actual,expected);
	}

	public HashMap<String, String> loadData() throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Neha Kolte\\eclipse-workspace\\SWT\\TestData\\AutomationTestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		Row row=sheet.getRow(1);
		return null;
		
	}
}
