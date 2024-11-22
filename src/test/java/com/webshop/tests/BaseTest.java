package com.webshop.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.webshop.driver.DriverScript;
import com.webshop.pages.GiftCardsPage;
import com.webshop.pages.HomePage;
import com.webshop.pages.LoginPage;
import com.webshop.utils.ExcelUtil;
import com.webshop.utils.Helper;


public class BaseTest extends DriverScript {
	
	protected static ExtentHtmlReporter extent;
	protected static ExtentReports report;
	protected static ExtentTest logger;
	HomePage homePage;
	LoginPage loginPage;
	GiftCardsPage giftCardsPage;
	
	@BeforeSuite
	public void setUpReport()
	{
		extent = new ExtentHtmlReporter("./report/index.html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeMethod
	public void setUp()
	{
		initApplication();
		homePage = new HomePage();
		loginPage = new LoginPage();
		giftCardsPage = new GiftCardsPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		Helper.sleep();
		quitDriver();
		report.flush();
	}
	
	@DataProvider(name="wsdata")
	public Object[][] testData1()
	{
		ExcelUtil excel = new ExcelUtil("./src/test/resources/testdata/wsdata.xlsx");
		int row = excel.getRowCount("multiuser");
		
		Object[][] data = new Object[row][2];
		
		for(int i=0; i<row; i++)
		{
			data[i][0] = excel.getCellData("multiuser", i, 0);
			data[i][1] = excel.getCellData("multiuser", i, 1);
		}
		
		return data;
	}

}
