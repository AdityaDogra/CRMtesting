package com.qa.crm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;
import com.qa.crm.utilities.UtilitiesClass;

public class ContactsPage extends TestBase {

	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;

//actions

public boolean contactslabelpresentornot(){
	return contactslabel.isDisplayed();
	
}}



