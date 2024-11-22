package com.webshop.utils;

public class Helper {
	
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
