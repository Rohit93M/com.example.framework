package com.example.genericutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String readTheStringData(String sheetName, int rowIndex, int cellIndex)
			throws EncryptedDocumentException, IOException {
		File file = new File("./src/test/resources/WebFormTestCase.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		String value = cell.getStringCellValue();
		return value;
	
	}

	public double readTheDoubleNumericData(String sheetName, int rowIndex, int cellIndex)
			throws EncryptedDocumentException, IOException {
		File file = new File("./src/test/resources/WebFormTestCase.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		double value = cell.getNumericCellValue();
		return value;
	}

	public long readTheLongNumericData(String sheetName, int rowIndex, int cellIndex)
			throws EncryptedDocumentException, IOException {
		File file = new File("./src/test/resources/WebFormTestCase.xlsx/");
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		long value = (long) cell.getNumericCellValue();
		return value;
	}
}
