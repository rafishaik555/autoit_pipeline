package com.orangehrm.demo.testcases.login;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.orangehrm.demo.extentListeners.ExtentListeners;
import com.orangehrm.demo.pages.BasePage;
import com.orangehrm.demo.pages.Logreport;
import com.orangehrm.demo.pages.OrangeHRMDashBoardPage;
import com.orangehrm.demo.pages.OrangeHRMHomePage;
import com.orangehrm.demo.pages.OrangeHRMLoginPage;
import com.orangehrm.demo.utilities.ConfigFileReader;
import com.orangehrm.demo.utilities.Read_XLS;
import com.orangehrm.demo.utilities.SuiteUtility;


public class LoginAdminTest extends LoginBase{
	Read_XLS FilePath = null;
	String SheetName = null;
	String TestCaseName = null;	
	String ToRunColumnNameTestCase = null;
	String ToRunColumnNameTestData = null;
	String TestDataToRun[]=null;
	static boolean TestCasePass=true;
	static int DataSet=-1;	
	static boolean Testskip=false;
	static boolean Testfail=false;
	SoftAssert s_assert =null;	
	
	@BeforeTest
	public void checkCaseToRun() throws IOException{
		//Called init() function from SuiteBase class to Initialize .xls Files
		initExcel();			
		//To set SuiteOne.xls file's path In FilePath Variable.
		FilePath = TestLoginSuite;
		
		TestCaseName = this.getClass().getSimpleName();
		System.out.println("Test Case Name VALUE ..........."+TestCaseName);
		//logInfo("Test Case Name VALUE .....BEFORE TEST SETUP......");
		//ExtentListeners.testReport.get().info(TestCaseName);
		//Logreport obj = new Logreport();
		//obj.logTestCaseReport(TestCaseName);
		//SheetName to check CaseToRun flag against test case.
		SheetName = "TestCasesList";

		//Name of column In TestCasesList Excel sheet.
		ToRunColumnNameTestCase = "CaseToRun";
		//Name of column In Test Case Data sheets.
		ToRunColumnNameTestData = "DataToRun";
		
		
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName,ToRunColumnNameTestCase,TestCaseName)){
			//To report result as skip for test cases In TestCasesList sheet.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Pass/Fail/Skip", TestCaseName, "SKIP");
			//To throw skip exception for this test case.
			throw new SkipException(TestCaseName+"'s CaseToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+TestCaseName);
		}	
		//To retrieve DataToRun flags of all data set lines from related test data sheet.
		TestDataToRun = SuiteUtility.checkToRunUtilityOfData(FilePath, TestCaseName, ToRunColumnNameTestData);
	}
	
	@BeforeMethod
	public void launch_browser(){
		System.out.println("inside valid login test case .... credentials");	
	}
	

	@Test(dataProvider="LoginAdminTest")
	public void testLoginAdmin(String browser,String username,String password,String expectedMessage){
		System.out.println("browser type ..............."+browser);
		System.out.println("username.............."+username);
		System.out.println("password........"+password);
		System.out.println("expected result............"+expectedMessage);
		
		
		DataSet++;
		
		//Created object of testng SoftAssert class.
		s_assert = new SoftAssert();
		
		//If found DataToRun = "N" for data set then execution will be skipped for that data set.
		if(!TestDataToRun[DataSet].equalsIgnoreCase("Y")){	
			//If DataToRun = "N", Set Testskip=true.
			Testskip=true;
			throw new SkipException("DataToRun for row number "+DataSet+" Is No Or Blank. So Skipping Its Execution.");
		}
		
		
		
		openBrowser(browser);
		ExtentListeners.testReport.get().info("Browser Type....."+browser);

		OrangeHRMHomePage home = new OrangeHRMHomePage().open(new ConfigFileReader().getApplicationUrl());
		OrangeHRMLoginPage login = home.gotoLogin();
		OrangeHRMDashBoardPage orangeHRMdashboardObj = login.doLoginAsValidUser(username, password);
		System.out.println();
		//logInfo("Username entered as "+username+" and Password entered as "+password);
		//Assert.fail("Failing the login test");
		
		String ActualResult = orangeHRMdashboardObj.checkLoggedinAsAdmin();
		
		System.out.println("actual test result is .........."+ActualResult);
		ExtentListeners.testReport.get().info("Actual Result....."+ActualResult);
		ExtentListeners.testReport.get().info("Expected Result....."+expectedMessage);

		//Compare actual and expected values.
		if(!(ActualResult.equals(expectedMessage))){
			//If expected and actual results not match, Set flag Testfail=true.
			Testfail=true;	
			//If result Is fail then test failure will be captured Inside s_assert object reference.
			//This soft assertion will not stop your test execution.
			s_assert.assertEquals(ActualResult, expectedMessage, ActualResult+" And "+expectedMessage+" Not Match");
		}

		if(Testfail){
			//At last, test data assertion failure will be reported In testNG reports and It will mark your test data, test case and test suite as fail.
			s_assert.assertAll();		
		}

	}

	
		
	@AfterMethod
	public void reporterDataResults(){		
		if(Testskip){
			System.out.println(TestCaseName+" : Reporting test data set line "+(DataSet+1)+" as SKIP In excel.");
			//If found Testskip = true, Result will be reported as SKIP against data set line In excel sheet.
			SuiteUtility.WriteResultUtility(FilePath, TestCaseName, "Pass/Fail/Skip", DataSet+1, "SKIP");
		}
		else if(Testfail){
			System.out.println(TestCaseName+" : Reporting test data set line "+(DataSet+1)+" as FAIL In excel.");
			//To make object reference null after reporting In report.
			s_assert = null;
			//Set TestCasePass = false to report test case as fail In excel sheet.
			TestCasePass=false;	
			//If found Testfail = true, Result will be reported as FAIL against data set line In excel sheet.
			SuiteUtility.WriteResultUtility(FilePath, TestCaseName, "Pass/Fail/Skip", DataSet+1, "FAIL");			
		}else{
			System.out.println(TestCaseName+" : Reporting test data set line "+(DataSet+1)+" as PASS In excel.");
			//If found Testskip = false and Testfail = false, Result will be reported as PASS against data set line In excel sheet.
			SuiteUtility.WriteResultUtility(FilePath, TestCaseName, "Pass/Fail/Skip", DataSet+1, "PASS");
		}
		//At last make both flags as false for next data set.
		Testskip=false;
		Testfail=false;
	}
	
	
	
	
	//This data provider method will return 4 column's data one by one In every Iteration.
	@DataProvider(name="LoginAdminTest")
	public Object[][] getTestData(){
		//To retrieve data from Data 1 Column,Data 2 Column,Data 3 Column and Expected Result column of SuiteOneCaseOne data Sheet.
		//Last two columns (DataToRun and Pass/Fail/Skip) are Ignored programatically when reading test data.
		return SuiteUtility.GetTestDataUtility(FilePath, TestCaseName);
	}	
	
	


	@AfterTest
	public void closeBrowser(){	
		if(TestCasePass){
			System.out.println(TestCaseName+" : Reporting test case as PASS In excel.");
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Pass/Fail/Skip", TestCaseName, "PASS");
		}
		else{
			System.out.println(TestCaseName+" : Reporting test case as FAIL In excel.");
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Pass/Fail/Skip", TestCaseName, "FAIL");
			
		}		
	}
}
