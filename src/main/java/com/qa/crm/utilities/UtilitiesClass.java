package com.qa.crm.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

	public static void navigatefromhomepage(String tabname){

		ArrayList<WebElement> tabs=new ArrayList<WebElement>();
		tabs.addAll(driver.findElements(By.xpath("//*[@id='navmenu']/ul/li[*]")));
		for (int x=0;x<tabs.size();x++){
			System.out.println(tabs.get(x).getText());	

			if (tabs.get(x).getText().contains(tabname)){
				tabs.get(x).click();	
				System.out.println(tabs.get(x).getText()+" is clicked");

			}

		}System.out.println("tab name not found on page");
	}

}








