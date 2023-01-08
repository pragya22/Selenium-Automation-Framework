
package com.mindtree.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class FlightFinderPageUi {

	/*
	 *This is a class which contains all locators or web elements of
	 * Search  page
	 
	 */

	@FindBy(name = "//input[@value='oneway']")
	@CacheLookup
	public WebElement tripType;
	
	@FindBy(xpath = "//select[@name='passCount']")
	@CacheLookup
	public WebElement noOfPassengers;

	@FindBy(name = "fromPort")
	@CacheLookup
	public WebElement departingFrom;
	
	@FindBy(name = "fromMonth")
	@CacheLookup
	public WebElement fromMonth;

	@FindBy(name = "fromDay")
	@CacheLookup
	public WebElement fromDay;

	@FindBy(name = "toPort")
	@CacheLookup
	public WebElement toPort;

	@FindBy(name = "toMonth")
	@CacheLookup
	public WebElement toMonth;

	@FindBy(name = "toDay")
	@CacheLookup
	public WebElement toDay;

	@FindBy(xpath = "//input[@value='Business']")
	@CacheLookup
	public WebElement serviceClass;

	@FindBy(name = "airline")
	@CacheLookup
	public WebElement airline;
	
	@FindBy(xpath = "//input[@name='findFlights']")
	@CacheLookup
	public WebElement submit;


}
