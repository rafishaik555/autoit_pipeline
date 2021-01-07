package com.orangehrm.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.orangehrm.demo.utilities.DriverManager;


public class OrangeHRMHomePage extends BasePage {
		
	@FindBy(xpath="//div/div/h1/b[contains(text(),'Login')]")
	public WebElement logIn;
	
	public OrangeHRMHomePage open(String url) {
	
		System.out.println("Page Opened");
		DriverManager.getDriver().navigate().to(url);
		return (OrangeHRMHomePage) openPage(OrangeHRMHomePage.class);
	}
	
	public OrangeHRMLoginPage gotoLogin(){
		System.out.println("inside go to login");
		//click(logIn, "Login Link");
		return (OrangeHRMLoginPage) openPage(OrangeHRMLoginPage.class);
			
	}


/*	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(logIn);
	}
*/	
	
	

}
