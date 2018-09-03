package com.dataRead;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataRead {

	public String[][] getData(int itr) throws IOException {
		
		//File src=new File(".\\Book1.xlsx");
		File src = new File("C:\\Users\\M1046989\\Documents\\p\\Book1.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheetAt(itr);
		
		String arr[][] = new String[100][5];
		for(int i = 0 ; i < sh1.getLastRowNum()+1 ; i++) {
			//System.out.println("itr" +i);
			arr[i][0] = Integer.toString(sh1.getLastRowNum()+1);
			arr[i][1] = sh1.getRow(i).getCell(1).getStringCellValue();
			arr[i][2] = sh1.getRow(i).getCell(3).getStringCellValue();
			arr[i][3] = sh1.getRow(i).getCell(4).getStringCellValue();
			arr[i][4] = sh1.getRow(i).getCell(5).getStringCellValue();
			
		}
		return arr;
		
	}

//	public String[][] getDatalogin(int itr) throws IOException {
//		// TODO Auto-generated method stub
//		File src=new File(".\\Book1.xlsx");
//		FileInputStream fis=new FileInputStream(src);
//		XSSFWorkbook wb=new XSSFWorkbook(fis);
//		XSSFSheet sh1=wb.getSheetAt(itr);
//		
//		String arr1[][] = new String[12][4];
//		for(int i = 0 ; i < sh1.getLastRowNum()+1 ; i++) {
//			//System.out.println("itr" +i);
//			arr1[i][0] = sh1.getRow(i).getCell(1).getStringCellValue();
//			arr1[i][1] = sh1.getRow(i).getCell(3).getStringCellValue();
//			arr1[i][2] = sh1.getRow(i).getCell(4).getStringCellValue();
//			arr1[i][3] = sh1.getRow(i).getCell(5).getStringCellValue();
//		}
//		
//		for(int i =0;i<sh1.getLastRowNum()+1;i++) {
//			System.out.println("isideds "+arr1[i][0]);
//		}
//		return arr1;
//		
//	}
//
//	public String[][] getDataTestCase2(int itr) throws IOException {
//		// TODO Auto-generated method stub
//		File src=new File(".\\Book1.xlsx");
//		FileInputStream fis=new FileInputStream(src);
//		XSSFWorkbook wb=new XSSFWorkbook(fis);
//		XSSFSheet sh1=wb.getSheetAt(itr);
//		
//		String arr2[][] = new String[12][4];
//		for(int i = 0 ; i < sh1.getLastRowNum()+1 ; i++) {
//			//System.out.println("itr" +i);
//			arr2[i][0] = sh1.getRow(i).getCell(1).getStringCellValue();
//			arr2[i][1] = sh1.getRow(i).getCell(3).getStringCellValue();
//			arr2[i][2] = sh1.getRow(i).getCell(4).getStringCellValue();
//			arr2[i][3] = sh1.getRow(i).getCell(5).getStringCellValue();
//		}
//		
//		for(int i =0;i<sh1.getLastRowNum()+1;i++) {
//			System.out.println("isideds "+arr2[i][0]);
//		}
//		return arr2;
//		
//	}

}
