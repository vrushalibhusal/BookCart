package com.bookcart.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelData {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public static Object[][] excelTestData(String  sheetName) throws Exception
	{
		String  excellPath =".\\src\\test\\resources\\TestData\\BookCartTestData.xlsx";
		

		File absPath = new File(excellPath); 

		FileInputStream fis = new FileInputStream(absPath);
		workbook= new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		System.out.println(sheetName + "    "+excellPath);

		int noRow =  sheet .getPhysicalNumberOfRows(); 
		int noCol = sheet.getRow(0).getPhysicalNumberOfCells(); 
		System.out.println(noRow +"  "+noCol);
		Object data[][]=new Object[noRow-1][noCol]; 


		for(int i= 1;i < noRow; i++) { 
			for(int j= 0;j < noCol;j++) {

				String   cellData = sheet.getRow(i).getCell(j).getStringCellValue();

				System.out.println(cellData+"   ");
				data[i-1][j] = cellData;
			} 
		}   
		return data;
	}
}
