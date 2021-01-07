package com.orangehrm.demo.utilities;

public class DriverFactory {
	
	private static String chromeDriverExePath;
	private static String edgeDriverExePath;
	private static String ieDriverExePath;
	private static String configPropertyFilePath;
	private static String gridPath;
	
	public static String getGridPath() {
		return gridPath;
	}
	public static void setGridPath(String gridPath) {
		DriverFactory.gridPath = gridPath;
	}
	private static boolean isRemote;
	
	
	public static String getConfigPropertyFilePath() {
		return configPropertyFilePath;
	}
	public static void setConfigPropertyFilePath(String configPropertyFilePath) {
		DriverFactory.configPropertyFilePath = configPropertyFilePath;
	}
	public static boolean isRemote() {
		return isRemote;
	}
	public static void setRemote(boolean isRemote) {
		DriverFactory.isRemote = isRemote;
	}
	public static String getChromeDriverExePath() {
		return chromeDriverExePath;
	}
	public static void setChromeDriverExePath(String chromeDriverExePath) {
		DriverFactory.chromeDriverExePath = chromeDriverExePath;
	}
	public static String getEdgeDriverExePath() {
		return edgeDriverExePath;
	}
	public static void setEdgeDriverExePath(String edgeDriverExePath) {
		DriverFactory.edgeDriverExePath = edgeDriverExePath;
	}
	public static String getIeDriverExePath() {
		return ieDriverExePath;
	}
	public static void setIeDriverExePath(String ieDriverExePath) {
		DriverFactory.ieDriverExePath = ieDriverExePath;
	}

	
	

}
