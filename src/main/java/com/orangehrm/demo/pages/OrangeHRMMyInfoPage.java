package com.orangehrm.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrangeHRMMyInfoPage extends BasePage{

	@FindBy(xpath="//span[contains(@id,'show-uName')]")
	public WebElement welcomeText;
	
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(welcomeText);
	}

}
