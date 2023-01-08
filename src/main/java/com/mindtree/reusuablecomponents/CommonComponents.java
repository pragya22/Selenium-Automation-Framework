package com.mindtree.reusuablecomponents;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mindtree.utility.ExcelUtils;
import com.mindtree.utility.PropertyFileData;

/**
 * @author Pragya Gupta
 * 
 *
 */

/*
 * 
 * CommonComponents is a class which is having some methods which are using
 * frequently in a project
 */
public class CommonComponents {

	public WebDriver driver; // Declaring the driver

	// propertyFiledata is a object of PropertyFileData class
	PropertyFileData propertyFiledata = new PropertyFileData();

	// setUp is a method which is doing initialization of driver
	public WebDriver setUp() throws FileNotFoundException, IOException, InterruptedException {
		if(propertyFiledata.takeDataFromProperty().getProperty("browsername").equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + propertyFiledata.takeDataFromProperty().getProperty("cPath"));

		driver = new ChromeDriver();
		}
	

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		return driver;

	}

	// click is a method which is taking WebElement as a parameter to click on that
	// element
	public void click(WebElement element) {
		System.out.println(element.getText());
		element.click();
	}

	public void sendkeys(WebElement webelementPath, String data) {
		webelementPath.sendKeys(data);
	}
	public void sendkeys(WebElement webelementPath, String data,Keys keyboard) {
		webelementPath.sendKeys(data,keyboard);
	}

	// tearDown is a method which is closing the driver
	public void tearDown(WebDriver driver) {
		driver.quit();
	}

	// webdriverWait is a method which is used for explicit wait
	public boolean webdriverWait(WebElement element, WebDriver driver, int secs) {
		boolean elementPresent = false;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if (wait.until(ExpectedConditions.visibilityOf(element)) != null) {
			elementPresent = true;
		}
		return elementPresent;
	}

	// takeScreenshot is a method which is used to take screenshot
	public void takeScreenshot(String fileWithPath, WebDriver driverr) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driverr);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
	}

	// mouseHover is a method used to move the mouse from one point to other
	public void mouseHover(WebDriver driver, WebElement locator) {
		Actions action = new Actions(driver);
		action.moveToElement(locator).build().perform();
	}
	public void scrollDown() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// This will scroll the page till the element is found
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	// dateTime is a method used to fetch the system date and time
	public String dateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		Date date = new Date();
		String formattedDate = dateFormat.format(date);

		return formattedDate;
	}
	public Object[][] dataprovider(String sheet) throws Exception{
		ExcelUtils utils = new ExcelUtils();
		String excelfilePath = System.getProperty("user.dir")+ propertyFiledata.takeDataFromProperty().getProperty("excelPath");
		utils.setExcelFile(excelfilePath, sheet);
		Object[][] testObjArray = ExcelUtils.getTableArray();
		return (testObjArray);
		
	}
	

}
