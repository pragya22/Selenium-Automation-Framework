package com.mindtree.reusuablecomponents;

import org.openqa.selenium.WebDriver;

import com.mindtree.utility.ExcelUtils;
import com.mindtree.utility.PropertyFileData;
import com.relevantcodes.extentreports.ExtentTest;

// Creating Object of some classes in one class called AllObjects
public class AllObjects {

	public CommonComponents commonlibraries = new CommonComponents();
	
	public PropertyFileData propertyFiledata = new PropertyFileData();
	

	public ExcelUtils exceldata = new ExcelUtils();

	public static WebDriver driver;
	public static ExtentTest test;

	


}
