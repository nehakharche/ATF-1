package PageObjectMdel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.WrapperClass;

public class LoginPage {
	
	public WebDriver driver;
	public WrapperClass objWrapperClass=new WrapperClass();
	By email=By.cssSelector("input#input-email");
	By password=By.cssSelector("input#input-password");
	By login=By.xpath("//input[@value='Login']");
	By MyAccount=By.xpath("//h2[text()='My Account']");
	
	
	public LoginPage(WebDriver driver2) {
		this.driver=driver2;
	}
	public WebElement setEmail() {
		return driver.findElement(email);
	}
	public WebElement setPassword() {
		return driver.findElement(password);
	}
	public WebElement clickLogin() {
		return driver.findElement(login);
	}
	public void verifyLoginSuccessful()
	{
		boolean result = driver.findElement(MyAccount).isDisplayed();
		objWrapperClass.logResult(result, true,"Logined successfully");
	}
}
