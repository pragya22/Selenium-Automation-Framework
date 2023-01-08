package com.mindtree.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/*
* LoginPageUi is a class which contains all locators or webelements of LoginPage 
 * 
 */

public class LoginPageUi {
              

              @FindBy(name = "userName") 
              @CacheLookup
              public  WebElement userName;

              @FindBy(xpath = "//input[@type='password']") 
              @CacheLookup
              public WebElement password;

              @FindBy(xpath = "//input[@name='login']") 
              @CacheLookup
              public WebElement loginbutton;

}
