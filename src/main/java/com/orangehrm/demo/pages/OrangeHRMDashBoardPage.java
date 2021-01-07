package com.orangehrm.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class OrangeHRMDashBoardPage extends BasePage{
	
	
	@FindBy(xpath="//span[@id='account-name'][contains(text(),'Jacqueline White')]")
	public WebElement adminLoginTXT;
	
	
	@FindBy(xpath="//*[contains(text(),'Cliq')]")
	public WebElement cliq;
	

	@FindBy(xpath="//*[contains(text(),'Creator')]")
	public WebElement creator;
	
	
	@FindBy(xpath="//div[@class='app-nm'][contains(.,'CRM')]")
	public WebElement crm;
	
	
	@FindBy(xpath="//*[contains(text(),'SalesIQ')]")
	public WebElement salesIQ;
	
	
	@FindBy(xpath="//*[contains(text(),'Subscriptions')]")
	public WebElement subscriptions;
	
	
	
	
	/*
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(adminLoginTXT);
	}

*/	
	public String checkLoggedinAsAdmin(){
		boolean flag= false;
		String actualResult=  adminLoginTXT.getText();
		
		return actualResult;
	}
	
	public OrangeHRMMyInfoPage gotoMyInfo() {
		
		click(crm,"CRM Link");
		return (OrangeHRMMyInfoPage) openPage(OrangeHRMMyInfoPage.class);
	}
	
	public OrangeHRMLeavePage gotoleavePage() {
		
		click(cliq,"Cliq Link");
		return (OrangeHRMLeavePage) openPage(OrangeHRMLeavePage.class);
	}
	
	public OrangeHRMTimePage gotoTimePage() {
		
		click(subscriptions,"Subscriptions Link");
		return (OrangeHRMTimePage) openPage(OrangeHRMTimePage.class);
	}
	
	public OrangeHRMAdminPage gotoAdminPage() {
		
		click(creator,"Creator Link");
		return (OrangeHRMAdminPage) openPage(OrangeHRMAdminPage.class);

	}
	
	public OrangeHRMPIMPage gotoSalesIQ() {
		
		click(salesIQ,"SalesIQ Link");
		return (OrangeHRMPIMPage) openPage(OrangeHRMPIMPage.class);
	}

	/*@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	
	
}
