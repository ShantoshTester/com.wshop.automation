package com.webshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
	

//	@Test(priority = 1)
	public void testLoginPageTitle()
	{
		logger = report.createTest("test login page title");
		homePage.clickLoginInLink();
		logger.pass("clicked login link");
		String title = loginPage.getLoginPageTitle();
		logger.pass("get the login page title");
		System.out.println(title);
		Assert.assertTrue(title.contains("Login"));
		logger.pass("login page title matched");
	}
	
//	@Test(priority = 2)
	public void testLoginFunction()
	{
		logger = report.createTest("test login function");
		homePage.clickLoginInLink();
		logger.pass("clicked login link");
		loginPage.enterEmailId("selauto1@test.com");
		logger.pass("entered email id");
		loginPage.enterPassword("Pass@123");
		logger.pass("entered password");
		loginPage.clickLoginButton();
		logger.pass("clicked login button");
		String loginPageTitle = loginPage.getLoginPageTitle();
		System.out.println(loginPageTitle);
		logger.pass("get the page title");
		Assert.assertTrue(loginPageTitle.contains("Demo Web Shop"));
		logger.pass("login successfull");
	}
	
	@Test(priority = 3,dataProvider = "wsdata")
	public void testMultiLoginFunction(String username, String password)
	{
		logger = report.createTest("test login function");
		homePage.clickLoginInLink();
		logger.pass("clicked login link");
		loginPage.enterEmailId(username);
		logger.pass("entered email id");
		loginPage.enterPassword(password);
		logger.pass("entered password");
		loginPage.clickLoginButton();
		logger.pass("clicked login button");
		String loginPageTitle = loginPage.getLoginPageTitle();
		System.out.println(loginPageTitle);
		logger.pass("get the page title");
		Assert.assertTrue(loginPageTitle.contains("Demo Web Shop"));
		logger.pass("login successfull");
	}

}
