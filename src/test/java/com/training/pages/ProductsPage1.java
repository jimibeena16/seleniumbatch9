package com.training.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage1 {
	
	WebDriver driver;
	
	 @FindBy(className = "title")
	    WebElement title;
	
 public ProductsPage1(WebDriver driver){
	 this.driver = driver;

     PageFactory.initElements(driver, this);
	 }
 
 public boolean isDisplayed(){
	 return title.isDisplayed();
	 }
 
 public String getPageTitleText() {
	 return title.getText();
 }
}