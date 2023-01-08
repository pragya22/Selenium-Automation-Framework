package com.mindtree.Pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mindtree.PageObject.BookFlightPageUi;
import com.mindtree.reusuablecomponents.AllObjects;

/*
 * Implementing all BookFlightPage actionkeywords in BookFlightPage class
 */

public class BookFlightPage extends AllObjects {



	// Creating Object and calling through page object model
	BookFlightPageUi bookFlightPageObject = PageFactory.initElements(driver, BookFlightPageUi.class);

	public void firstName() {
		commonlibraries.sendkeys(bookFlightPageObject.firstName, "Rodger");
	}

	public void lastName() throws Exception {
		commonlibraries.sendkeys(bookFlightPageObject.lastName, "Harry");
	}

	public void meal() throws Exception {
		Select select = new Select(bookFlightPageObject.meal);
		select.selectByVisibleText("Hindu");
	}

	public void cardType() throws Exception {
		Select select = new Select(bookFlightPageObject.cardType);
		select.selectByVisibleText("Visa");
	}
	public void expiryYear() throws Exception {
		Select select = new Select(bookFlightPageObject.expiryYear);
		select.selectByVisibleText("2010");
	}

	public void cardNumber() throws Exception {
		commonlibraries.sendkeys(bookFlightPageObject.cardNumber, "123456789");
	}

	public void expiryMonth() throws Exception {
		commonlibraries.sendkeys(bookFlightPageObject.expiryYear, "12");
	}
	public void cardFirstName() throws Exception {
		commonlibraries.sendkeys(bookFlightPageObject.cardFirstName, "Rodger");
	}

	public void cardLastName() throws Exception {
		commonlibraries.sendkeys(bookFlightPageObject.lastName, "Harry");
	}


	public void purchase() throws InterruptedException {
		commonlibraries.click(bookFlightPageObject.purchase);
		Thread.sleep(2000);
	}

	public void closeBrowser() {
		commonlibraries.tearDown(driver);
	}


}
