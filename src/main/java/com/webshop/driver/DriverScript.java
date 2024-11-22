package com.webshop.driver;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverScript {
	
	public static WebDriver driver;
	static Properties prop;
	
	/*
	 * this constructor invokes the properties file
	 */
	public DriverScript()
	{
		try
		{
			File file = new File("./src/test/resources/config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("unable to load the config.properties file");
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	/*
	 * this method is used to invoke the browser based on the properties file
	 */
	public void initApplication()
	{
		String browser = prop.getProperty("browser");
		
		if(browser.trim().equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.trim().equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.trim().equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.err.println("unsupported browser! Please check the config file");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// calling the app url method
		getAppUrl();
		
	}
	
	/*
	 * this method is used to invoke the app url based on the properties file
	 */
	public static void getAppUrl()
	{
		String url = prop.getProperty("url");
		driver.get(url);
	}
	
	/*
	 * this method is used to quit the driver
	 */
	public static void quitDriver()
	{
		driver.quit();
	}

}


















