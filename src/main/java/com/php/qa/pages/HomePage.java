package com.php.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.php.qa.base.TestBase;

public class HomePage extends TestBase
{
	@FindBy(xpath="//h3[contains(text(),'Hi, ali khan')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Flights')]//parent::a[@class='text-center']")
	WebElement flightsTab;
	
	@FindBy(xpath="//span[contains(text(),'Flights')]//parent::a[@class='text-center']//parent::li//preceding-sibling::li//child::a[contains(@class,'text-center')]")
	WebElement hotelsLink;
	
	@FindBy(xpath="//span[@class='ink animate']//parent::a[@data-toggle='tab']")
	WebElement profileLink;
	
	//Initializing the Page Objects
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean VerifyCorrectUserName()
	{
		return userNameLabel.isDisplayed();
	}
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public FlightsPage clickOnFlightsLink()
	{
		flightsTab.click();
		return new FlightsPage();
	}
	public HotelsPage clickOnHotelsLink()
	{
		hotelsLink.click();
		return new HotelsPage();
	}
	
}
