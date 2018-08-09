package com.qa.crm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;

public class LoginPage extends TestBase{
     
	//PageFactory : OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[contains(@class,'btn btn-small')]")
	WebElement LoginBtn;
	
	@FindBy(xpath="//a[@href='https://www.freecrm.com/register/']")
	WebElement signupBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;

//Initialise the page objects
public LoginPage() throws IOException{
	
	PageFactory.initElements(driver,this);
}
//Actions on this page

public String fetch_page_title(){
	return driver.getTitle();
	
}
public boolean Validate_crmlogo (){
	return crmlogo.isDisplayed();
	
}
public HomePage login(String un, String pw) throws IOException{
	
	username.sendKeys(un);
	password.sendKeys(pw);
	LoginBtn.submit();
	return new HomePage();
}
}


