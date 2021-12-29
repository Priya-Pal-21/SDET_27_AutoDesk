package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*
 * @author Priya Pal
 * It is developed using Apache POI libraries,Which is used to handle Microsoft Excel Sheet
 */
public class ExcelUtility {
/*
 * Used to read the data from Excel Sheet based on below arguments
 * @Parameter Sheet1
 * @Parameter rowNum
 * @Parameter colNum
 * @return String
 */
	public String getDataFromExcelSheet(String Sheet1,int rowNum,int colNum) throws Throwable {
		FileInputStream fis=new FileInputStream("./Data/testData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet(Sheet1);
		 Row row = sh.getRow(rowNum);
		 String data = row.getCell(colNum).getStringCellValue();
		 wb.close();
		 return data;		 
	}
	/*
	 * Used to get the last used row number of specific sheet
	 * @Parameter Sheet1
	 * @return int
	 * @throws Throwable
	 */
	public int getRowCount(String Sheet1) throws Throwable {
		FileInputStream fis=new FileInputStream("./Data/testData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheet1);
		wb.close();
		return sh.getLastRowNum(); 
	}
	/*
	 * Used to Insert Data into Excell Sheet
	 * @Parameter Sheet1
	 * @Parameter rowNum
	 * @Parameter cellNum
	 * @Parameter data
	 * @throws Throwable
	 */
	public void setDataIntoExcel(String Sheet1,int rowNum,int cellNum,String data) throws Throwable {
		FileInputStream fis=new FileInputStream("./Data/testData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheet1);
		Row row = sh.getRow(rowNum);
		Cell cell=row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./Data/testData.xlsx");
		wb.write(fos);
		wb.close();	
	}	
}
