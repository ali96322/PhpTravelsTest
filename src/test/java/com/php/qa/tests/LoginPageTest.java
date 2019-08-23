package com.php.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.php.qa.base.TestBase;
import com.php.qa.pages.HomePage;
import com.php.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		 
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login", "LoginPage title unmatch");
	}
	@Test(priority=2)
	public void phpLogoImageTest()
	{
		boolean flag = loginPage.validatephpLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest()
	{
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
