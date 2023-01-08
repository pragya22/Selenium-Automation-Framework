package com.mindtree.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SearchFlightUi {
	
	@FindBy(xpath = "//input[@value='Blue Skies Airlines$361$271$7:10']")
	@CacheLookup
	public WebElement departureFlight;

	@FindBy(xpath = "//input[@src='/images/forms/continue.gif']")
	@CacheLookup
	public WebElement returnFlight;

	@FindBy(xpath = "//input[@type='image']")
	@CacheLookup
	public WebElement book;


}
