package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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
	
	public String Open_Browser(String arg1, String arg2,String arg3) {
		System.out.println("inside open browser");
		
		String chromePath = "C:\\Users\\M1047109\\Downloads\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		
		driver = new ChromeDriver();
		scrName = "openBrowser";
		String finalName=takeScreenShot(scrName);
		return finalName;
		
	}
	public String Navigate_Browser(String arg1, String arg2,String arg3) {
		System.out.println("navigate url called");
		driver.get("https://bookmyroomcloudapp.azurewebsites.net/");
		driver.manage().window().maximize();
	
		scrName = "Navigate_browser";
		String finalName=takeScreenShot(scrName);
		return finalName;
	
	}
	
	public String Validate(String userorpass, String val , String arg1) {
		String finalName="";
		System.out.println("-------------"+userorpass+"------"+val+"-------"+arg1);
		System.out.println("inside input");
		if(userorpass.equalsIgnoreCase("Validate_hp")) {
			driver.getTitle();
			
			
			scrName = "validate_hp";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		else if(userorpass.equalsIgnoreCase("validate_rb")) {
			String s1=driver.findElement(By.xpath(arg1)).getText();
			if(s1.equalsIgnoreCase("Register"))
			{
				System.out.println("Register Button Verified");
			}
			
			scrName = "Validate_RegB";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		else if(userorpass.equalsIgnoreCase("validate_lb")) {
			String s2=driver.findElement(By.xpath(arg1)).getText();
			if(s2.equalsIgnoreCase("Login"))
			{
				System.out.println("Login Button Verified");
			}
			
			scrName = "Validate_LogB";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		else if(userorpass.equalsIgnoreCase("validate_ab")) {
			String s3=driver.findElement(By.xpath(arg1)).getText();
			if(s3.equalsIgnoreCase("Admin"))
			{
				System.out.println("Admin Button Verified");
			}
			
			scrName = "Validate_AdB";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		else if(userorpass.equalsIgnoreCase("validate_sb")) {
			String s4=driver.findElement(By.xpath(arg1)).getText();
			if(s4.equalsIgnoreCase("Search"))
			{
				System.out.println("Search Button Verified");
			}
			
			scrName = "Validate_SB";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		else if(userorpass.equalsIgnoreCase("validate_next")) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String s4=driver.findElement(By.xpath(arg1)).getText();
			if(s4.equalsIgnoreCase("SearchHotel"))
			{
				System.out.println("Search Button functionality Verified");
			}
			
			scrName = "Validate_NextPage";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		else if(userorpass.equalsIgnoreCase("validate_regpage")) {
			String s5=driver.getTitle();
			if(s5.equalsIgnoreCase("Register - Book My Room"))
			{
				System.out.println("Registration Page Verified");
			}
			
			scrName = "Validate_RegPage";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		else if(userorpass.equalsIgnoreCase("validate_forgetp")) {
			String s5=driver.findElement(By.xpath(arg1)).getText();
			if(s5.equalsIgnoreCase("Register - Book My Room"))
			{
				System.out.println("Registration Page Verified");
			}
			
			scrName = "Validate_RegPage";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		
		return finalName;
	}
	
	public String input(String userorpass, String val , String arg1) {
		String finalName="";
		System.out.println("-------------"+userorpass+"------"+val+"-------"+arg1);
		System.out.println("inside input");
		if(userorpass.equalsIgnoreCase("Input_user")) {
			driver.findElement(By.xpath(arg1)).sendKeys(val);
			
			
			scrName = "input_user";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		else if(userorpass.equalsIgnoreCase("input_pass")) {
			driver.findElement(By.xpath(arg1)).sendKeys(val);
			
			
			scrName = "Input_password";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		else if(userorpass.equalsIgnoreCase("input_email")) {
			driver.findElement(By.xpath(arg1)).sendKeys(val);
			
			
			scrName = "input_email";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		else if(userorpass.equalsIgnoreCase("input_fname")) {
			driver.findElement(By.xpath(arg1)).sendKeys(val);
			
			
			scrName = "input_fname";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		else if(userorpass.equalsIgnoreCase("input_lname")) {
			driver.findElement(By.xpath(arg1)).sendKeys(val);
			
			
			scrName = "input_lname";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		else if(userorpass.equalsIgnoreCase("input_pswd")) {
			driver.findElement(By.xpath(arg1)).sendKeys(val);
			
			
			scrName = "input_password";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		else if(userorpass.equalsIgnoreCase("input_confpswd")) {
			driver.findElement(By.xpath(arg1)).sendKeys(val);
			
			
			scrName = "input_confirmpswd";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		else if(userorpass.equalsIgnoreCase("input_phone")) {
			driver.findElement(By.xpath(arg1)).sendKeys(val);
			
			
			scrName = "input_phone";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		
		return finalName;
		
		
	}
	public String scroll(String userorpass, String val , String arg1) {
		String finalName="";
		
		if(userorpass.equalsIgnoreCase("Scroll_down")) 
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			
			
			
			scrName = "input_user";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		return finalName;
	}
	public String select(String userorpass, String val , String arg1) {
		String finalName="";
		int a=Integer.parseInt(val);
		if(userorpass.equalsIgnoreCase("select_room")) {
			Select s=new Select(driver.findElement(By.xpath(arg1)));
		s.selectByIndex(a);
			
			
			scrName = "input_user";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		return finalName;
	}
	public String Click(String vclick, String arg2, String arg3) 
	{
		String finalName="";
		System.out.println("inside click");
		if(vclick.equalsIgnoreCase("click_login")) 
		{
			System.out.println("inside click login");
			driver.findElement(By.xpath(arg3)).click();
			
			
			scrName = "Click_login";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		
		else if(vclick.equalsIgnoreCase("click_loginoption")) {
			System.out.println("inside click check in box");

			driver.findElement(By.xpath(arg3)).click();
			
			
			scrName = "click_loginoption";
			try {Thread.sleep(3000);}catch(InterruptedException e) {}
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		else if(vclick.equalsIgnoreCase("click_cibox")) {
			System.out.println("inside click check in box");

			driver.findElement(By.xpath(arg3)).click();
			
			
			scrName = "click_CheckIn";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		
		else if(vclick.equalsIgnoreCase("click_Fdate")) {
			System.out.println("inside click first date");
			driver.findElement(By.xpath(arg3)).click();
			
			
			scrName = "click_CheckInDate";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		else if(vclick.equalsIgnoreCase("click_cobox")) {
			System.out.println("inside click check out box");
			try {Thread.sleep(3000);}catch(InterruptedException e) {}
			driver.findElement(By.linkText(arg3)).click();
			
			
			scrName = "click_CheckOut";
			finalName=takeScreenShot(scrName);
			return finalName;
			
			
		}
		else if(vclick.equalsIgnoreCase("click_Sdate")) {
			System.out.println("inside click second date");
			try 
			{
				Thread.sleep(3000);
			}
			catch(InterruptedException e) {}
			driver.findElement(By.linkText(arg3)).click();
			
			
			scrName = "click_CheckOutDate";
			finalName=takeScreenShot(scrName);
			return finalName;
			
			
		}
		else if(vclick.equalsIgnoreCase("click_search")) {
			System.out.println("inside search button");
			try 
			{
				Thread.sleep(3000);
			}
			catch(InterruptedException e) {}
			driver.findElement(By.linkText(arg3)).click();
			
			
			scrName = "click_Search";
			finalName=takeScreenShot(scrName);
			return finalName;
			
			
		}

		else if(vclick.equalsIgnoreCase("click_reg")) {
			System.out.println("inside click reg page");
			try 
			{
				Thread.sleep(3000);
			}
			catch(InterruptedException e) {}

			//driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
			driver.findElement(By.xpath(arg3)).click();
			try 
			{
				Thread.sleep(3000);
			}
			catch(InterruptedException e) {}
			
			scrName = "click_Reg";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		else if(vclick.equalsIgnoreCase("click_loginb")) {
			System.out.println("inside login button");
			try 
			{
				Thread.sleep(3000);
			}
			catch(InterruptedException e) {}

			//driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
			driver.findElement(By.xpath(arg3)).click();
			try 
			{
				Thread.sleep(3000);
			}
			catch(InterruptedException e) {}
			
			scrName = "click_loginbutton";
			finalName=takeScreenShot(scrName);
			return finalName;
			
		}
		
		return finalName;
		
	}
//	public void Hower(String arg1, String arg2,String arg3) {
//		System.out.println("inside hower");
//		WebElement posts = driver.findElement(By.xpath(arg3));
//		try {Thread.sleep(3000);}catch(InterruptedException e) {}
//		Actions actions = new Actions(driver);
//		actions.moveToElement(posts).perform();
//		try {Thread.sleep(3000);}catch(InterruptedException e) {}
//		driver.findElement(By.xpath("//a[contains(text(),'Add New')]")).click();
//		System.out.println("howerdone");
//		
//	}
//	public void Handle(String arg1, String arg2,String arg3) {
//		System.out.println("inside handle");
//		try {Thread.sleep(5000);}catch(InterruptedException e) {}
//		driver.switchTo().window(handle);
//		
//	}
	
	public void quit(String arg1, String arg2,String arg3) {
		System.out.println("inside quit");
		try {Thread.sleep(2000);}catch(InterruptedException e) {}
		
		driver.quit();
		
		
	}

	public String takeScreenShot(String scrName) {
		
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File src = scrShot.getScreenshotAs(OutputType.FILE);
		String screenshotName = "C:\\Users\\M1047109\\Pictures\\scrshots\\";
		String finalName = screenshotName+""+scrName+""+".jpg";
		File dest = new File(finalName);
		try {
			FileUtils.copyFile(src,dest);
		} catch (IOException e1) {
			
			System.out.println("IOEXPN");
		}
		
		return finalName;
	}

	

}
