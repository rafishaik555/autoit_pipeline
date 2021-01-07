package com.orangehrm.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrangeHRMLoginPage extends BasePage {

	@FindBy(xpath = "//input[@name='txtUsername' and @type='text']")
	public WebElement uname;
	
	@FindBy(xpath = "//input[@name='txtPassword' and @type='password']")
	public WebElement pass;

	@FindBy(xpath = "//input[@name='Submit' and @type='submit']")
	public WebElement signin;

	public OrangeHRMLoginPage doLoginAsInvalidUser(String username, String password) {

		type(uname, username, "Username textbox");
		type(pass, password, "Password textbox");
		click(signin, "Sign in Button");
		return this;

	}

	public OrangeHRMDashBoardPage doLoginAsValidUser(String username, String password) {
		clear(uname);
		System.out.println("user name in valid user ........."+username);
		type(uname, username, "Username textbox");
		clear(pass);
		System.out.println("password in valid user ........."+password);
		type(pass, password, "Password textbox");
		click(signin, "Sign in Button");

		return (OrangeHRMDashBoardPage) openPage(OrangeHRMDashBoardPage.class);

	}

	/*@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(uname);
	}*/

}
