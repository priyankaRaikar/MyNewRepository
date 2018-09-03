package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Functionality {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	String handle="";
	String scrName = "";

	//Functionality fn = new Functionality();
	
	public void Open_Browser(String arg1, String arg2,String arg3) {
		System.out.println("inside open browser");
		
		String chromePath = "C:\\Users\\M1046989\\Downloads\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		
		
		report = new ExtentReports("D:\\reports\\report.html");
		logger=report.startTest("Open_Browser");
		driver = new ChromeDriver();
		scrName = "openBrowser";
		takeScreenShot(scrName);
		report.endTest(logger);
		//report.flush();
		
	}
	public void Navigate_Browser(String arg1, String arg2,String arg3) {
		System.out.println("navigate url called");
		driver.get("http://demosite.center/wordpress/wp-login.php");
		
		report = new ExtentReports("D:\\reports\\report.html");
		logger=report.startTest("Navigate_Browser");
		scrName = "Navigate_browser";
		takeScreenShot(scrName);
		
		report.endTest(logger);
		//report.flush();
		
	}
	public void input(String userorpass, String val , String arg1) {
		System.out.println("-------------"+userorpass+"------"+val+"-------"+arg1);
		System.out.println("inside input");
		if(userorpass.equalsIgnoreCase("Input_user")) {
			driver.findElement(By.xpath(arg1)).sendKeys(val);
			
			report = new ExtentReports("D:\\reports\\report.html");
			logger = report.startTest("inkggdjxgdxgput");
			scrName = "input_user";
			takeScreenShot(scrName);
			report.endTest(logger);
		}
		else if(userorpass.equalsIgnoreCase("input_pass")) {
			driver.findElement(By.xpath(arg1)).sendKeys(val);
			
			report = new ExtentReports("D:\\reports\\report.html");
			logger = report.startTest("input");
			scrName = "Input_password";
			takeScreenShot(scrName);
			report.endTest(logger);
		}
		else if(userorpass.equalsIgnoreCase("input_title")) {
			driver.findElement(By.xpath(arg1)).sendKeys(val);
			
			report = new ExtentReports("D:\\reports\\report.html");
			logger = report.startTest("input");
			scrName = "input_title";
			takeScreenShot(scrName);
			report.endTest(logger);
		}
		
		
	}
	public void Click(String vclick, String arg2,String arg3) {
		System.out.println("inside click");
		if(vclick.equalsIgnoreCase("click_login")) {
			System.out.println("inside click login");
			driver.findElement(By.xpath(arg3)).click();
			
			report = new ExtentReports("D:\\reports\\report.html");
			logger = report.startTest("Click");
			scrName = "Click_login";
			takeScreenShot(scrName);
			report.endTest(logger);
			
		}
		
		else if(vclick.equalsIgnoreCase("click_preview")) {
			System.out.println("inside click preview");
			handle = driver.getWindowHandle();
			driver.findElement(By.xpath(arg3)).click();
			
			report = new ExtentReports("D:\\reports\\report.html");
			logger = report.startTest("Click");
			scrName = "click_Preview";
			takeScreenShot(scrName);
			report.endTest(logger);
		}
		else if(vclick.equalsIgnoreCase("click_publish")) {
			System.out.println("inside click publish");
			driver.findElement(By.xpath(arg3)).click();
			
			report = new ExtentReports("D:\\reports\\report.html");
			logger = report.startTest("Click");
			scrName = "click_preview";
			takeScreenShot(scrName);
			report.endTest(logger);
		}
		else if(vclick.equalsIgnoreCase("click_all_post")) {
			System.out.println("inside click all posts");
			try {Thread.sleep(3000);}catch(InterruptedException e) {}
			driver.findElement(By.linkText(arg3)).click();
			
			report = new ExtentReports("D:\\reports\\report.html");
			logger = report.startTest("Click");
			scrName = "click_All_Post";
			takeScreenShot(scrName);
			logger.log(LogStatus.INFO,
					"All ScreenShots Taken" + "   " + "<a href = 'C:\\Users\\M1047138\\Pictures\\scrshots'>Files</a>");
			report.endTest(logger);
			report.flush(); 
			
		}
		
		
		
	}
	public void Hower(String arg1, String arg2,String arg3) {
		System.out.println("inside hower");
		WebElement posts = driver.findElement(By.xpath(arg3));
		try {Thread.sleep(3000);}catch(InterruptedException e) {}
		Actions actions = new Actions(driver);
		actions.moveToElement(posts).perform();
		try {Thread.sleep(3000);}catch(InterruptedException e) {}
		driver.findElement(By.xpath("//a[contains(text(),'Add New')]")).click();
		System.out.println("howerdone");
		
	}
	public void Handle(String arg1, String arg2,String arg3) {
		System.out.println("inside handle");
		try {Thread.sleep(5000);}catch(InterruptedException e) {}
		driver.switchTo().window(handle);
		
	}
	public void screenshot(String arg1, String arg2,String arg3) {
		System.out.println("inside screenshot");
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File src = scrShot.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\M1047138\\Pictures\\Screenshots\\team.jpg");
		try {
			FileUtils.copyFile(src,dest);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("IOEXPN");
		}
		System.out.println("Screenshot taken and stored in pictures");
		
	}
	public void quit(String arg1, String arg2,String arg3) {
		System.out.println("inside quit");
		try {Thread.sleep(7000);}catch(InterruptedException e) {}
		System.out.println("Successful end 2 end flow");
		//report.flush();
//		driver.quit();
		
		driver.get("D:\\reports\\report.html");
		
	}

	public void takeScreenShot(String scrName) {
		
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File src = scrShot.getScreenshotAs(OutputType.FILE);
		String screenshotName = "C:\\Users\\M1047138\\Pictures\\scrshots\\";
		String finalName = screenshotName+""+scrName+""+".jpg";
		File dest = new File(finalName);
		try {
			FileUtils.copyFile(src,dest);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("IOEXPN");
		}
		
	}
	

}
