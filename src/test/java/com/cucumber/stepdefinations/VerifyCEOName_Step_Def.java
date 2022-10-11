package com.cucumber.stepdefinations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.cucumber.constants.Constants;
import com.cucumber.driverManager.DriverManager;
import com.cucumber.pageobjects.DirectoryPage;
import com.cucumber.pageobjects.LoginPage;
import com.cucumber.utilities.CommonUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyCEOName_Step_Def {

	private static final Logger LOGGER = LogManager.getLogger(VerifyCEOName_Step_Def.class);

	@Given("the user is logged in sucussfully and is on home page")
	public void the_user_is_logged_in_sucussfully_and_is_on_home_page() {

		try {

			DriverManager.getDriver().get(Constants.URL);

			LoginPage.getHomePageInstence().enterUserName(Constants.USERNAME);
			LoginPage.getHomePageInstence().enterPassword(Constants.PASSWORD);
			LoginPage.getHomePageInstence().clickLoginbtn();

			String currentURL = DriverManager.getDriver().getCurrentUrl();

			if (currentURL.contains("viewEmployeeList")) {
				LOGGER.info("the user is logged in sucussfully and is on home page");

			}

		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenShot();
			Assert.fail(e.getMessage());
		}
	}

	@When("the user clicks on the directory option from the menu bar")
	public void the_user_clicks_on_the_directory_option_from_the_menu_bar() {
		try {
			DirectoryPage.getDirectoryPageInsatance().clickDirectory();
			LOGGER.info("the user clicks on the directory option from the menu bar");
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenShot();
		}
	}

	@When("the user selects the job title as {string} from the dropdown list")
	public void the_user_selects_the_job_title_as_from_the_dropdown_list(String expectedJobtitle) {

		try {
			DirectoryPage.getDirectoryPageInsatance().clickOnJobTitledropdownfield();
			String actualjobtitleName = DirectoryPage.getDirectoryPageInsatance().selectJobTitle();

			if (actualjobtitleName.equalsIgnoreCase(expectedJobtitle)) {
				System.out.println("Both job title is matching hence, the testcase is passed.");
			}
			LOGGER.info("the user selects the job title as {string} from the dropdown list");
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenShot();
		}

	}

	@When("clicks the search button")
	public void clicks_the_search_button() {

		try {
			CommonUtils.getInstance().waituntillLoadWebElement();

			DirectoryPage.getDirectoryPageInsatance().clickSearchBtn();

			LOGGER.info("clicks the search button");
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenShot();
		}
	}

	@Then("the user should see the CEO name as {string}")
	public void the_user_should_see_the_ceo_name_as(String expected_Name) {

		try {
			String actualName = DirectoryPage.getDirectoryPageInsatance().getName();
			// 0System.out.println(actualName);
			if (actualName.equalsIgnoreCase(expected_Name)) {
				System.out.println("Verify the CEO is passed");
			}

			LOGGER.info("the user should see the CEO name as {string}");
		} catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenShot();
		}
	}
}
