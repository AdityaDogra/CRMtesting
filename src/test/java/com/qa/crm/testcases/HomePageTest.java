package com.qa.crm.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.qa.crm.base.TestBase;
import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.utilities.TakeScreenshot;
import com.qa.crm.utilities.Testcase_Listner;

@Listeners(Testcase_Listner.class)


public class HomePageTest extends TestBase {
	static Logger log=Logger.getLogger(HomePageTest.class);
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	public HomePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException{
		browserlaunch();
		loginpage = new LoginPage();
		homepage=loginpage.login(file.getProperty("username"), file.getProperty("password"));
	}

	@Test(priority=1)
	public void verifyhomepagetitletest() throws IOException{
		log.info("******************HomePageTestStarts*****************");
		String titlefromhomepage= homepage.verifyhomepagetitle();
		Assert.assertEquals(titlefromhomepage, "CRMPRO","The Title is not expected");
	}

	@Test(priority=2)
	public void verifyusername() throws IOException{
		Assert.assertTrue(homepage.username());

	}

	@Test(priority=3)
	public void verifycontactslink() throws IOException{
		contactspage=homepage.clickoncontactslink();}

	@Test(priority=4)
	public void navigateonnewcontacts() throws IOException{
		contactspage=homepage.selecttheunderlyingfieldsfromcontactstab("New Contact");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(contactspage.ContactInformationLabelispresentornot());
	}


	@AfterMethod
	public void teardown() throws IOException{
		log.info("******************HomePageTestEnds*****************");
		driver.quit();
	}
}

