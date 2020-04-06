package com.jalesh.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.jalesh.qa.util.TesttimeUtil;

public class TestBase {
	
	static WebDriver driver;
	static Properties prop;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:/Users/sudheer.indlamudi/eclipse-workspace/FrameWork/src/main/java/com/jalesh/"
					+ "qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
		public static void initialization() {
			String browserName = prop.getProperty("browser");
			if(browserName.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "E:/geckodriver-v0.26.0-win64/geckodriver.exe");
		        driver = new ChromeDriver();
			}
			else if(browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32/chromedriver.exe");
		        driver = new FirefoxDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TesttimeUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TesttimeUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
		}
	
	
	
}
