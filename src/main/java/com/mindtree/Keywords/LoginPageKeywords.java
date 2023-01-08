
package com.mindtree.Keywords;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import com.mindtree.Pages.LoginPage;
import com.mindtree.reusuablecomponents.AllObjects;
import com.mindtree.reusuablecomponents.Report;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageKeywords extends AllObjects {

	public LoginPage loginActionKeywords; // implementations of keywords in LoginPage class
	public String sActionKeyword; // Fetched keywords from excel sheet is storing in String sActionKeyword
	public int reportcount = 0;
	public Method method[]; // for reflection class

	public static Logger log; // For log report generation

	Report report = new Report(); // report is a object of Report
	static String testcases;
	static int count=0;
	// LoginPageKeywords is a constructor
	public LoginPageKeywords() throws NoSuchMethodException, SecurityException {
		loginActionKeywords = new LoginPage();
		method = loginActionKeywords.getClass().getMethods();
	}


	// fetchKeywords is a method which is fetching keywords from excel sheet
	public void fetchKeywords(String username, String password) throws Exception {
		new LoginPageKeywords();

		// excelfilePath is specifying path of excel file
		String excelfilePath = System.getProperty("user.dir")+ propertyFiledata.takeDataFromProperty().getProperty("excelPath");
		// setExcelFile is method which is present in Excelutils class
		// login is a sheet name preseent in excel sheet workbook
		exceldata.setExcelFile(excelfilePath, "login");

		// calling the loginPageReport method which is present in loginpageKeywords
		// class
		

		/*
		 * count=0; bar.iterate(count);
		 */

		for (int excelrowdata = 1; excelrowdata <= 5; excelrowdata++) {
			LoginPageKeywords loginkeywords = new LoginPageKeywords();
			// Taking data from excel sheet and storing it in sActionKeyword variable
			loginkeywords.sActionKeyword = exceldata.getCellData(excelrowdata, 2);
			testcases = exceldata.getCellData(excelrowdata, 0);
			System.out.println(testcases);
			// keywordImplementation is a method where we are passing each actionkeywords
			loginkeywords.keywordImplementations(username, password);
		}
	}
	public void vfetchKeywords(String username, String password) throws Exception {
		new LoginPageKeywords();
		count++;
		// excelfilePath is specifying path of excel file
		String excelfilePath = System.getProperty("user.dir")+ propertyFiledata.takeDataFromProperty().getProperty("excelPath");
		// setExcelFile is method which is present in Excelutils class
		// login is a sheet name preseent in excel sheet workbook
		exceldata.setExcelFile(excelfilePath, "loginValidate");
		
		for (int excelrowdata = 1; excelrowdata <= 7; excelrowdata++) {
			LoginPageKeywords loginkeywords = new LoginPageKeywords();
			// Taking data from excel sheet and storing it in sActionKeyword variable
			loginkeywords.sActionKeyword = exceldata.getCellData(excelrowdata, 2);
			testcases = exceldata.getCellData(excelrowdata, 0);
			System.out.println(testcases);
			// keywordImplementation is a method where we are passing each actionkeywords
			if(count==1 && excelrowdata==6) {
				continue;
			}
			else if(count==2 && excelrowdata==7) {
				continue;
			}
			else {
			loginkeywords.keywordImplementations(username, password);
		}
		}
	}


	public void keywordImplementations(String username, String password) throws Exception {

		// Calliong the logReport metod which is present in Report class
		log = report.logReport();

		// screenshot is variable which holds path to store screenshot
		String screenshot = System.getProperty("user.dir")
				+ propertyFiledata.takeDataFromProperty().getProperty("screenshotpath") + commonlibraries.dateTime()
				+ "login.png";

		for (int inviokemethod = 0; inviokemethod < method.length; inviokemethod++) {

			if (method[inviokemethod].getName().equals(sActionKeyword)) {
				try {
					if (method[inviokemethod].getName().equals("username")) {
						method[inviokemethod].invoke(loginActionKeywords, username);
						log.info(sActionKeyword + " Successfully Run");
						test.log(LogStatus.PASS, testcases + " passed " + sActionKeyword + " success");

					} else if (method[inviokemethod].getName().equals("password")) {
						method[inviokemethod].invoke(loginActionKeywords, password);
						log.info(sActionKeyword + " Successfully Run");
						test.log(LogStatus.PASS, testcases + " passed " + sActionKeyword + " success");

					}
					
					else {
						method[inviokemethod].invoke(loginActionKeywords);
						log.info(sActionKeyword + " Successfully Run");
						test.log(LogStatus.PASS, testcases + " passed " + sActionKeyword + " success ");
					}

				} catch (Exception e) {
					commonlibraries.takeScreenshot(screenshot, LoginPage.driver);
					log.error(sActionKeyword + " failed");
					test.log(LogStatus.FAIL,
							testcases + " " + sActionKeyword + " fail" + test.addScreenCapture(screenshot));

				}

				break;
			}

		}
	}

}
