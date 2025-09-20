package Resources;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class CommonMethod {
	
	public static void handleAsertions(String actualResult,String exectedResult)
	{
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actualResult, exectedResult);
		sa.assertAll();
	}
	 public static void putExplicitWait(WebDriver driver , int sec , WebElement element)
	 {
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		 wait.until(ExpectedConditions.elementToBeClickable(element));		 
	 }

}
