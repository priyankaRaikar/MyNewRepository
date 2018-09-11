package com.dataRead;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataRead {

	public String[][] getData(int itr) throws IOException {
		

		File src = new File("D:\\Book1.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheetAt(itr);
		
		String arr[][] = new String[100][5];
		for(int i = 0 ; i < sh1.getLastRowNum()+1 ; i++) {

			arr[i][0] = Integer.toString(sh1.getLastRowNum()+1);
			arr[i][1] = sh1.getRow(i).getCell(1).getStringCellValue();
			arr[i][2] = sh1.getRow(i).getCell(3).getStringCellValue();
			arr[i][3] = sh1.getRow(i).getCell(4).getStringCellValue();
			arr[i][4] = sh1.getRow(i).getCell(5).getStringCellValue();
			
		}
		return arr;
		
	}
}

