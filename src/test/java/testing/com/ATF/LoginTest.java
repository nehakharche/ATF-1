package testing.com.ATF;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import PageObjectMdel.HomePage;
import PageObjectMdel.LoginPage;
import Resources.BaseClass;

public class LoginTest extends BaseClass{
	
	@Test
	public void Login() throws IOException
	{
		//initializeDriver();
    	//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		HomePage hpo=new HomePage(driver);
		hpo.clickOnMyAccount().click();
		hpo.clickOnMyLogin().click();
    	LoginPage lop = new LoginPage(driver);
    	System.out.println("MAILID"+getProperty("Email"));
    	System.out.println("PASSWORD"+getProperty("Password"));
    	lop.setEmail().sendKeys(getProperty("Email"));
    	lop.setPassword().sendKeys(getProperty("Password"));
    	lop.clickLogin().click();
    	lop.verifyLoginSuccessful();
	}
}
