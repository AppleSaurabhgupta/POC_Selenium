package com.training.assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddUserPOM;
import com.training.pom.LoginPOM;
import com.training.pom.SearchPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_037_SearchPlotsDetails {
  
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private SearchPOM SearchPOM;
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
		SearchPOM = new SearchPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		
		String userName = "manzoor22";
		String email = "manzoor22@gmail.com";
			
		loginPOM.clickLoginRegLink();
		loginPOM.sendUserName(userName);
		loginPOM.sendPassword("Manzoor@Mehadi123");
		loginPOM.clickLoginBtn(); 
		SearchPOM.clickVillas();
		SearchPOM.clickBtnSearch();
		
	}
}
		
