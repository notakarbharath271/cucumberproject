package com.cucumber.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.constants.Constants;
import com.cucumber.driverManager.DriverManager;
import com.cucumber.pageobjects.DirectoryPage;
import com.cucumber.pageobjects.LoginPage;
import com.cucumber.pageobjects.TimePage;
import com.cucumber.stepdefinations.Common_Step_Def;

public class CommonUtils {
	
	private static final Logger LOGGER = LogManager.getLogger(CommonUtils.getInstance());

	private static CommonUtils CommonUtilsinstance = null;

	private CommonUtils() {

	}

	public static CommonUtils getInstance() {

		if (CommonUtilsinstance == null) {
			CommonUtilsinstance = new CommonUtils();
		}
		return CommonUtilsinstance;

	}

	public void loadProperties() {
		/*
		 * first way to read the properties file FileReader reader = null; try { reader
		 * = new FileReader("Config.properties"); } catch (FileNotFoundException e) {
		 * e.printStackTrace(); } Properties properties = new Properties(); try {
		 * properties.load(reader); } catch (IOException e) { e.printStackTrace(); }
		 */
		// second way to read the properties file
		Properties properties = new Properties();

		try {
			properties.load(getClass().getResourceAsStream("/Config.properties"));
		} catch (Exception e) {
			// TODO: handle exception
		}

		Constants.BROWSER = properties.getProperty("BROWSER");
		Constants.URL = properties.getProperty("URL");
		Constants.USERNAME = properties.getProperty("UserName");
		Constants.PASSWORD = properties.getProperty("Password");
		Constants.JOBTITLENAME = properties.getProperty("JobTitle");

	}

	public void initWebElement() {
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getHomePageInstence());
		PageFactory.initElements(DriverManager.getDriver(), DirectoryPage.getDirectoryPageInsatance());
		PageFactory.initElements(DriverManager.getDriver(), TimePage.getTimePageInstance());
	}

	public void waituntillLoadWebElement() {
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}

	public void takeScreenShot() {
		File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(Common_Step_Def.getScenarioName()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	public void heighlightElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].setAttribute('style','border:3px solid green');", element);

	}

	public void selectdropdown(WebElement dropElement, String howTo, String value) {
		Select select = new Select(dropElement);

		switch (howTo) {
		case "text":
				select.selectByVisibleText(value);
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;

		default:
			LOGGER.info("Please provid the valid selector. The valid selection are text , value, index ");
			break;
		}
	}

}
