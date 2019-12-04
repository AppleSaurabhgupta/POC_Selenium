package com.training.assignment;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddUserPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class RETC_035_AddNewUser {
 
  	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private AddUserPOM AddUserPOM;
	

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		AddUserPOM = new AddUserPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		
		String userName = "manzoor22";
		String email = "manzoor22@gmail.com";
			
		loginPOM.clickLoginRegLink();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		AddUserPOM.clickUsers();
		AddUserPOM.getListOfUsers("Add New", "All Users", "Your Profile");
		AddUserPOM.clickAddNew();
		AddUserPOM.enterUserName(userName);
		AddUserPOM.enterEmail(email);
		AddUserPOM.enterFirstName("Manzoor");
		AddUserPOM.enterLastName("Mehadi");
		AddUserPOM.enterWebSite("www.google.com");
		AddUserPOM.clickShowPwd();
		AddUserPOM.enterPwd("Manzoor@Mehadi123");
		AddUserPOM.clickRole();
		AddUserPOM.clickBtnAddNewUser();	
		AddUserPOM.getMsg("New user created. Edit user");
		AddUserPOM.searchUser(userName);
		Thread.sleep(7000);	
	}
	

}
