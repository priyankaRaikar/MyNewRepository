package com.driver.main;

import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.awt.*;
import javax.swing.*;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.dataRead.DataRead;
import com.utility.Functionality;

public class MainCaller {
	int count = 1 ;
//	int currentValue;
    final int MAX = 100;
    final JFrame frame = new JFrame("JProgress Demo");

    // creates progress bar
    final JProgressBar pb = new JProgressBar();
    	
	DataRead dr = new DataRead();
	Functionality fn = new Functionality();
	String arr[][] = new String[100][];
	String arr1[][] = new String[100][];
	String arr2[][] = new String[100][];
	
	
	
  @Test
  public void f() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
	  
	  File src1 = new File("C:\\Users\\M1046989\\Documents\\p\\Book1.xlsx");
		FileInputStream fis=new FileInputStream(src1);
		Workbook wb=new XSSFWorkbook(fis);
		int wbcount = wb.getNumberOfSheets();
		
		Sheet sheetMain=wb.getSheetAt(0);
		int lenMain = sheetMain.getLastRowNum()+1;
		System.out.println("aaaaaaaaaaaaaaaaaaaasdfgh"+lenMain);
		String arrayMain[][] = new String[lenMain][2];
		
		for(int i = 0 ; i < lenMain; i++) {
			System.out.println("sheet");
			arrayMain[i][0] = sheetMain.getRow(i).getCell(0).getStringCellValue();
			//System.out.println("arr[i " +arr[i][0] );
			arrayMain[i][1] = sheetMain.getRow(i).getCell(1).getStringCellValue();
			
		}
		
	  //MainCaller ob = new MainCaller();

	  //for(int iter = 1 ; iter < wbcount-1 ; iter++) {
		int index = 0;
		for(int iter = 1 ; iter < sheetMain.getLastRowNum()+1 ; iter++ ) {
		  
			
			if(arrayMain[iter][1].equalsIgnoreCase("yes")){
				Method[] methods = Functionality.class.getDeclaredMethods();
				  try{arr = dr.getData(iter);}catch(IOException i) {}
				  
				  int len = Integer.parseInt(arr[0][0]);

				  for(int i = 0 ; i < len ; i++) {
					  System.out.println("met : "+arr[i][0]);
					  
					  
					  
					  for(int j = 0 ; j < methods.length ; j++) {
						  System.out.println("Method Name = "+methods[j].getName());
							  if(arr[i][1].equalsIgnoreCase(methods[j].getName()) ) {
								  
						          
								  try {
						                SwingUtilities.invokeLater(new Runnable() {
						                    public void run() {
						                        pb.setValue(count);
						                    }
						                });
						                java.lang.Thread.sleep(100);
						            } catch (InterruptedException e) {
						                JOptionPane.showMessageDialog(frame, e.getMessage());
						            }

								  
								  
								  System.out.println("lol"+arr[i][0]+"================="+methods[j].getName());
								  methods[j].invoke(fn,arr[i][2],arr[i][3],arr[i][4]);
								  break;
							  }
						  }
					  
					  }
				  
			      

				  

			}
			
			
	  	  }
	  }
	  
  
//  @Test
//  public void f1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
//	  
//	  Method[] methods2 = Functionality.class.getDeclaredMethods();
//	  try{arr2 = dr.getDataTestCase2(1);}catch(IOException i) {}
//	  for(int i = 0 ; i < 12 ; i++) {
//		  System.out.println("met : "+arr2[i][0]);
//		  
//		  if(arr2[i][0].equalsIgnoreCase("login")) {
//			  login();
//		  }
//		  else {
//		  for(int j = 0 ; j < methods2.length ; j++) {
//			  System.out.println("Method Name = "+methods2[j].getName());
//				  if(arr2[i][0].equalsIgnoreCase(methods2[j].getName()) ) {
//					  
//					 
//					  try {
//			                SwingUtilities.invokeLater(new Runnable() {
//			                    public void run() {
//			                        pb.setValue(count);
//			                    }
//			                });
//			                java.lang.Thread.sleep(100);
//			            } catch (InterruptedException e) {
//			                JOptionPane.showMessageDialog(frame, e.getMessage());
//			            }
//					  
//					  System.out.println("lol"+arr2[i][0]+"================="+methods2[j].getName());
//					  methods2[j].invoke(fn,arr2[i][1],arr2[i][2],arr2[i][3]);
//					  break;
//				  }
//			  }
//		  }
//	  }
//	  count++;
//	  
//	 
//	 
//  }
  
  
  
//  public void login() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
//	  
//	  //Method[] methods = Functionality.class.getDeclaredMethods();
//	  
//	  Method[] methods1 = Functionality.class.getDeclaredMethods();
//	  try{arr1 = dr.getDatalogin(2);}catch(IOException ex) {}
//	  System.out.println("logininin");
//	  System.out.println("Methods array=================================");
//	  for(Method m : methods1) {
//		  System.out.println(m.getName());
//	  }
//	  System.out.println("simple array=================================");
//	  for(int i = 0 ; i<4;i++) {
//		  System.out.println(arr1[i][0]+" "+arr1[i][1]+" "+arr1[i][2]+" "+arr1[i][3]);
//	  }
//		  for(int itr =0;itr<4;itr++) {
//		  
//			  for(int j = 0 ; j < methods1.length ; j++) {
//				  
//				  
//				  if(arr1[itr][0].equalsIgnoreCase(methods1[j].getName())) {
//					  System.out.println("loly "+arr1[itr][0]+"================="+methods1[j].getName());
//					  methods1[j].invoke(fn,arr1[itr][1],arr1[itr][2],arr1[itr][3]);
//					  break;
//				  }
//			  }
//		  
//		  }
//		  
//	  }
//  
	  
  
//  @BeforeSuite
//  public void beforeMethod() {
//	  System.out.println("Started");
//	  pb.setMinimum(0);
//	    pb.setMaximum(100);
//	    pb.setStringPainted(true);
//
//	    // add progress bar			
//	    frame.setLayout(new FlowLayout());
//	    frame.getContentPane().add(pb);
//
//	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    frame.setSize(300, 200);
//	    frame.setVisible(true);
//	    
//
//	  
//  }

//  @AfterMethod
//  public void afterMethod() {
//	  count+=50;
//	  try {Thread.sleep(2000);}catch(InterruptedException ex) {}
//	  
//	  
//	  
//  }
//
//  @AfterSuite
//  public void afterSuite() {
//	  try {
//          SwingUtilities.invokeLater(new Runnable() {
//              public void run() {
//                  pb.setValue(count);
//              }
//          });
//          java.lang.Thread.sleep(100);
//      } catch (InterruptedException e) {
//          JOptionPane.showMessageDialog(frame, e.getMessage());
//      }
//  }
}
