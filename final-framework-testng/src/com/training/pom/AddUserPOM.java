package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

public class AddUserPOM {
	private WebDriver driver; 
	
	public AddUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	Assertion assrt = new Assertion();

	@FindBy(xpath = "//*[@id=\"menu-users\"]/a/div[3]")
	private WebElement users;
	
	@FindBy(xpath = "//*[@id=\"menu-users\"]/ul/li[2]/a")
	private WebElement listOfUsers_AllUsers;
	 
	@FindBy(xpath = "//*[@id=\"menu-users\"]/ul/li[3]/a")
	private WebElement listOfUsers_AddNew;
	
	@FindBy(xpath = "//*[@id=\"menu-users\"]/ul/li[4]/a")
	private WebElement listOfUsers_YourProfile;
	
	//@FindBy(xpath = "//*[@id=\"wpbody-content\"]/div[3]/a")
	//private WebElement AddNewUser;
	
	@FindBy(xpath = "//*[@id=\"user_login\"]")
	private WebElement userName;
	
	@FindBy(xpath = "//*[@id=\"email\"]")
	private WebElement emailId;
	
	@FindBy(xpath = "//*[@id=\"first_name\"]")
	private WebElement FName;
	
	@FindBy(xpath = "//*[@id=\"last_name\"]")
	private WebElement LName;
	
	@FindBy(xpath = "//*[@id=\"url\"]")
	private WebElement website;
	
	@FindBy(xpath = "//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button")
	private WebElement showPwd;

	@FindBy(xpath = "//*[@id=\"pass1-text\"]")
	private WebElement enterPwd;
	
	@FindBy(xpath = "//*[@id=\"role\"]")
	private WebElement role;
	
	@FindBy (xpath = "//*[@id=\"role\"]/option[3]")
	private WebElement selectRole;
	
	@FindBy (xpath = "//*[@id=\"createusersub\"]")
	private WebElement btnAddNewRole;
	
	@FindBy(xpath = "//*[@id=\"message\"]/p")
	private WebElement msgAddNewUser;
	
	@FindBy(xpath = "//*[@id=\"user-search-input\"]")
	private WebElement searchUsers;
	
	@FindBy(xpath = "//*[@id=\"search-submit\"]")
	private WebElement btnSearchUsers;
	
	@FindBy(xpath = "//*[@id=\"the-list\"]/tr[1]/td[1]")
	private WebElement getSearchUser;

	
	
	//------------------------------------Methods----------------------------------------
	public void clickUsers() {
		this.users.click(); 
	}

	public void getListOfUsers (String addNew, String allUsers, String yourProfile) {
		String lstAddNew = this.listOfUsers_AddNew.getText().toString();
		String lstAllUsers = this.listOfUsers_AllUsers.getText().toString();
		String lstYourProfile = this.listOfUsers_YourProfile.getText().toString();
				
		System.out.println(" Here is the lists: " + lstAddNew + ", " + lstAllUsers + ", " + lstYourProfile);
		
		if((lstAddNew.equals(addNew)) && lstAllUsers.equals(allUsers) && lstYourProfile.equals(yourProfile)) 
			System.out.println(" Link are displaying");
		else
			System.out.println(" Links are NOT displaying");
		
		assrt.assertEquals(lstAddNew, addNew);
		assrt.assertEquals(lstAllUsers, allUsers);
		assrt.assertEquals(lstYourProfile, yourProfile);
		
	}
		
	public void clickAddNew() {
		this.listOfUsers_AddNew.click(); 
	}
	
	public void enterUserName(String name) {
		this.userName.sendKeys(name); 
	}
	
	public void enterEmail(String email) {
		this.emailId.sendKeys(email);
	}
	
	public void enterFirstName(String firstName) {
		this.FName.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		this.LName.sendKeys(lastName);
	}
	
	public void enterWebSite(String websiteName) {
		this.website.sendKeys(websiteName);
	}
	
	public void clickShowPwd() {
		this.showPwd.click();
	}
	
	public void enterPwd(String pwd) {
		this.enterPwd.clear();
		this.enterPwd.sendKeys(pwd);
	}
	
	public void clickRole() {
		this.role.click();
		this.selectRole.click();	 
	}
	
	public void clickBtnAddNewUser() {
		this.btnAddNewRole.click();
	}
	
	public void getMsg(String expectedWelcomeMsg) {
		String actualWelcomeMsg = this.msgAddNewUser.getText().toString();
		System.out.println("Welcome Messgae: " + actualWelcomeMsg);
		assrt.assertEquals(expectedWelcomeMsg, actualWelcomeMsg);	
	}
	
	public void searchUser(String searchVal) {
		this.listOfUsers_AllUsers.click();
		this.searchUsers.sendKeys(searchVal);
		this.btnSearchUsers.click();
		String getSearchUser = this.getSearchUser.getText().toString();
		assrt.assertEquals(searchVal, getSearchUser);
	}
	
	
}
