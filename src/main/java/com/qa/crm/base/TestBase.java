package com.qa.crm.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties file;
	/**
	 * This method is for reading config.propertiesfile
	 * @throws IOException 
	 */
	public TestBase() throws IOException{
		file = new Properties();
		FileInputStream keyfile = new FileInputStream("C:\\Users\\LENOVO\\workspace\\MyFrameworkDesign\\src\\main\\java\\com\\qa\\crm\\config\\config.properties");	
		file.load(keyfile);

	}

	/**
	 * This method is for browser launch
	 */
	public static void browserlaunch(){
		String browsername=file.getProperty("browser");
		if (browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",file.getProperty("pathofchromeexefile"));
			ChromeOptions options= new ChromeOptions();
			options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);//will load the DOM means basic html code not images which will take time to load
			driver = new ChromeDriver();
			System.out.println("The Chrome browser is opened");
		}
		else {
			System.setProperty("webdriver.ie.driver", file.getProperty("pathofIEexefile"));
			driver =new InternetExplorerDriver();
			System.out.println("The IE browser is opened");	
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(file.getProperty("url"));
	}
}




