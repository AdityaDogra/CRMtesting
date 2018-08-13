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

	@FindBy(xpath="//td[@align='left' and contains(text(),'Contacts')]")
	WebElement contactslabel;

	@FindBy(xpath="//legend[contains(text(),'Contact Information') and @class ='fieldset']")
	WebElement ContactInformationLabel;
	//actions

	public boolean contactslabelpresentornot(){
		return contactslabel.isDisplayed();

	}

	public boolean ContactInformationLabelispresentornot(){
		return ContactInformationLabel.isDisplayed();

	}
}



