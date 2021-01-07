package com.orangehrm.demo.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.orangehrm.demo.utilities.FilePaths;
import com.orangehrm.demo.utilities.Read_XLS;



public class SuiteBase implements FilePaths {	
	public static Read_XLS TestSuiteListExcel=null;
	public static Read_XLS TestLoginSuite=null;
	public static Read_XLS TestRegisterUserSuite=null;
	public static Logger Add_Log = null;
	
	public static Properties configProp;
	public static Properties ORProp;
	public static boolean isLoggedIn = false;
	
	//constructor
	public SuiteBase(){
		//To Initialize logger service.
		Add_Log = Logger.getLogger("rootLogger");				
	
		configProp = new Properties();
		System.out.println("FILE PATH CONFIG......."+FilePaths.configFilePath);
		FileInputStream finConfig = null;
		try {
			finConfig = new FileInputStream(FilePaths.configFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			configProp.load(finConfig);
			Add_Log.info("CONFIG property File is Loading......");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//OR.properties
		ORProp = new Properties();
		FileInputStream finOR = null;
		try {
			finOR = new FileInputStream(FilePaths.ORFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ORProp.load(finOR);
			Add_Log.info("OR property File is Loading......");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void initExcel(){
				
		//Please change file's path strings bellow If you have stored them at location other than bellow.
		//Initializing Test Suite List(TestSuiteList.xls) File Path Using Constructor Of Read_XLS Utility Class.
		TestSuiteListExcel = new Read_XLS(FilePaths.testsuiteXLSPath);
		//Initializing Test Suite One(SuiteOne.xls) File Path Using Constructor Of Read_XLS Utility Class.
		TestLoginSuite = new Read_XLS(FilePaths.loginsuiteXLSPath);
		//Initializing Test Suite Two(SuiteTwo.xls) File Path Using Constructor Of Read_XLS Utility Class.
		TestRegisterUserSuite = new Read_XLS(FilePaths.registerUsersuiteXLSPath);
		//Bellow given syntax will Insert log In applog.log file.
		Add_Log.info("All Excel Files Initialised successfully.");
	}
	
	
	
}//end of class
