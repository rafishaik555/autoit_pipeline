package com.orangehrm.demo.testcases;

import org.testng.annotations.Test;

import com.orangehrm.demo.utilities.Constants;
import com.orangehrm.demo.utilities.DataProviders;
import com.orangehrm.demo.utilities.DataUtil;
import com.orangehrm.demo.utilities.ExcelReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestSample {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC001_TD001(Hashtable<String,String> data){
		System.out.println("inside dummy test USER NAME ..........");
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC_001", data.get("Runmode"), excel);
		System.out.println("RUN MODE is ........@Test............"+data.get("Runmode"));
		System.out.println("Test DATA ID ........@Test......."+data.get("TestData_ID"));
		System.out.println("BROWSER RA ................"+data.get("browser"));
		System.out.println("run mode ................"+data.get("runmode"));
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

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
	public void initSetup()
	{
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		boolean tc_status = DataUtil.isTestRunnable("TC_001", excel);
		System.out.println("boolean value is ...."+tc_status);
	}

  @AfterTest
  public void afterTest() {
  }

}
