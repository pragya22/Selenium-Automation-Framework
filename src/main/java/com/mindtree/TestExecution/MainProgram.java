package com.mindtree.TestExecution;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.itextpdf.text.DocumentException;
import com.mindtree.Keywords.BookFlightPageKeywords;
import com.mindtree.Keywords.FlightFinderKeywords;
import com.mindtree.Keywords.LoginPageKeywords;
import com.mindtree.Keywords.SearchFlightPageKeywords;
import com.mindtree.reusuablecomponents.AllObjects;
import com.mindtree.reusuablecomponents.CommonComponents;
import com.mindtree.reusuablecomponents.Report;
import com.mindtree.utility.HtmlToPdf;
import com.mindtree.utility.PropertyFileData;
import com.mindtree.utility.SendAttachmentInEmail;
import com.relevantcodes.extentreports.ExtentReports;

/*
 * Mainprogram is s class contains all test cases related to  project Test
 * cases will start executing from here
 * 
 */
public class MainProgram extends AllObjects{

	PropertyFileData propertyFiledata = new PropertyFileData();
	CommonComponents components = new CommonComponents();
	public HtmlToPdf convert= new HtmlToPdf();

	public static ExtentReports extentreport;
	Report report = new Report();
	static int i=0;

	@BeforeTest
	public void startExtentReport() throws FileNotFoundException, IOException, InterruptedException {
		extentreport = report.generateReport();

	}



	//	 * login is a test which is checking weather end user will be able to login,
	//	 * into demoaut through normal login credentials


	@Test(priority = 1, dataProvider = "Authentication")
	public void roundtrip(String username, String password) throws Exception {

		/* loginPage is a object of LoginPageKeywords class * fetchKeywords is a method
		 * which is present in LoginPageKeywords class and this method fetching keywords
		 * from excel sheet*/
		test=extentreport.startTest("roundtrip Testcase");
		LoginPageKeywords loginPage = new LoginPageKeywords();
		loginPage.fetchKeywords(username, password);
		FlightFinderKeywords flightfinder = new FlightFinderKeywords();
		flightfinder.fetchKeywords();
		SearchFlightPageKeywords searchFlight = new SearchFlightPageKeywords();
		searchFlight.fetchKeywords();
		BookFlightPageKeywords bookFlight= new BookFlightPageKeywords();
		bookFlight.fetchKeywords();
		report.writeToReport();
	}

	@Test(priority = 2, dataProvider = "Credentials")
	public void validate(String username, String password) throws Exception {
		/*
		 * loginValidatePage is a object of LoginValidateKeywords class * vfetchKeywords is a method
		 * which is present in LoginPageKeywords class and this method fetching keywords
		 * from excel sheet
		 */
		test=extentreport.startTest("Validate Testcase");
		//Validation
		LoginPageKeywords loginValidatePage = new LoginPageKeywords();
		loginValidatePage.vfetchKeywords(username, password);
		report.writeToReport();
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

	@AfterTest
	public void end() throws IOException, DocumentException, AddressException, MessagingException
	{
		convert.pdf();
		SendAttachmentInEmail.mail();
	}

	@DataProvider
	public Object[][] Authentication() throws Exception {

		return components.dataprovider("logincredentials");
	}

	@DataProvider
	public Object[][] Credentials() throws Exception {

		return components.dataprovider("validateCredentials");
	}
}




