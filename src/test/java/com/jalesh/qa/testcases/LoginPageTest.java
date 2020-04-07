package com.jalesh.qa.testcases;

import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.jalesh.qa.base.TestBase;
import com.jalesh.qa.pages.HomePage;
import com.jalesh.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage LoginPage;
	HomePage homepage;

public LoginPageTest() {	
	super();
	
}
	
	@BeforeMethod
	public void Setup() {
		//testBase = new TestBase();
		initialization();
		LoginPage = new LoginPage();
	}
	
	@Test
	public void loginPageTitleTest() {
		String title = LoginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Jalesh Cruises | Best Premium Cruises in India");
		
	}
	
	@Test
	public void jaleshLogoTest() {
		boolean flag = LoginPage.JaleshImage();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void LoginTest() {
		homepage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
