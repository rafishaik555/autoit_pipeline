package com.orangehrm.demo.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;

import com.orangehrm.demo.extentListeners.ExtentListeners;
import com.orangehrm.demo.utilities.DriverFactory;
import com.orangehrm.demo.utilities.DriverManager;
import com.orangehrm.demo.utilities.FilePaths;
import com.orangehrm.demo.utilities.Read_XLS;


public class BaseTest  {

	private WebDriver driver;
	private Properties Config = new Properties();
	private FileInputStream fis;
	public Logger log = Logger.getLogger(BaseTest.class);
	public boolean grid=false;
	private String defaultUserName;
	private String defaultPassword;
	public static Read_XLS TestSuiteListExcel=null;
	public static Read_XLS TestLoginSuite=null;
	public static Read_XLS TestRegisterUserSuite=null;
	
	

	public String getDefaultUserName() {
		return defaultUserName;
	}




	public void setDefaultUserName(String defaultUserName) {
		this.defaultUserName = defaultUserName;
	}




	public String getDefaultPassword() {
		return defaultPassword;
	}




	public void setDefaultPassword(String defaultPassword) {
		this.defaultPassword = defaultPassword;
	}




	@BeforeSuite
	public void setUpFramework() {

		configureLogging();
		DriverFactory.setGridPath("http://localhost:4444/wd/hub");
		DriverFactory.setConfigPropertyFilePath(
				System.getProperty("user.dir") + "//src//test//resources//properties//Config.properties");
	
		
        if (System.getProperty("os.name").equalsIgnoreCase("mac")) {
        	
        	DriverFactory.setChromeDriverExePath(
    				System.getProperty("user.dir") + "//src//test//resources//executables//chromedriver");
    		DriverFactory.setEdgeDriverExePath(
    				System.getProperty("user.dir") + "//src//test//resources//executables//geckodriver");
    	
        }else {
		
		
		DriverFactory.setChromeDriverExePath(
				System.getProperty("user.dir") + "//src//test//resources//executables//chromedriver.exe");
		DriverFactory.setEdgeDriverExePath(
				System.getProperty("user.dir") + "//src//test//resources//executables//msedgedriver.exe");
		DriverFactory.setIeDriverExePath(
				System.getProperty("user.dir") + "//src//test//resources//executables//IEDriverServer.exe");

        }
		/*
		 * Initialize properties Initialize logs load executables
		 * 
		 */
		try {
			fis = new FileInputStream(DriverFactory.getConfigPropertyFilePath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Config.load(fis);
			log.info("Config properties file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

	}
	

	
	
	public void logInfo(String message) {
		
		ExtentListeners.testReport.get().info(message);
	}

	public void configureLogging() {
		String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src/test/resources/properties" + File.separator
				+ "log4j.properties";
		PropertyConfigurator.configure(log4jConfigFile);
	}

	public void destroyFramework() {

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
	}

	public void openBrowser(String browser) {
		
		if(System.getenv("ExecutionType")!=null && System.getenv("ExecutionType").equals("Grid")) {
			System.out.println("WITH SELENIUM GRID.........1...........");
			grid=true;
		}
		

		DriverFactory.setRemote(grid);

		if (DriverFactory.isRemote()) {
			System.out.println("WITH SELENIUM GRID.........2...........");
			DesiredCapabilities cap = null;

			if (browser.equals("Edge")) {

				cap = DesiredCapabilities.edge();
				cap.setBrowserName("Edge");
				cap.setPlatform(Platform.WIN10);

			} else if (browser.equals("chrome")) {
				System.out.println("WITH SELENIUM GRID.........CHROME...........");
				cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.ANY);
			} else if (browser.equals("IE")) {
				System.out.println("WITH SELENIUM GRID........IE..........");
				cap = DesiredCapabilities.internetExplorer();
				cap.setBrowserName("iexplore");
				cap.setPlatform(Platform.WIN10);
			}

			try {
				driver = new RemoteWebDriver(new URL(DriverFactory.getGridPath()), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else
			System.out.println("WITH OUT SELENIUM GRID....................");
		if (browser.equals("chrome")) {
			System.out.println("Launching : " + browser);
			System.setProperty("webdriver.chrome.driver",
					DriverFactory.getChromeDriverExePath());
			driver = new ChromeDriver();
		} else if (browser.equals("Edge")) {
			System.out.println("Launching : " + browser);
			System.setProperty("webdriver.edge.driver",
					DriverFactory.getEdgeDriverExePath());
			driver = new EdgeDriver();

		}
		else if (browser.equals("IE")) {
			System.out.println("Launching : " + browser);
			System.setProperty("webdriver.ie.driver",
					DriverFactory.getIeDriverExePath());
			driver = new InternetExplorerDriver();

		}

		DriverManager.setWebDriver(driver);
		log.info("Driver Initialized !!!");
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		setDefaultUserName(Config.getProperty("defaultUserName"));
		setDefaultPassword(Config.getProperty("defaultPassword"));
	}

	public void quit() {

		//DriverManager.getDriver().quit();
		log.info("Test Execution Completed !!!");
	}
}
