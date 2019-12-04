package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

public class SearchPOM {
	
	private WebDriver driver; 
	Assertion assrt = new Assertion();
	
	public SearchPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//*[@id=\"menu-item-571\"]/a")
	private WebElement villas;
	
	@FindBy(xpath = "//*[@id=\"realteo-search-form\"]/div[3]/div/button")
	private WebElement btnsearch;
	
	@FindBy(xpath = "//*[@id=\"menu-item-617\"]/a")
	private WebElement blog;
	
	@FindBy (xpath = "//*[@id=\"ajaxsearchlite1\"]/div/div[3]/form/input[1]")
	private WebElement blogSearchInput;
	
	@FindBy(xpath = "//*[@id=\"mCSBap_1_container\"]/div/div[1]/div[1]/h3/a/span")
	private WebElement getSearchRes;
	
	//@FindBy(xpath = "//*[@id=\"ajaxsearchlite1\"]/div/div[1]/div/svg")
	//private WebElement btnBlogSearch;
	
	@FindBy (xpath = "//*[@id=\"wpcf7-f4-o1\"]/form/p[1]/label/span/input")
	private WebElement blogSearchInputName;
	
	@FindBy (xpath = "//*[@id=\"wpcf7-f4-o1\"]/form/p[2]/label/span/input")
	private WebElement blogSearchInputEmail;
	
	@FindBy (xpath = "//*[@id=\"wpcf7-f4-o1\"]/form/p[3]/label/span/input")
	private WebElement blogSearchInputSub;
	
	@FindBy (xpath = "//*[@id=\"wpcf7-f4-o1\"]/form/p[4]/label/span/textarea")
	private WebElement blogSearchInputMsg;
	
	@FindBy(xpath = "//*[@id=\"wpcf7-f4-o1\"]/form/p[4]/label/span/textarea")
	private WebElement btnEnquiry;
	
	public void clickVillas(){
		this.villas.click();
	}
	public void clickBtnSearch() {
		this.btnsearch.click();
	}
	
	public void ClickBlog(){
		this.blog.click();	
	}
	public void inputBlogSearch(String input) {
		this.blogSearchInput.sendKeys(input);
		this.getSearchRes.click();
		//this.btnBlogSearch.click();
	}

	public void inputBlogSearch(String name, String email, String subject, String msg ) {
		this.blogSearchInputName.sendKeys(name);
		this.blogSearchInputEmail.sendKeys(email);
		this.blogSearchInputSub.sendKeys(subject);
		this.blogSearchInputMsg.sendKeys(msg);
		this.btnEnquiry.click();
	}
	
}

