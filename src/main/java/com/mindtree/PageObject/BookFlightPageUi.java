package com.mindtree.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
 * SignUpPageUi is a class which contains all locators or webelements of SignUpPage 
 *  of  project 
 * 
 */

public class BookFlightPageUi {

	@FindBy(xpath = "//input[@name='passFirst0']")
	public WebElement firstName;

	@FindBy(xpath = "//input[@name='passLast0']")
	public WebElement lastName;

	@FindBy(xpath = "//select[@name='pass.0.meal']")
	public WebElement meal;

	@FindBy(xpath = "//select[@name='creditCard']")
	public WebElement cardType;

	@FindBy(xpath = "//input[@name='creditnumber']")
	public WebElement cardNumber;

	@FindBy(xpath = "//select[@name='cc_exp_dt_mn']")
	public WebElement expiryMonth;

	@FindBy(xpath = "//select[@name='cc_exp_dt_yr']")
	public WebElement expiryYear;

	@FindBy(xpath = "//input[@name='cc_frst_name']")
	public WebElement cardFirstName;

	@FindBy(xpath = "//input[@name='cc_last_name']")
	public WebElement cardLastName;

	@FindBy(xpath = "//input[@name='buyFlights']")
	public WebElement purchase;

}
