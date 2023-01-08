package com.mindtree.utility;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * ExcelUtils is a class which is used to set the excel file path 
 * and methods to read data from excel file 
 */

public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private XSSFCell Cell;

	public void setExcelFile(String Path, String SheetName) throws Exception {
		FileInputStream ExcelFile = new FileInputStream(Path);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
	}

	public String getCellData(int RowNum, int ColNum) throws Exception {
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		String CellData = Cell.getStringCellValue();
		System.out.println(CellData);
		return CellData;
	}

	public static Object[][] getTableArray() throws Exception {
		ExcelUtils utils = new ExcelUtils();
		String[][] tabArray = null;
		int startRow = 1;
		int startCol = 1;
		int ci, cj;
		int totalRows = ExcelWSheet.getLastRowNum();
		System.out.println(totalRows);
		// you can write a function as well to get Column count
		int totalCols = 2;
		tabArray = new String[totalRows][totalCols];
		ci = 0;
		for (int i = startRow; i <= totalRows; i++, ci++) {
			cj = 0;
			for (int j = startCol; j <= totalCols; j++, cj++) {
				tabArray[ci][cj] = utils.getCellData(i, j);
				System.out.println(tabArray[ci][cj]);
			}
		}

		return (tabArray);
	}
}
