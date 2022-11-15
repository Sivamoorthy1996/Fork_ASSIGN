package org.fork.pom;

import org.fork.genericUtility.ThreadSafeClass;
import org.fork.genericUtility.WebDriverUtility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WIKIHomePage2 {
	
	public WIKIHomePage2(){
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}

	
	@FindBy(xpath = "//div[text()='Release date' ]/parent::th/following-sibling::td//li")
	private WebElement element;
	
	@FindBy(xpath = "//th[text()='Country']/following-sibling::td[@class='infobox-data']")
	private WebElement countryName;
	
	@FindBy(xpath = "//div[text()='Release date' ]/parent::th/following-sibling::td//li")
	private WebElement releaseDate;
	
	

	/*
	 * This method is used to get the country name
	 */
	public String GetCountryName(String URL ,WebDriver driver,WebDriverUtility webdriver )
	{
        webdriver.openApplication(URL);
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("arguments[0].scrollIntoView(true)", element);
		return countryName.getText();	
	}
	
	/*
	 * This method is used to get the release date
	 */
	public String GetReleaseDate()
	{
	
		return releaseDate.getText();	
	}
}
