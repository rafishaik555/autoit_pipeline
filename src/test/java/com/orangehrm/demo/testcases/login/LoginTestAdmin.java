package com.orangehrm.demo.testcases.login;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.demo.pages.OrangeHRMHomePage;
import com.orangehrm.demo.pages.OrangeHRMLoginPage;
import com.orangehrm.demo.utilities.ConfigFileReader;
import com.orangehrm.demo.utilities.Constants;
import com.orangehrm.demo.utilities.DataUtil;
import com.orangehrm.demo.utilities.ExcelReader;


public class LoginTestAdmin  {

	
	/*@BeforeTest
	public void initSetup()
	{
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		int rowNumber_TC = excel.getCellRowNum("TestCases", "TestCases", "TC_001");
		String testCaseName = excel.getCellData("TestCases", "TestCases", rowNumber_TC);
		System.out.println("test case name in @BeforeTest .LOGIN ADMIN..."+testCaseName);
		System.out.println("ROW NUMBER IS ......................."+rowNumber_TC);
		String runmode_TC = excel.getCellData("TestCases", "Runmode", rowNumber_TC);
		System.out.println("run mode in test case name @BeforeTest ..LOGIN ADMIN..."+runmode_TC);

		if(runmode_TC.equalsIgnoreCase("N")){
			throw new SkipException("Skipping the test : " + testCaseName + " as the Runmode of Test Case : "
					+ testCaseName + " is NO");
		}
	}*/
	
	
	@BeforeTest
	public void initSetup()
	{
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		boolean tc_status = DataUtil.isTestRunnable("TC_001", excel);
		System.out.println("boolean value is ...."+tc_status);
	}
	
	@BeforeMethod
	public void TC001_TD001_BeforeMethod(){
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		int rowNumber_TD001 = excel.getCellRowNum("TestData", "TC_001", "TC001_TD001");
		String testDataName = excel.getCellData("TestData", "TC_001", rowNumber_TD001);
		System.out.println("test data name in @BeforeMethod .LOGIN ADMIN. TD ID.."+testDataName);
		System.out.println("ROW NUMBER IS ............................"+rowNumber_TD001);
		String runmode_TD = excel.getCellData("TestData", "LoginTestAdmin", rowNumber_TD001);
		System.out.println("run mode in test case name @BeforeTest ..LOGIN ADMIN..TD_ID."+runmode_TD);

		if(runmode_TD.equalsIgnoreCase("N")){
			throw new SkipException("Skipping the test : " + runmode_TD + " as the Runmode of Test Case : "
					+ runmode_TD + " is NO");
		}
		
	}
	/*
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC001_TD001(Hashtable<String,String> data){
		System.out.println("inside dummy test USER NAME ..........");
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC_001", data.get("Runmode"), excel);
		System.out.println("RUN MODE is ........@Test............"+data.get("Runmode"));
		System.out.println("Test DATA ID ........@Test......."+data.get("TestData_ID"));
		log.info("Inside Login Test Admin");
		System.out.println("BROWSER RA ................"+data.get("browser"));
		System.out.println("run mode ................"+data.get("runmode"));
	}
*/	
	
//	@BeforeMethod
//	public void TC001_TD002_BeforeMethod(){
//		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
//		int rowNumber_TD001 = excel.getCellRowNum("TestData", "TC_001", "TC001_TD002");
//		String testDataName = excel.getCellData("TestData", "TC_001", rowNumber_TD001);
//		System.out.println("test data name in @BeforeMethod .LOGIN ADMIN. TD ID.."+testDataName);
//		System.out.println("ROW NUMBER IS ............................"+rowNumber_TD001);
//		String runmode_TD = excel.getCellData("TestData", "LoginTestAdmin", rowNumber_TD001);
//		System.out.println("run mode in test case name @BeforeTest ..LOGIN ADMIN..TD_ID."+runmode_TD);
//
//		if(runmode_TD.equalsIgnoreCase("N")){
//			throw new SkipException("Skipping the test : " + runmode_TD + " as the Runmode of Test Case : "
//					+ runmode_TD + " is NO");
//		}
//		
//	}
	
	@Test(dataProvider = "data-provider")
	public void dummyTest_TD02(){
			System.out.println("inside dummy test....TD02............");
	}
	
	@DataProvider (name = "data-provider")
	public Object[][] dpMethodName(){
		return new Object[][] {{"First-Value"}, {"Second-Value"}};
	}

