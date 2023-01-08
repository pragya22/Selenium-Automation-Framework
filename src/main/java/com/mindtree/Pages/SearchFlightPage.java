package com.mindtree.Pages;

import org.openqa.selenium.support.PageFactory;

import com.mindtree.PageObject.SearchFlightUi;
import com.mindtree.reusuablecomponents.AllObjects;
import com.mindtree.utility.Scroll;

public class SearchFlightPage extends AllObjects{

	// Creating Object and calling through page object model
	SearchFlightUi searchFlightObject = PageFactory.initElements(driver, SearchFlightUi.class);

	public void submitFlight() throws InterruptedException {
		Scroll scroll = new Scroll();
		scroll.scrollDown();
		Thread.sleep(7000);
		commonlibraries.click(searchFlightObject.book);
	}
	
	public void closeBrowser() {
		commonlibraries.tearDown(driver);
	}
	
}
