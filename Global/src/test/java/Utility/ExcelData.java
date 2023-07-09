package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelData extends Driver  {
	XSSFWorkbook workbook;
	XSSFSheet sheet2;
	XSSFSheet sheet1;
	Row row;
	Cell cell;

	public ExcelData(String excelPath) {
		try {
			File Location = new File(excelPath);
			FileInputStream fis = new FileInputStream(Location);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getRowcount(String SheetName) {
		sheet2 = workbook.getSheet(SheetName);
		int Rowcount = sheet2.getLastRowNum() - sheet2.getFirstRowNum();
		return Rowcount;
	}

	public String getData(String SheetName, int RowNumber) {
		sheet2 = workbook.getSheet(SheetName);
		String Dealer_Url = sheet2.getRow(RowNumber).getCell(1).getStringCellValue();
		return Dealer_Url;
	}
	public String PAcode(String SheetName, int RowNumber) {
		sheet2 = workbook.getSheet(SheetName);
		String PAcode = sheet2.getRow(RowNumber).getCell(0).getStringCellValue();
		return PAcode;
	}
	

	public void Writedata(String SheetName, int RowNumber, String excelPath) throws Exception {
		sheet1 = workbook.getSheet(SheetName);
		
		if (sheet1 == null) {
			sheet1 = workbook.createSheet(SheetName);
			Excel_header();
		}
		int colnum = 0;
		row = sheet1.createRow(RowNumber);
		for (int j = 0; j <= sheetData.size(); j++) {
			cell = row.createCell(colnum++);
			try {
				cell.setCellValue(sheetData.get(j).toString());
			} catch (Exception e) {
				cell.setCellValue((String) " ");
			}
		}
		XSSFCellStyle style = workbook.createCellStyle();
		XSSFCellStyle style1 = workbook.createCellStyle();
		Excel_Color(style, style1);
		FileOutputStream fos = new FileOutputStream(excelPath);
		workbook.write(fos);
		fos.close();
	}

	private void Excel_Color(XSSFCellStyle style, XSSFCellStyle style1) {
		int j = 1;
		while (j < row.getLastCellNum()) {
			cell = row.getCell(j);
			Cell cell1 = row.getCell(0);
			String value = row.getCell(j).getStringCellValue();
			if (value.equalsIgnoreCase("Pass")) {
				style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
				style.setFillPattern(FillPatternType.FINE_DOTS);
				cell1.setCellStyle(style);
			} else if (value.equalsIgnoreCase("fail")) {
				style1.setFillBackgroundColor(IndexedColors.ROSE.getIndex());
				style1.setFillPattern(FillPatternType.FINE_DOTS);
				cell1.setCellStyle(style1);
			}
			j++;
		}
	}

	private void Excel_header() {
		Object Testcase[][] = { {"PA_CODE","Dealer URL"}, };
		
		int rowcount = 0;
		for (Object emp[] : Testcase) {
			row = sheet1.createRow(rowcount);
			int colcount = 0;
			for (Object value : emp) {
				cell = row.createCell(colcount++);
				if (value instanceof String) {
					cell.setCellValue((String) value);
				}
				if (value instanceof Integer) {
					cell.setCellValue((Integer) value);
				}
				if (value instanceof Boolean) {
					cell.setCellValue((Boolean) value);
				}
			}
		}
		
	}
}
