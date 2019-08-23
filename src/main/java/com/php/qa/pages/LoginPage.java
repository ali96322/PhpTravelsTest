package com.php.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.php.qa.base.TestBase;

public class LoginPage extends TestBase
{
	//Page Factory - OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement password;
	
	@FindBy(xpath="//button[@type=\"submit\" and text()=\"Login\"]")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[@class=\"btn btn-default br25 btn-block form-group\"]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[@alt='Login']")
	WebElement phpLogo; 
	
	//constructor:initializing the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	//Actions:
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validatephpLogo()
	{
		return phpLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
}
