package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	
	@FindBy(xpath = "//a[@class = 'sign-in']")
	private WebElement loginRegLink;

	@FindBy(xpath = "//a[@href = '#tab2']")
	private WebElement regLink;

	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id ="first-name")
	private WebElement firstName;
	
	@FindBy(id ="last-name")
	private WebElement lastName;
	
	@FindBy(name="submit")
	private WebElement regBtn; 

	@FindBy(xpath = "//*[@id=\"tab1\"]/form/p[4]/a")
	private WebElement lostPwd;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickLoginRegLink() {
		this.loginRegLink.click(); 
	}
	
	public void clickRegLink() {
		this.regLink.click(); 
	}
	
	public void sendEmail(String email) {
		this.email.clear(); 
		this.email.sendKeys(email); 
	}
	
	public void sendFirstName(String fName) {
		
		this.firstName.clear(); 
		this.firstName.sendKeys(fName); 
	}

	public void sendlastName(String lName) {
		this.lastName.clear(); 
		this.lastName.sendKeys(lName); 
	}
	
	public void clickRegBtn() {
		this.regBtn.click(); 
	}
	
	public void clickLostPwd() {
		this.lostPwd.click(); 
	}
}
