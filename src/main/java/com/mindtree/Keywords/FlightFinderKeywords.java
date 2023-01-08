package com.mindtree.Keywords;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import com.mindtree.Pages.FlightFinderPage;
import com.mindtree.reusuablecomponents.AllObjects;
import com.mindtree.reusuablecomponents.Report;
import com.relevantcodes.extentreports.LogStatus;

public class FlightFinderKeywords extends AllObjects {

              public FlightFinderPage FindFlightActionKeywords; // implementations of keywords in HomePage class
              public String sActionKeyword; // Fetched keywords from excel sheet is storing in String sActionKeyword


              public static Logger log; // For log report generation

              public Method method[]; // for reflection class

              Report report = new Report(); // report is a object of Report

              static String testcases;
                             
              public FlightFinderKeywords() {

                             FindFlightActionKeywords = new FlightFinderPage();
                             method = FindFlightActionKeywords.getClass().getMethods();

              }
              
             

              // fetchKeywords is a method which is fetching keywords from excel sheet
              public void fetchKeywords() throws Exception {
                             // Calliong the logReport metod which is present in Report class
                             log = report.logReport();

                         
                          
                             // excelfilePath is specifying path of excel file
                             String excelfilePath = System.getProperty("user.dir")
                                                          + propertyFiledata.takeDataFromProperty().getProperty("excelPath");

                             // setExcelFile is method which is present in Excelutils class
                             exceldata.setExcelFile(excelfilePath, "flightfinder");

                             // calling the flightFinderPageReport method which is present in flightFinderpageKeywords class
                             
                             

                             for (int excelsheetrow = 1; excelsheetrow <= 11; excelsheetrow++) {
                                           FlightFinderKeywords searchnewcarkeywords = new FlightFinderKeywords();
                             
                                           // Taking data from excel sheet and storing it in sActionKeyword variable
                                           searchnewcarkeywords.sActionKeyword = exceldata.getCellData(excelsheetrow, 3);
                                           testcases= exceldata.getCellData(excelsheetrow, 0);
                                           // keywordImplementation is a method where we are passing each actionkeywords
                                           searchnewcarkeywords.keywordImplementation();
                             }
              }

              /*
              * keywordImplementation is a method which is taking keywords from fetchKeywords
              * method and invoking each keywords from home page class
              */

              public void keywordImplementation() throws IOException {

                             // screenshot is variable which holds path to store screenshot
                             String screenshot = System.getProperty("user.dir")
                                                          + propertyFiledata.takeDataFromProperty().getProperty("screenshotpath") + commonlibraries.dateTime()
                                                          + " flightfinder.png";

                             for (int inviokemethod = 0; inviokemethod < method.length; inviokemethod++) {
                                           if (method[inviokemethod].getName().equals(sActionKeyword)) {
                                           
                                                          try {
                                                                        method[inviokemethod].invoke(FindFlightActionKeywords);

                                                                        // printing the status into extent report
                                                                        test.log(LogStatus.PASS,testcases+" passed " + sActionKeyword + " success");

                                                                        // printing the status into log report
                                                                        log.info(sActionKeyword + " Successfully Run");
                                                          } catch (Exception e) {

                                                                        // When test step fails screenshot is taking
                                                                        commonlibraries.takeScreenshot(screenshot, FlightFinderPage.driver);

                                                                        // pasting error screenshot into extentreport
                                                                        test.log(LogStatus.FAIL, testcases+" " +sActionKeyword + " fail" + test.addScreenCapture(screenshot));

                                                                        // printing the error message into the log file
                                                                        log.error(sActionKeyword + " Failed to run");
                                                          }

                                                          // appending all messages to log files
                                                        
                                                          break;
                                           }
                             }
              }
}




