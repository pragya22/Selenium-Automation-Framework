package com.mindtree.Pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mindtree.PageObject.LoginPageUi;
import com.mindtree.reusuablecomponents.AllObjects;

/*
 * Implementing all LoginPage actionkeywords in LoginPage class
 */

public class LoginPage extends AllObjects {

	//     public static WebDriver driver;

	public String dataPassToWebelement;

	public WebElement webelementPath;

	static String winHandleBefore = "";

	// Creating Object and calling through page object model
	LoginPageUi loginPageObject = PageFactory.initElements(driver, LoginPageUi.class);

	public void openBrowser() throws FileNotFoundException, IOException, InterruptedException {
		driver = commonlibraries.setUp();

	}

	public void navigate() throws FileNotFoundException, IOException {
		driver.get(propertyFiledata.takeDataFromProperty().getProperty("url"));
	}


	public void username(String username) throws Exception {
		commonlibraries.sendkeys(loginPageObject.userName, username);
	}

	public void password(String password) throws Exception {

		commonlibraries.sendkeys(loginPageObject.password, password,Keys.ENTER);
	}

	public void submiit() throws InterruptedException {
		//commonlibraries.webdriverWait(loginPageObject.loginbutton, driver, 5);
		commonlibraries.click(loginPageObject.loginbutton);
		//commonlibraries.webdriverWait(loginPageObject.logout, driver, 5);
	}
	public void falseValidate() {
		Assert.assertTrue(driver.getCurrentUrl().contains("http://newtours.demoaut.com/mercurysignon.php"));
	}
	public void trueValidate() {
		Assert.assertTrue(driver.getCurrentUrl().startsWith("http://newtours.demoaut.com/mercuryreservation.php?"));            
	}



}
