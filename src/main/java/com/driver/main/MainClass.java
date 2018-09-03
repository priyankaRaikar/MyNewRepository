package com.driver.main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.dataRead.DataRead;
import com.utility.Functionality;
 

public class MainClass {

	
		DataRead dr = new DataRead();
		Functionality fn = new Functionality();
		String arr[][] = new String[100][];
		String arr1[][] = new String[100][];
	  @Test
	  public void f() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		  
		  Method[] methods = Functionality.class.getDeclaredMethods();
		  try{arr = dr.getData(0);}catch(IOException i) {}
		  
		  
		  for(int i = 0 ; i < 6 ; i++) {
			  
			  for(int j = 0 ; j < methods.length ; j++) {
				  System.out.println("Method Name = "+methods[j].getName());
					  if(arr[i][0].equalsIgnoreCase(methods[j].getName()) ) {
						  
						  System.out.println("lol"+arr[i][0]+"================="+methods[j].getName());
						  if(methods[j].getName().equalsIgnoreCase("login")) {
							  System.out.println("bbblol");
						  }
						  
						  
						  //methods[j].invoke(fn, arr[i][0],arr[i][1],arr[i][2],arr[i][3]);
					  }
				  }
			  }
	  }
}
