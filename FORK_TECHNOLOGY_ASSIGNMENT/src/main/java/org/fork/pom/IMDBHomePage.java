package org.fork.pom;

import org.fork.genericUtility.ThreadSafeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IMDBHomePage {
	
	public IMDBHomePage(){
		PageFactory.initElements(ThreadSafeClass.getDriver(), this);
	}


	@FindBy(id="suggestion-search")
	private WebElement searchButton;
	
	@FindBy(xpath = "//a[text()='Pushpa: The Rise - Part 1']")
	private WebElement movieTextButton;
	
	@FindBy(xpath = "//span[text()='Details']")
	private WebElement element;
	
	@FindBy(xpath = "//a[@href='/search/title/?country_of_origin=IN&ref_=tt_dt_cn']")
	private WebElement countryName;
	
	@FindBy(xpath = "//a[@href='/title/tt9389998/releaseinfo?ref_=tt_dt_rdat' and @class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link']")
	private WebElement releaseDate;
	
	

	/*
	 * This method is used to get the country name
	 */
	public String GetCountryName(String movieName ,WebDriver driver )
	{
		
		searchButton.sendKeys(movieName+Keys.ENTER);
		movieTextButton.click();
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
