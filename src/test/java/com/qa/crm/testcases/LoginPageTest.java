package com.qa.crm.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

import com.qa.crm.utilities.Testcase_Listner;
@Listeners(Testcase_Listner.class)
public class LoginPageTest extends TestBase {
 LoginPage loginpage;
 HomePage homepage;

public LoginPageTest() throws IOException {
		super();
		
	}

  @BeforeMethod
public void setup() throws IOException{
	browserlaunch();
	loginpage = new LoginPage();
}
  
  @Test(priority=1)
  public void loginpagetitletest() throws IOException{
	 String title=loginpage.fetch_page_title(); 
	 Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
  }
  
  @Test(priority=3)
  public void crmlogotest() throws IOException{
	 Assert.assertTrue(loginpage.Validate_crmlogo());
  }
  
  @Test(priority=2)
  public void logintest() throws IOException{
   homepage=loginpage.login(file.getProperty("username"), file.getProperty("password"));
  }
  @AfterMethod
  public static void teardown() throws IOException{
  	driver.quit();
  	
  }	
}
