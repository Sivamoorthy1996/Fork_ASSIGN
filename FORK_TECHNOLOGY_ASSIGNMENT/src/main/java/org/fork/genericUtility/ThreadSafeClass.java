package org.fork.genericUtility;

import org.openqa.selenium.WebDriver;

public class ThreadSafeClass {
	
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	private static ThreadLocal<WebDriverUtility> webdriverutility=new ThreadLocal<>();
	private static ThreadLocal<JavaUtility> javautility=new ThreadLocal<>();
	private static ThreadLocal<JavaScriptExcecutorUtility> javascriptutility=new ThreadLocal<>();
	
	
	public static JavaScriptExcecutorUtility getJavascriptutility() {
		return javascriptutility.get();
	}

	

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static WebDriverUtility getWebdriverutility() {
		return webdriverutility.get();
	}

	public static JavaUtility getJavautility() {
		return javautility.get();
	}
	

	public static void setJavautility(JavaUtility javdriver) {
		javautility.set(javdriver);
	}
	
	public static void setWebdriverutility(WebDriverUtility webdriver) {
		webdriverutility.set(webdriver);
	}
	
	public static void setJavascriptutility(JavaScriptExcecutorUtility Javascriptutility) {
		javascriptutility.set( Javascriptutility);
	}

	public static void setDriver(WebDriver actdriver) {
		driver.set(actdriver);
	}
	
	

}
