package com.training.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pages.*;

import utilities.DriverFactory;

public class LoginTest1{
	
	WebDriver driver;
	LoginPage1 loginPage;
	
	@BeforeMethod
	public void setup() {
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
	    driver.get("https://www.saucedemo.com/");
	}

    @Test
    public void verifyLogin() {

        loginPage = new LoginPage1(driver);
        loginPage.login("standard_user","secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
     }
    
    @AfterMethod
    public void tearDown() {
    	if(driver!=null) {
    		driver.quit();
    	}
    }
}