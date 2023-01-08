package com.mindtree.utility;

import org.openqa.selenium.JavascriptExecutor;
import com.mindtree.reusuablecomponents.AllObjects;

public class Scroll extends AllObjects{
	public void scrollDown() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// This will scroll the page till the element is found
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}
}
