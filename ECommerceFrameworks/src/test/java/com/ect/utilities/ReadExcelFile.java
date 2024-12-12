package com.ect.utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadExcelFile {
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet excelsheet;
	public static XSSFRow row;
	public static XSSFCell cell;
    public static String getCellValue(String fileName, String sheetName, int rowNo, int cellNo)
    {
    	try {
			fis=new FileInputStream(fileName);
			workbook=new XSSFWorkbook(fis);
			excelsheet=workbook.getSheet(sheetName);
			cell= excelsheet.getRow(rowNo).getCell(cellNo);
			workbook.close();
			return cell.getStringCellValue();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "";
		}
        
    }
    public static int getRowCount(String fileName, String sheetName) {
    	try {
			fis=new FileInputStream(fileName);
			workbook=new XSSFWorkbook(fis);
			excelsheet=workbook.getSheet(sheetName);
			int row=excelsheet.getLastRowNum()+1;
			workbook.close();
			return row;	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return 0;
		}
    }
    public static int getColCount(String fileName, String sheetName) {
    	try {
			fis=new FileInputStream(fileName);
			workbook=new XSSFWorkbook(fis);
			excelsheet=workbook.getSheet(sheetName);
			int col=excelsheet.getRow(0).getLastCellNum();
			workbook.close();
			return col;	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return 0;
		}
    }
    public String getStringData(int sheetIndex,int row,int column) 
    {
    	
       return workbook.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
    }
    public String getStringData(String sheetName,int row,int column) 
    {
    	
       return workbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }
    
    public double  getNumericData(String sheetName,int row,int column) 
    {
    	
       return workbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }
}
