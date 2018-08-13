package com.qa.crm.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

	@FindBy(xpath="//*[@id='navmenu']/ul/li[4]//ul/li[1]")
	WebElement NewContact;
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

	public  ContactsPage selecttheunderlyingfieldsfromcontactstab(String ubderthetabname) throws IOException{
		UtilitiesClass.SwithchingFrame("mainpanel");
		Actions act= new Actions(driver);
		act.moveToElement(contactslink).perform();
		ArrayList<WebElement> underthetab=new ArrayList<WebElement>();
		underthetab.addAll(driver.findElements(By.xpath("//*[@id='navmenu']/ul/li[4]/ul/li[*]")));
		for (int x=0;x<=underthetab.size();x++){
			System.out.println(underthetab.get(x).getText());	

			if (underthetab.get(x).getText().contains(ubderthetabname)){
				underthetab.get(x).click();
				System.out.println(underthetab.get(x).getText()+" is clicked");
				break;}
		} return new ContactsPage();
	}}
