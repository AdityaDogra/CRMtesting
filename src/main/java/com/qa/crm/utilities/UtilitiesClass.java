package com.qa.crm.utilities;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.qa.crm.base.TestBase;

public class UtilitiesClass extends TestBase {
	public UtilitiesClass() throws IOException {
		super();
	}

	public static void SwithchingFrame(String framename) throws IOException {

		driver.switchTo().frame(framename);  
	}
	
	public static void TakeScreenshot(WebDriver driver, String snipname) throws IOException {
		File scrshotfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrshotfile,new File ("C:\\Users\\LENOVO\\workspace\\MyFrameworkDesign\\src\\test\\Screenshots\\"+snipname));
	}

}

