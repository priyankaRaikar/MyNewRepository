package com.driver.main;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.*;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.dataRead.DataRead;
import com.utility.Functionality;

public class MainCaller {
	final JProgressBar pb = new JProgressBar();
	JButton b = new JButton("View Report");
	final JFrame frame = new JFrame("Test in Progress");

	JPanel panel = new JPanel();
	String path;
	final int MAX = 100;
	int failcount = 100;
	int testCount = 0;	
	int count = 1;
	int failMain;
	
	public String scrFolder, temp;
	ExtentHtmlReporter report1, reporttemp;
	ExtentReports extent1, extenttemp;
	ExtentTest logger, logger2, loggertemp;
	String result;
	String name;
	int testnum = 0;
	DataRead dr = new DataRead();
	Functionality fn = new Functionality();
	String arr[][] = new String[100][];
	String arr1[][] = new String[100][];
	String arr2[][] = new String[100][];

	@BeforeMethod
	public void a() {

		report1 = new ExtentHtmlReporter("D:\\rep.html");
		extent1 = new ExtentReports();
		extent1.attachReporter(report1);
		logger = extent1.createTest("hello");
		logger.log(Status.PASS, "sucess");
		extent1.flush();
		report1.flush();

		report1 = new ExtentHtmlReporter("D:\\rep1.html");
		extent1 = new ExtentReports();
		extent1.attachReporter(report1);
	}

	@AfterMethod
	public void g(ITestResult res) {

		if (res.getStatus() == ITestResult.FAILURE) {
			
			System.out.println("fail=" + failcount);
		}
		count++;
		extent1.flush();
		report1.flush();
	}

	@Test
	public void f() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException 
	{

		final int MAX = 100;
		panel.setLayout(new FlowLayout());
		JLabel label = new JLabel("dff");
		label = new JLabel("My label");
		label.setVisible(true);
		frame.add(label);

		// creates progress bar

		pb.setMinimum(0);
		pb.setMaximum(MAX);
		pb.setStringPainted(true);
		pb.setForeground(Color.blue);

		// add progress bar
		frame.setLayout(new FlowLayout());
		frame.getContentPane().add(pb);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 350);
		frame.setVisible(true);

		panel.add(b);
		frame.add(panel);

		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		File src1 = new File("D:\\Book1.xlsx");
		FileInputStream fis = new FileInputStream(src1);
		Workbook wb = new XSSFWorkbook(fis);
		int wbcount = wb.getNumberOfSheets();

		Sheet sheetMain = wb.getSheetAt(0);
		int lenMain = sheetMain.getLastRowNum() + 1;
		int getlen = lenMain - 1;
		int usedlen = 100 / getlen;
		String arrayMain[][] = new String[lenMain][2];
		for (int i = 0; i < lenMain; i++)
		{
			System.out.println("sheet");
			arrayMain[i][0] = sheetMain.getRow(i).getCell(0).getStringCellValue();
			arrayMain[i][1] = sheetMain.getRow(i).getCell(1).getStringCellValue();
		}
		int index = 0;
		for (int iter = 1; iter < sheetMain.getLastRowNum() + 1; iter++)
		{
			//System.out.println("iter           tyunAbhSJK        "+iter);
			//System.out.println(arrayMain[iter][1]);
			label.setText("<html><font size=\"3\">" + "TestCase " + iter + "executing</font></html>"); // step
			if (arrayMain[iter][1].equalsIgnoreCase("yes"))
			{
				logger = extent1.createTest(arrayMain[iter][0]);

				reporttemp = new ExtentHtmlReporter("D:\\" +arrayMain[iter][0] + ".html");
				extenttemp = new ExtentReports();
				extenttemp.attachReporter(reporttemp);

				Method[] methods = Functionality.class.getDeclaredMethods();
				try 
				{
					arr = dr.getData(iter);
				} 
				catch (IOException i) {}
				int len = Integer.parseInt(arr[0][0]);
				try {

					for (int i = 1; i < len; i++) {
						System.out.println("met : " + arr[i][1]);
						int j;
						try {
							for (j = 0; j < methods.length; j++) 
							{
								System.out.println("Method Name = " + methods[j].getName());
								System.out.println(arr[i][1]);
								
								if (arr[i][1].equalsIgnoreCase(methods[j].getName())) 
								{

									System.out.println("lol" + arr[i][0] + "=================" + methods[j].getName());
									path = (String) methods[j].invoke(fn, arr[i][2], arr[i][3], arr[i][4]);
									name=methods[j].getName();
									break;
								}
							}
							if (j == methods.length) 
							{
								throw new NullPointerException();
							}
							loggertemp = extenttemp.createTest(arr[i][1]);
							if(name.equalsIgnoreCase("quit")) {
								loggertemp.log(Status.PASS, "browser closed");	
							}
							else {
							loggertemp.log(Status.PASS, "<a href=" + path + ">Pass screenshot</a>");
							}
						} 
						catch (Exception e) 
						{
							loggertemp = extenttemp.createTest(arr[i][1]);
							loggertemp.log(Status.FAIL, "<a href=" + path + ">Fail screenshot</a>");
							throw e;
						}
					}
					failcount -= 50;
					count = iter * usedlen;
					try 
					{
						SwingUtilities.invokeLater(new Runnable() {
							public void run() 
							{
								pb.setValue(count);
							}
						});
						java.lang.Thread.sleep(100);
					}
					catch (InterruptedException e) 
					{
						JOptionPane.showMessageDialog(frame, e.getMessage());
					}
//					System.out.println("looooooooooooooooooooooooooooooooooooooool" +arrayMain[iter][0]);
//					logger.log(Status.PASS,"<a href=D:\\"+arrayMain[iter][0]+".html>"+ arrayMain[iter][0] + "</a>");
//				} 
//				catch (Exception e) 
//				{
//					logger.log(Status.FAIL,"<a href=D:\\"+arrayMain[iter][0]+".html>" + arrayMain[iter][0] + "</a>");
//				}
					System.out.println("asdfghjkasdfghjklsdfghjksdfghjk    " + arrayMain[iter][0]);
					logger.log(Status.PASS,
							"<a href='D:\\" + arrayMain[iter][0] + ".html'>" + arrayMain[iter][0] + "</a>");
				} catch (Exception e) {

					logger.log(Status.FAIL,
							"<a href=D:\\" + arrayMain[iter][0] + ".html>" + arrayMain[iter][0] + "</a>");

				} 
				extenttemp.flush();
				reporttemp.flush();
			}
		}
	}

	@AfterSuite
	public void z() {
		System.out.println("inside after suite");
		b.addActionListener(new ActionListener() {
			File f1 = new File("D:\\rep1.html");

			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Desktop.getDesktop().open(f1);
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(b);
		frame.setVisible(true);
		System.out.println("MAX=" + MAX + "fail=" + failMain);
		pb.setValue(MAX - failcount);
		pb.setForeground(Color.green);
		pb.setBackground(Color.red);
		try 
		{
			Thread.sleep(30000);
		} catch (InterruptedException e){}
	}
}