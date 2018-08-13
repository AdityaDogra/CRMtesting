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



	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+" test case is failed");
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String methodname=result.getMethod().getMethodName();
			UtilitiesClass.TakeScreenshot(driver, methodname+"_Failed_.png");
		} catch (IOException e) {
			e.printStackTrace();
		}}



	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+" test case is passed");
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String methodname=result.getMethod().getMethodName();
			UtilitiesClass.TakeScreenshot(driver, methodname+".png");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}



	public void onFinish(ITestContext context) {
		System.out.println(context.getEndDate()+" test Finished");
		System.out.println(context.getFailedTests()+" these tests got failed");

	}



	public void onStart(ITestContext context) {
		System.out.println(context.getStartDate()+" test started");

	}



	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}



	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName()+" test case is skipped");

	}



	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+" test case is starting");

	}

}




