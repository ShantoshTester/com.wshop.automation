package com.webshop.utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
XSSFWorkbook excel;
	
	/*
	 * this is the constructor which takes excel-path as a parameter 
	 * whenever we create an object of this class
	 */
	public ExcelUtil(String excelPath)
	{
		try
		{
			File file = new File(excelPath);
			FileInputStream fis = new FileInputStream(file);
			excel = new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("unable to load the excel file. please check "+e.getMessage());
		}
	}
	
	/*
	 * this method is used to get the active rows
	 * parameter to be passed is sheet number
	 */
	public int getRowCount(int sheetNum)
	{
		return excel.getSheetAt(sheetNum).getLastRowNum()+1;
	}
	
	public int getRowCount(String sheetName)
	{
		return excel.getSheet(sheetName).getLastRowNum()+1;
	}
	
	
	
	/*
	 * this method is used to fetch the data
	 * parameter to be passed is sheet number, row, col
	 */
	public String getCellData(int sheetNum, int row, int col)
	{
		return excel.getSheetAt(sheetNum).getRow(row).getCell(col).toString();
	}
	
	public String getCellData(String sheetName, int row, int col)
	{
		return excel.getSheet(sheetName).getRow(row).getCell(col).toString();
	}

}
