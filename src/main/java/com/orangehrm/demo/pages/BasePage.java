package com.orangehrm.demo.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.demo.extentListeners.ExtentListeners;
import com.orangehrm.demo.utilities.DriverManager;


public abstract class BasePage<T> {

	
	
	protected WebDriver driver;
	
	  private long LOAD_TIMEOUT = 190;
     private int AJAX_ELEMENT_TIMEOUT = 60;

	    public BasePage() {
	        this.driver = DriverManager.getDriver();
	    }

	  
	    
	    
	    public T openPage(Class<T> clazz) {
	        T page = null;
	        try {
	            driver = DriverManager.getDriver();
	            AjaxElementLocatorFactory ajaxElemFactory = new AjaxElementLocatorFactory(driver, AJAX_ELEMENT_TIMEOUT);
	            page = PageFactory.initElements(driver, clazz);
	            PageFactory.initElements(ajaxElemFactory, page);
	           /* ExpectedCondition pageLoadCondition = ((BasePage) page).getPageLoadCondition();
	            waitForPageToLoad(pageLoadCondition);*/
	        } catch (NoSuchElementException e) {
	        /*    String error_screenshot = System.getProperty("user.dir") + "\\target\\screenshots\\" + clazz.getSimpleName() + "_error.png";
	            this.takeScreenShot(error_screenshot);
	     */       throw new IllegalStateException(String.format("This is not the %s page", clazz.getSimpleName()));
	        }
	        return page;
	    }

	    private void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
	    	WebDriverWait wait = new WebDriverWait(driver,LOAD_TIMEOUT);
	        wait.until(pageLoadCondition);
	    }

	    //protected abstract ExpectedCondition getPageLoadCondition();

		
		public void click(WebElement element, String elementName) {
			
			element.click();
			ExtentListeners.testReport.get().info("Clicking on : "+elementName);
			
		}
		
		public void type(WebElement element, String value, String elementName) {
			
			element.sendKeys(value);
			ExtentListeners.testReport.get().info("Typing in : "+elementName+" entered the value as : "+value);
		//
		}
	
		public void clear(WebElement element) {
			
			element.clear();
			ExtentListeners.testReport.get().info("Clearing the contents : CLEAR");
		
		}
		
		
}
