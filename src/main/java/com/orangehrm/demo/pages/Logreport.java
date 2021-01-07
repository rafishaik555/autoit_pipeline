package com.orangehrm.demo.pages;

import com.orangehrm.demo.extentListeners.ExtentListeners;

public class Logreport {

	public void logTestCaseReport(String message){
		ExtentListeners.testReport.get().info(message);
	}
}
