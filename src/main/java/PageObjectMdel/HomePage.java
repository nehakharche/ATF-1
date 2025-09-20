package PageObjectMdel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public WebDriver driver;
	private By MyAccount=By.xpath("//i[@class='fa fa-user']");
	private By Register=By.xpath("//a[text()='Register']");
	private By Login=By.xpath("//a[text()='Login']");
	public HomePage(WebDriver driver2) {
		this.driver=driver2;
	}

	public WebElement clickOnMyAccount()
	{
		return driver.findElement(MyAccount);
	}
	
	public WebElement clickOnMyRegister()
	{
		return driver.findElement(Register);
	}
	
	public WebElement clickOnMyLogin()
	{
		return driver.findElement(Login);
	}

}
