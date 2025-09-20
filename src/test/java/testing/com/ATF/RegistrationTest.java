package testing.com.ATF;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;

import PageObjectMdel.HomePage;
import PageObjectMdel.RegistrationPage;
import Resources.BaseClass;
import Resources.CommonMethod;

public class RegistrationTest extends BaseClass{
	
	@Test
    public void verifyRegistration() throws IOException, InterruptedException
    {
		//initializeDriver();
    	//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		Thread.sleep(3000);
		HomePage hpo=new HomePage(driver);	
		CommonMethod.putExplicitWait(driver, 10, hpo.clickOnMyAccount());
		hpo.clickOnMyAccount().click();
		hpo.clickOnMyRegister().click();
		
    	RegistrationPage rop = new RegistrationPage(driver);
    	CommonMethod.putExplicitWait(driver, 10, rop.EnterFirstname());
    	rop.EnterFirstname().clear();
		rop.EnterFirstname().sendKeys("Neha");
		rop.EnterLastname().clear();
		rop.EnterLastname().sendKeys("Kolte");

		rop.EnterEmail().clear();
		String mailId=rop.generateRandomEmail();
		rop.EnterEmail().sendKeys(mailId);
		setProperty("Email", mailId);
		rop.EnterTelephone().sendKeys("2325555552");
		rop.EnterPassword().sendKeys("ABCD@123");
		rop.EnterPasswordConfirm().sendKeys("ABCD@123");
		rop.ClickOnSubscribe().click();
		rop.AcceptPrivacyPolicy().click();

		rop.ClickOnContinueButton().click();
		Thread.sleep(300);
		rop.validateSuccessMessage();
		String SuccessURL="https://naveenautomationlabs.com/opencart/index.php?route=account/success";
		CommonMethod.handleAsertions(SuccessURL, driver.getCurrentUrl());
		
    }
	@Test
	public void verifyRegistrationWithInvalidData() throws IOException, InterruptedException
	{
		//initializeDriver();
    	//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		Thread.sleep(3000);
		HomePage hpo=new HomePage(driver);		
		hpo.clickOnMyAccount().click();
		hpo.clickOnMyRegister().click();
		
    	RegistrationPage rop = new RegistrationPage(driver);
    	rop.EnterFirstname().clear();
		rop.EnterFirstname().sendKeys("test");
		rop.EnterLastname().clear();
		rop.EnterLastname().sendKeys("test");
		rop.EnterEmail().clear();
		rop.EnterEmail().sendKeys("test@gmail.com");

	}
	
	@Test
    public void verifyRegistrationWithBlankData() throws IOException, InterruptedException
    {
		//initializeDriver();
    	//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		Thread.sleep(3000);
		HomePage hpo=new HomePage(driver);		
		hpo.clickOnMyAccount().click();
		hpo.clickOnMyRegister().click();
		
    	RegistrationPage rop = new RegistrationPage(driver);
    	rop.EnterFirstname().clear();
		rop.EnterFirstname().sendKeys("");
		rop.EnterLastname().clear();
		rop.EnterLastname().sendKeys("");

		rop.EnterEmail().clear();
		rop.EnterEmail().sendKeys("");

		rop.EnterTelephone().sendKeys("");
		rop.EnterPassword().sendKeys("");
		rop.EnterPasswordConfirm().sendKeys("");
		rop.ClickOnSubscribe().click();
		rop.AcceptPrivacyPolicy().click();
		rop.ClickOnContinueButton().click();
		
		SoftAssert sa=new SoftAssert();
		String firstNameError="First Name must be between 1 and 32 characters!";
		String lastNameError="Last Name must be between 1 and 32 characters!";
		sa.assertEquals(rop.CaptureFirstNameErrorMsg(), firstNameError);
		sa.assertEquals(rop.CaptureLastNameErrorMsg(), lastNameError);
		sa.assertAll();
		
    }

}
