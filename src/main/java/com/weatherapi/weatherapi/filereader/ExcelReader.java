package com.weatherapi.weatherapi.filereader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	List<String> countyName = new ArrayList<>();
	List<String> countyCode = new ArrayList<>();
	String path = "C:\\Users\\Leo\\eclipse-workspace\\weatherapi\\src\\main\\resources\\templates\\";
	
	public void readXlFile (String fileName) throws IOException {
		
		FileInputStream file = new FileInputStream(new File(path+fileName));
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet = workbook.getSheetAt(0);
		  int i=0;
         //Iterate through each rows one by one
         Iterator<Row> rowIterator = sheet.iterator();
         
         
         while (rowIterator.hasNext()) {
        	 
        	 Row row = rowIterator.next();
             //For each row, iterate through all the columns
             Iterator<Cell> cellIterator = row.cellIterator();
              while (cellIterator.hasNext()) {
            	  Cell cell = cellIterator.next();
            	  int colIndex = cell.getColumnIndex();
            	  if (colIndex == 0) {
            		  countyName.add(cell.getStringCellValue());
            	  }
            	  if (colIndex == 1) {
            	 // System.out.println(cell.getStringCellValue()+" at: "+ colIndex);
            	  countyCode.add(cell.getStringCellValue());
            	  }
            	  
            	
              }
        	 
         }
         file.close();
		
	}

	public List<String> getCountyName() {
		return countyName;
	}

	public List<String> getCountyCode() {
		return countyCode;
	}
	
	
	

}
