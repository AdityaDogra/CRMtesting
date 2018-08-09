package com.qa.crm.utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.crm.base.TestBase;


public  class Testcase_Listner extends TestBase implements ITestListener{
	public Testcase_Listner() throws IOException {
		super();
		
	}

	
	
	public void onTestFailure(ITestResult arg0) {
	try {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String methodname=arg0.getMethod().getMethodName();
		UtilitiesClass.TakeScreenshot(driver, methodname+"_Failed_.png");
	} catch (IOException e) {
		e.printStackTrace();
	}}
		
	

	public void onTestSuccess(ITestResult arg0) {
		
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String methodname=arg0.getMethod().getMethodName();
			UtilitiesClass.TakeScreenshot(driver, methodname+".png");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}



	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}



	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}



	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}



	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}



	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	}

	


