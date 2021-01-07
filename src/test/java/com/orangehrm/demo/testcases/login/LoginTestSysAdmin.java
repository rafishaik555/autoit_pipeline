package com.orangehrm.demo.testcases.login;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangehrm.demo.pages.OrangeHRMHomePage;
import com.orangehrm.demo.pages.OrangeHRMLoginPage;
import com.orangehrm.demo.testcases.BaseTest;
import com.orangehrm.demo.utilities.ConfigFileReader;
import com.orangehrm.demo.utilities.Constants;
import com.orangehrm.demo.utilities.DataUtil;
import com.orangehrm.demo.utilities.ExcelReader;
import com.orangehrm.demo.utilities.DataProviders;



public class LoginTestSysAdmin extends BaseTest {

	@BeforeTest
	public void initSetup()
	{
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		int rowNumber_TC = excel.getCellRowNum("TestCases", "TestCases", "LoginTestSysAdmin");
		String testCaseName = excel.getCellData("TestCases", "TestCases", rowNumber_TC);
		System.out.println("test case name in @BeforeTest .LoginTestSysAdmin..."+testCaseName);
		
		String runmode_TC = excel.getCellData("TestCases", "Runmode", rowNumber_TC);
		System.out.println("run mode in test case name @BeforeTest ..LoginTestSysAdmin..."+runmode_TC);

		if(runmode_TC.equalsIgnoreCase("N")){
			throw new SkipException("Skipping the test : " + testCaseName + " as the Runmode of Test Case : "
					+ testCaseName + " is NO");
		}
	}
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void LoginTestSysAdmin(Hashtable<String,String> data) {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "LoginTestSysAdmin", data.get("Runmode"), excel);
		log.info("Inside Login Test sysadmin");
		System.out.println("BROWSER RA ................"+data.get("browser"));
		/*openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		OrangeHRMHomePage home = new OrangeHRMHomePage().open(new ConfigFileReader().getApplicationUrl());
		OrangeHRMLoginPage login = home.gotoLogin();
		login.doLoginAsInvalidUser(data.get("username"), data.get("password"));
		System.out.println();
		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));*/
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		//quit();
		
	}

}
