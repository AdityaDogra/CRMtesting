package com.qa.crm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;
import com.qa.crm.utilities.UtilitiesClass;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: Aditya DOGRA')]")
	WebElement usernamelabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink; 
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskslink;
	//Initialise the page objects
	public HomePage() throws IOException{
		
		PageFactory.initElements(driver,this);
	}
	//Actions on this page

	public String verifyhomepagetitle(){
		return driver.getTitle();
		
	}	
	public ContactsPage clickoncontactslink() throws IOException{
		UtilitiesClass.SwithchingFrame("mainpanel");
		contactslink.click();
		return new ContactsPage();
	}
	public DealsPage clickondealslink() throws IOException{
		UtilitiesClass.SwithchingFrame("mainpanel");
		dealslink.click();
		return new DealsPage();
	}
	public TasksPage clickontaskslink() throws IOException{
		UtilitiesClass.SwithchingFrame("mainpanel");
		taskslink.click();
		return new TasksPage();
	}
	public boolean username() throws IOException{
		UtilitiesClass.SwithchingFrame("mainpanel");
		return usernamelabel.isDisplayed();
	}
}
