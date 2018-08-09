package com.qa.crm.utilities;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.crm.base.TestBase;

public class TakeScreenshot extends TestBase {

		public TakeScreenshot(WebDriver driver, String snipname) throws IOException {
			File scrshotfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrshotfile,new File ("C:\\Users\\LENOVO\\workspace\\MyFrameworkDesign\\src\\test\\Screenshots\\"+snipname));
		}
	
}
