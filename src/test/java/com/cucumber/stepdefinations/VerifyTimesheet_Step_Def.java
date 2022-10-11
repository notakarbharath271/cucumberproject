package com.cucumber.stepdefinations;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.cucumber.driverManager.DriverManager;
import com.cucumber.pageobjects.TimePage;
import com.cucumber.utilities.CommonUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class VerifyTimesheet_Step_Def {
	 
	private static final Logger LOGGER = LogManager.getLogger(VerifyTimesheet_Step_Def.class);
	
	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() {
		try {
		String currenturl =DriverManager.getDriver().getCurrentUrl();
		if(currenturl.contains("viewEmployeeList")) {
			LOGGER.info("the user is on the home page");
		}
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenShot();
		}
		
	}

	@Given("the user clicks on the time option from the menu")
	public void the_user_clicks_on_the_time_option_from_the_menu() {
		try {
		TimePage.getTimePageInstance().clickOnTimemenu();
		
		LOGGER.info("the user clicks on the time option from the menu");
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenShot();
			
		}
	}
	
	

	@Given("the user enter the name as {string}")
	public void the_user_enter_the_name_as(String EmpName) {
		try {
		TimePage.getTimePageInstance().enterEmployeeName(EmpName);
		LOGGER.info("the user enter the name as {string}");
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenShot();
			Assert.fail(e.getMessage());
		}
	}

	@Given("clicks on the views button")
	public void clicks_on_the_views_button() {
		try {
		TimePage.getTimePageInstance().clickOnViewBtn();
		LOGGER.info("clicks on the views button");
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenShot();
		}
	    
	}

	@Then("the user should see the message as {string}")
	public void the_user_should_see_the_message_as(String expexteMessage) {
		try {
			String actualMessage = TimePage.getTimePageInstance().getMessage();
			if(actualMessage.equals(expexteMessage)) {
		LOGGER.info("the user should see the message as {string}");
			}
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenShot();
		}
	    
	}

}
