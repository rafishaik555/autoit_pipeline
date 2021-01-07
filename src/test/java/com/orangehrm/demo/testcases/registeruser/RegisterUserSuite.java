package com.orangehrm.demo.testcases.registeruser;

import org.testng.annotations.Test;

import com.orangehrm.demo.testcases.BaseTest;
import com.orangehrm.demo.utilities.Read_XLS;
import com.orangehrm.demo.utilities.SuiteUtility;

import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.AfterSuite;

public class RegisterUserSuite extends BaseTest {
	Read_XLS FilePath = null;
	String SheetName = null;
	String SuiteName = null;
	String ToRunColumnName = null;	
	
	//This function will be executed before SuiteOne's test cases to check SuiteToRun flag.
	@BeforeSuite
	public void checkSuiteToRun() throws IOException{		
		//Called init() function from SuiteBase class to Initialize .xls Files
		initExcel();			
		//To set TestSuiteList.xls file's path In FilePath Variable.
		FilePath = TestSuiteListExcel;
		SheetName = "SuitesList";
		SuiteName = "LoginSuite";
		ToRunColumnName = "SuiteToRun";
		
		//Bellow given syntax will Insert log In applog.log file.
		
		//If SuiteToRun !== "y" then SuiteOne will be skipped from execution.
		if(!SuiteUtility.checkToRunUtility(FilePath, SheetName,ToRunColumnName,SuiteName)){			
			//To report SuiteOne as 'Skipped' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = N.
			SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName, "Skipped");
			//It will throw SkipException to skip test suite's execution and suite will be marked as skipped In testng report.
			throw new SkipException(SuiteName+"'s SuiteToRun Flag Is 'N' Or Blank. So Skipping Execution Of "+SuiteName);
		}
		//To report SuiteOne as 'Executed' In SuitesList sheet of TestSuiteList.xls If SuiteToRun = Y.
		SuiteUtility.WriteResultUtility(FilePath, SheetName, "Skipped/Executed", SuiteName, "Executed");		
	}

  @AfterSuite
  public void afterSuite() {
  
  
  }
}