	@DataProvider(name = "dp")

	public Object[][] dpMethod() {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		Object [][] data = DataUtil.getData("TC_001", excel);
		return data;
	}


	
	/*	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC001_TD001(Hashtable<String,String> data) {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		//DataUtil.checkExecution("master", "TC_001", data.get("Runmode"), excel);
		log.info("Inside Login Test Admin");
		System.out.println("BROWSER RA ................"+data.get("browser"));
		System.out.println("run mode ................"+data.get("runmode"));
		
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		OrangeHRMHomePage home = new OrangeHRMHomePage().open(new ConfigFileReader().getApplicationUrl());
		OrangeHRMLoginPage login = home.gotoLogin();
		login.doLoginAsValidUser(data.get("username"), data.get("password"));
		System.out.println();
		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
		//Assert.fail("Failing the login test");
		 	
		}

	@AfterMethod
	public void TC001_TD001_AfterMethod(){
		System.out.println("inside @aftermethod...........TC001_TD001_AfterMethod.....");
	}
	
	
	@BeforeMethod
	public void TC001_TD002_BeforeMethod(){
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		int rowNumber_TD002 = excel.getCellRowNum("TestData", "TC001_TD002", "TC001_TD002");
		String testDataName = excel.getCellData("TestData", "TC001_TD002", rowNumber_TD002);
		System.out.println("test case name in @BeforeMethod .LOGIN ADMIN. TD ID.."+testDataName);
		
		String runmode_TD = excel.getCellData("TestCases", "Runmode", rowNumber_TD002);
		System.out.println("run mode in test case name @BeforeTest ..LOGIN ADMIN..TD_ID."+runmode_TD);

		if(runmode_TD.equalsIgnoreCase("N")){
			throw new SkipException("Skipping the test : " + runmode_TD + " as the Runmode of Test Case : "
					+ runmode_TD + " is NO");
		}
		
	}
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC001_TD002(Hashtable<String,String> data) {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		//DataUtil.checkExecution("master", "TC_001", data.get("Runmode"), excel);
		log.info("Inside Login Test Admin");
		System.out.println("BROWSER RA ................"+data.get("browser"));
		System.out.println("run mode ................"+data.get("runmode"));
		
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		OrangeHRMHomePage home = new OrangeHRMHomePage().open(new ConfigFileReader().getApplicationUrl());
		OrangeHRMLoginPage login = home.gotoLogin();
		login.doLoginAsValidUser(data.get("username"), data.get("password"));
		System.out.println();
		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
		//Assert.fail("Failing the login test");
		 	
		}

	@AfterMethod
	public void TC001_TD002_AfterMethod(){
		System.out.println("inside @aftermethod...........TC001_TD002_AfterMethod.....");
	}
	
	
	@BeforeMethod
	public void TC001_TD003_BeforeMethod(){
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		int rowNumber_TD002 = excel.getCellRowNum("TestData", "TC001_TD002", "TC001_TD002");
		String testDataName = excel.getCellData("TestData", "TC001_TD002", rowNumber_TD002);
		System.out.println("test case name in @BeforeMethod .LOGIN ADMIN. TD ID.."+testDataName);
		
		String runmode_TD = excel.getCellData("TestCases", "Runmode", rowNumber_TD002);
		System.out.println("run mode in test case name @BeforeTest ..LOGIN ADMIN..TD_ID."+runmode_TD);

		if(runmode_TD.equalsIgnoreCase("N")){
			throw new SkipException("Skipping the test : " + runmode_TD + " as the Runmode of Test Case : "
					+ runmode_TD + " is NO");
		}
		
	}
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC001_TD003(Hashtable<String,String> data) {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		//DataUtil.checkExecution("master", "TC_001", data.get("Runmode"), excel);
		log.info("Inside Login Test Admin");
		System.out.println("BROWSER RA ................"+data.get("browser"));
		System.out.println("run mode ................"+data.get("runmode"));
		
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		OrangeHRMHomePage home = new OrangeHRMHomePage().open(new ConfigFileReader().getApplicationUrl());
		OrangeHRMLoginPage login = home.gotoLogin();
		login.doLoginAsValidUser(data.get("username"), data.get("password"));
		System.out.println();
		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
		//Assert.fail("Failing the login test");
		 	
		}

	@AfterMethod
	public void TC001_TD003_AfterMethod(){
		System.out.println("inside @aftermethod...........TC001_TD003_AfterMethod.....");
	}
*/
}
