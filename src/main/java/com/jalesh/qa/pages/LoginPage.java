package com.jalesh.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.jalesh.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory or Object Repository:
	
	@FindBy(xpath = "//img[@class=\"newheadr_logo\"]")
	WebElement jaleshlogo;
	
	@FindBy(xpath = "//a[@class=\"login_btn\"]")
	WebElement login_btn;
	
	@FindBy(xpath = "//input[@type=\"email\"][@id=\"login_string\"]")
	WebElement user_name;
	
	@FindBy(xpath = "//input[@type=\"password\"][@id=\"login_pass\"]")
	WebElement password;
	
	@FindBy(xpath = "//button[@type=\"button\"][@class=\"btn btn-primary submit_login\"]")
	WebElement loginbtn;
	
	//Initialization the page objects:
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean JaleshImage() {
		return jaleshlogo.isDisplayed();
				
	}
	
	public HomePage Login(String un, String pwd) {
		login_btn.click();
		user_name.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		
		return new HomePage();
	}
	
	
}
