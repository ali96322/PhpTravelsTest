package com.php.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.php.qa.base.TestBase;
import com.php.qa.pages.HomePage;
import com.php.qa.pages.HotelsPage;
import com.php.qa.pages.LoginPage;
import com.php.qa.util.TestUtil;

public class HomePageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	HotelsPage hotelsPage;
	
	
	public HomePageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		testUtil =new TestUtil();
		hotelsPage = new HotelsPage();
		homePage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	//test cases should separated--independent each other
	//before every test case--launch the browser
	//@test--execute test case
	//after every test case--close the browser
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "My Account", "Home Page Title Not Matched");
	}
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		Assert.assertTrue(homePage.VerifyCorrectUserName());
	}
	@Test(priority=3)
	public void verifyHotelsLinkTest()
	{
		hotelsPage = homePage.clickOnHotelsLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
