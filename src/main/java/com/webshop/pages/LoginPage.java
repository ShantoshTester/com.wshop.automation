package com.webshop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.webshop.driver.DriverScript;

public class LoginPage extends DriverScript {
	
// ******************************************** Page Elements/Locators ****************************************//
	
	@FindBy(id="Email") WebElement emailTextbox;
	@FindBy(name="Password") WebElement passwordTextbox;
	@FindBy(xpath = "//input[@value='Log in']") WebElement loginButton;
	@FindBy(xpath = "//a[text()='Forgot password?']") WebElement forgotPasswordLink;
	@FindBy(xpath = "//span[@for='Email']") WebElement errValidEmailText;
	@FindBy(xpath = "//span[contains(text(),'Login was unsuccessful')]") WebElement errUnsuccessfulLoginText;
	@FindBy(linkText = "Log out") WebElement logoutLink;
	
// ******************************************** Page Initilization ********************************************//
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
// ******************************************** Page Actions/Methods ******************************************//
	
	public void clickLogout()
	{
		logoutLink.click();
	}
	
	public boolean isLogoutLinkDisplayed()
	{
		return logoutLink.isDisplayed();
	}
	
	public String verifyValidEmail()
	{
		return errValidEmailText.getText();
	}
	
	public String verifyUnsuccessfulLogin()
	{
		return errUnsuccessfulLoginText.getText();
	}
	
	public boolean isForgotPasswordDisplayed()
	{
		return forgotPasswordLink.isDisplayed();
	}
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public void enterEmailId(String email)
	{
		emailTextbox.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		passwordTextbox.sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}

}
