package com.cucumber.pageobjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.constants.Constants;
import com.cucumber.driverManager.DriverManager;
import com.cucumber.utilities.CommonUtils;

public class DirectoryPage {
	 private static DirectoryPage directoryPageInstance;
	 
	 private DirectoryPage() {
		 
	 }
	 public static DirectoryPage getDirectoryPageInsatance() {
		 
		 if(directoryPageInstance==null) {
			 directoryPageInstance=new DirectoryPage();
		 }
		 
		return directoryPageInstance;
		 
	 }
	
	@FindBy(linkText = "Directory")
	private  WebElement DIRECTORY;
	
	@FindBy(xpath = "//label[text()='Job Title']/parent::div/following-sibling::div/div")
	private WebElement JOB_TITLE;
	
	@FindBy(xpath = "//div[@role='option']/span")
	private List<WebElement> JOB_TITLE_LIST;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	private WebElement DIREC_SEARCH_BTN;
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-directory-card-header --break-words']")
	private WebElement NAME;

	/*
	public WebElement getDIRECTORY() {
		return DIRECTORY;
	}

	public WebElement getJOB_TITLE() {
		return JOB_TITLE;
	}

	public List<WebElement> getWebElementJOB_TITLE_LIST() {
		return WebElementJOB_TITLE_LIST;
	}

	public WebElement getDIREC_SEARCH_BTN() {
		return DIREC_SEARCH_BTN;
	}

	public WebElement getNAME() {
		return NAME;
	}
	
	*/
	
	public void clickDirectory() {
		CommonUtils.getInstance().heighlightElement(DIRECTORY);
		DIRECTORY.click();
	}
	
	public void clickOnJobTitledropdownfield() {
		CommonUtils.getInstance().heighlightElement(JOB_TITLE);
		JOB_TITLE.click();
	}
	
	public String selectJobTitle() {
		
		String actualjobtitle="";
		try {
			
			Iterator<WebElement> listJobtitles = DirectoryPage.getDirectoryPageInsatance().JOB_TITLE_LIST
					.iterator();
			while (listJobtitles.hasNext()) {
				WebElement jobtitle = listJobtitles.next();
						if(jobtitle.getText().equalsIgnoreCase(Constants.JOBTITLENAME))	{
							jobtitle.click();
						}
				 actualjobtitle = jobtitle.getText();
				
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return actualjobtitle;
	}
	
	
	public void clickSearchBtn() {
		CommonUtils.getInstance().heighlightElement(DIREC_SEARCH_BTN);
		WebDriverWait driverWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(3000));
		driverWait.until(ExpectedConditions
				.elementToBeClickable(DirectoryPage.getDirectoryPageInsatance().DIREC_SEARCH_BTN));
		
		DIREC_SEARCH_BTN.click();
		
	}
	
	public String getName() {
		String actualName ="";
		CommonUtils.getInstance().heighlightElement(NAME);
		 actualName = DirectoryPage.getDirectoryPageInsatance().NAME.getText();
		//System.out.println(actualName);
		return actualName;
	}
	

}
