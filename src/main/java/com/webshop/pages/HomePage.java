package com.webshop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webshop.driver.DriverScript;

public class HomePage extends DriverScript {
	
// ******************************************** Page Elements/Locators ****************************************//
	
	@FindBy(linkText = "Log in") WebElement loginLink;
	@FindBy(linkText = "Register") WebElement registerLink;
	@FindBy(xpath = "(//a[contains(text(),'Gift Cards')])[1]") WebElement menuGiftCards;
	
// ******************************************** Page Initilization ********************************************//
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
// ******************************************** Page Actions/Methods ******************************************//
	
	public void clickGiftCardsMenu()
	{
		menuGiftCards.click();
	}
	
	public String getHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public void clickLoginInLink()
	{
		loginLink.click();
	}
	
	public void clickRegisterLink()
	{
		registerLink.click();
	}

}
