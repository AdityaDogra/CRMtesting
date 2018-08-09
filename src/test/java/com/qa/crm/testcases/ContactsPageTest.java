package com.qa.crm.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.utilities.Testcase_Listner;
@Listeners(Testcase_Listner.class)
public class ContactsPageTest extends TestBase {
	public ContactsPageTest() throws IOException {
		super();
		
	}

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	 @BeforeMethod
	 public void setup() throws IOException{
	 	browserlaunch();
	 	loginpage = new LoginPage();
	 	homepage=loginpage.login(file.getProperty("username"), file.getProperty("password"));
	 	homepage.clickoncontactslink();
	 }
	 
	 @Test(priority=1)
	 public void verifycontactslabel() throws IOException{
	      Assert.assertTrue(contactspage.contactslabelpresentornot());
		 
	 }
	 
	
	 @AfterMethod
	 public void teardown() throws IOException{
	 	driver.quit();
	 }
	
}
