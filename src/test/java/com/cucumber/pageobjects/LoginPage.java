package com.cucumber.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.cucumber.utilities.CommonUtils;

public class LoginPage {
	
	private static LoginPage loginInstance;
	
	private LoginPage() {
		
	}
	public static LoginPage getHomePageInstence() {
		
		if(loginInstance==null) {
			loginInstance = new LoginPage();
		}
		return loginInstance;
		
	}
	
	@FindBy(how = How.XPATH,using = "//*[@name='username']")
	private  WebElement UserName;
	@FindBy(how = How.XPATH,using = "//*[@name='password']")
	private  WebElement Password;
	@FindBy(how =How.XPATH,using="//button[@type='submit']")
	private  WebElement Loginbtn;
	/*
	public WebElement getUserName() {
		return UserName;
	}
	public WebElement getPassword() {
		return Password;
	}
	public WebElement getLoginbtn() {
		return Loginbtn;
	}
	*/
	
	public void enterUserName(String uname) {
		CommonUtils.getInstance().heighlightElement(UserName);
		UserName.sendKeys(uname);
	}
	public void enterPassword(String psw) {
		CommonUtils.getInstance().heighlightElement(Password);
		Password.sendKeys(psw);
		
	}
	
	public void clickLoginbtn() {
		CommonUtils.getInstance().heighlightElement(Loginbtn);
		Loginbtn.click();
	}
	

}
