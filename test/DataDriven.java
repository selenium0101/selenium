package test;

import java.io.FileInputStream;






import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class DataDriven  {
	public  static String[][]  getExcelData()  {
		XSSFWorkbook workbook = null;
		String[][] arrayExcelData=null; 
		FileInputStream fis=null;
		try {
			fis = new FileInputStream("D://Login.xlsx");
			workbook = new XSSFWorkbook(fis);
			//int index = workbook.getSheetIndex(sheetName);
			Sheet sheet = workbook.getSheetAt(0);		
			int totalNoOfRows=sheet.getLastRowNum();
			System.out.println(totalNoOfRows);
			arrayExcelData = new String[totalNoOfRows][2];
			for (int i=1;i<=totalNoOfRows;i++) {
				Row row=sheet.getRow(i);
				Cell cell1 = row.getCell(0);
				Cell cell2 = row.getCell(1);

				System.out.println(cell1.getStringCellValue());
				System.out.println(cell2.getStringCellValue());
				arrayExcelData[(i-1)][0] = cell1.getStringCellValue();
				arrayExcelData[(i-1)][1] = cell2.getStringCellValue();

				System.out.println(arrayExcelData[i-1][0]);
				System.out.println(arrayExcelData[i-1][1]);
			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		}
		//workbook.close();
		return arrayExcelData;
	}


	public  static void  writeExcelFile() throws InterruptedException  {
		XSSFWorkbook workbook = null;
		//String[][] arrayExcelData=null; 
		FileInputStream fis=null;
		try {
			fis = new FileInputStream("D://Login.xlsx");
			workbook = new XSSFWorkbook(fis);
			fis.close();
			//int index = workbook.getSheetIndex(sheetName);
			Sheet sheet = workbook.getSheetAt(0);		
			int totalNoOfRows=sheet.getLastRowNum();
			System.out.println(totalNoOfRows);
			//arrayExcelData = new String[totalNoOfRows][2];
			for (int i= 1;i<=totalNoOfRows;i++) {
				
				Row row=sheet.getRow(i);
				
				Cell cell1 = row.getCell(1);

				if (cell1 == null){
					Cell  cell2 = row.createCell(2);
					cell2.setCellValue("sample");
				}	
				else{
					cell1.setCellValue("sample");
				}
				
			}
			
			FileOutputStream fileOut = new FileOutputStream("E://Login.xlsx");
			workbook.write(fileOut);
			fileOut.close(); 
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		}
		//workbook.close();
		//return arrayExcelData;
	}

	public static void main(String[] args) throws InterruptedException {
		writeExcelFile();

		//getExcelData();
	}





}








