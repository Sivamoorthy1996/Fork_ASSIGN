package org.fork.genericUtility;

import org.fork.pom.IMDBHomePage;
import org.fork.pom.WIKIHomePage2;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseClass extends instanceClass

{
	@BeforeClass
	public void classSetup() 
	{
		//creating object for the class
		fileutility=new FileUtility();
		webdriver=new WebDriverUtility();
		javautility=new JavaUtility();
		
		
		
		ThreadSafeClass.setWebdriverutility(webdriver);
		ThreadSafeClass.setJavautility(javautility);
		

		//intialize data from property file
		fileutility.IntiallizePropertyFile(IPathContants.FORKPROPERTYFILEPATH);

		
		//Fatching the data from property
		url = fileutility.getDataFromProperty("url");
		url1 = fileutility.getDataFromProperty("url1");
	    movieName = fileutility.getDataFromProperty("moviename");
		browser = fileutility.getDataFromProperty("browser");
		String timeout = fileutility.getDataFromProperty("timeout");
		String timeout1 = fileutility.getDataFromProperty("timeout1");
		

		
		//converting string to long
		longTimeout = javautility.convertStringToLong(timeout);
		longTimeout1 = javautility.convertStringToLong(timeout1);


		//launching the browser based on browser key
		driver = webdriver.setupDriver(browser);
		ThreadSafeClass.setDriver(driver);		
		


		//pre-setting for the browser
		webdriver.maximizeBrowser();
		webdriver.implicitWait(longTimeout);
		
		
	
		//Creating object for the common pom repo classes
		commonpage = new IMDBHomePage();
		 wikipage = new WIKIHomePage2();
		

		//navigating to the application
		webdriver.openApplication(url);
	}
	


	@AfterClass
	public void classTearDown() {
		//closing the browser
	    webdriver.closeBrowser();

	}


}
