package com.training.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pages.LoginPage1;
import com.training.pages.ProductsPage1;

import utilities.DriverFactory;

public class ProductsTest1 {
	
	WebDriver driver;
	LoginPage1 loginPage;
	ProductsPage1 productsPage;
	
	@BeforeMethod
	public void setup() {
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
	    driver.get("https://www.saucedemo.com/");
	    
	    //prerequisite 
	    loginPage = new LoginPage1(driver);
	    loginPage.login("standard_user","secret_sauce");
	    
	    productsPage = new ProductsPage1(driver);
	}

   @Test
	public void verifyProductsPageTitle() {
              
        Assert.assertTrue(productsPage.isDisplayed());
        Assert.assertEquals(productsPage.getPageTitleText(), "Products");
     }
   
   @AfterMethod
   public void tearDown() {
   	if(driver!=null) {
   		driver.quit();
   	
    }
}
}