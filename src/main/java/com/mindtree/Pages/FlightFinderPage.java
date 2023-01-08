package com.mindtree.Pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mindtree.PageObject.FlightFinderPageUi;
import com.mindtree.reusuablecomponents.AllObjects;

public class FlightFinderPage extends AllObjects {

	/*
	 * Implementing all Search Flight actionkeywords in FlightFinderPage class
	 */
	// Creating Object and calling through page object model
	FlightFinderPageUi flightFinderObject = PageFactory.initElements(driver, FlightFinderPageUi.class);

	public void selectPassenger() throws InterruptedException {
		Select select = new Select(flightFinderObject.noOfPassengers);
		select.selectByVisibleText("1");

	}

	public void selectToMonth() throws InterruptedException {
		Select select = new Select(flightFinderObject.toMonth);
		select.selectByVisibleText("August");

	}
	
	public void selectFromMonth() throws InterruptedException {
		Select select = new Select(flightFinderObject.fromMonth);
		select.selectByVisibleText("July");

	}
	
	public void selectToPort() throws InterruptedException {
		Select select = new Select(flightFinderObject.toPort);
		select.selectByVisibleText("London");

	}

	public void selectFromPort() throws InterruptedException {
		Select select = new Select(flightFinderObject.departingFrom);
		select.selectByVisibleText("Paris");

	}

	public void selectFromDate() throws InterruptedException {
		Select select = new Select(flightFinderObject.fromDay);
		select.selectByVisibleText("1");

	}
	
	public void selectToDate() throws InterruptedException {
		Select select = new Select(flightFinderObject.toDay);
		select.selectByVisibleText("25");

	}

	public void selectServiceClass() throws InterruptedException {
		 commonlibraries.click(flightFinderObject.serviceClass);

	}

	public void selectAirline() throws InterruptedException {
		Select select = new Select(flightFinderObject.airline);
		select.selectByVisibleText("Blue Skies Airlines");

	}

	public void submit() throws InterruptedException {
		flightFinderObject.submit.click();

	}

}
