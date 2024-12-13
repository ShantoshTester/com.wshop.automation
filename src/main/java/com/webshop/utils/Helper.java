package com.webshop.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	
	public static String captureScreen(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenPath = "D:\\WORKSPACE\\BATCH31_FRAME\\com.wshop.automation\\report\\screenshot\\screen.png";
		try {
			FileHandler.copy(src, new File(screenPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenPath;
	}
	
	public static void sleep()
	{
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
