package com.cucumber.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cucumber.utilities.CommonUtils;

public class TimePage {

	private static TimePage timepageInstence = null;

	private TimePage() {

	}

	public static TimePage getTimePageInstance() {

		if (timepageInstence == null) {
			timepageInstence = new TimePage();
		}

		return timepageInstence;

	}

	@FindBy(xpath = "//span[text()='Time']")
	private WebElement timemenu;

	@FindBy(xpath = "//*[@placeholder='Type for hints...']")
	private WebElement employeeNameInputField;

	@FindBy(xpath = "//*[@role='option']/span[text()='John  Smith']")
	private WebElement selectNameFromSugession;

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement viewBtn;

	@FindBy(xpath = "//*[@role='alert']/div/child::i/following::p[text()='No Timesheets Found']")
	private WebElement message;

	public void clickOnTimemenu() {
		CommonUtils.getInstance().heighlightElement(timemenu);
		timemenu.click();
	}

	public void enterEmployeeName(String employeename) {
		CommonUtils.getInstance().heighlightElement(employeeNameInputField);
		employeeNameInputField.sendKeys(employeename);
		CommonUtils.getInstance().heighlightElement(selectNameFromSugession);
		String Empname = selectNameFromSugession.getText();

		if (Empname.startsWith(Empname)) {
			selectNameFromSugession.click();
		}

	}

	public void clickOnViewBtn() {
		CommonUtils.getInstance().heighlightElement(viewBtn);
		viewBtn.click();
	}

	public String getMessage() {
		CommonUtils.getInstance().heighlightElement(message);
		String msg = message.getText();
		return msg;
	}

	// *[@role='alert']/div/child::i/following::p[text()='No Timesheets Found']

}
