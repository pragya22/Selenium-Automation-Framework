package com.mindtree.reusuablecomponents;

import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/*
 * Report is a class which is used to generate extent and
 * Log report
 */

public class Report {
	public ExtentReports extentreport;
	public ExtentTest test;
	public Logger log;

	static CommonComponents commonlibraries = new CommonComponents();

	static int i = 2;
	public static  String da = commonlibraries.dateTime();
	public static ExtentReports extent = new ExtentReports(
			System.getProperty("user.dir") + "/report/extentreport/"+da+"/MercuryTravels.html", true);
	
	public ExtentReports generateReport() {
		extent.addSystemInfo("HostName", "Mindtree").addSystemInfo("Environment", "QA");
		i++;
		extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
		return extent;
	}
	


	public void writeToReport() {
		extent.flush();

	}

	public Logger logReport() {
		log = Logger.getLogger("MercuryTravels");

		PropertyConfigurator.configure("log4j.properties");

		return log;
	}
}
