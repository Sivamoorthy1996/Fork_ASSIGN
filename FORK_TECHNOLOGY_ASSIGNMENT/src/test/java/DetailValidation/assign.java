package DetailValidation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assign  {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		driver.get("https://www.imdb.com/");
		driver.findElement(By.id("suggestion-search")).sendKeys("Pushpa: The Rise "+Keys.ENTER);
    	driver.findElement(By.xpath("//a[text()='Pushpa: The Rise - Part 1']")).click();
    	WebElement element = driver.findElement(By.xpath("//span[text()='Details']"));
    	JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("arguments[0].scrollIntoView(true)", element);
    	
    	
    	String IMDB_CountryName = driver.findElement(By.xpath("//a[@href='/search/title/?country_of_origin=IN&ref_=tt_dt_cn']")).getText();
    	System.out.println(IMDB_CountryName);
    	String IMDB_ReleaseDate = driver.findElement(By.xpath("//a[@href='/title/tt9389998/releaseinfo?ref_=tt_dt_rdat' and @class='ipc-metadata-list-item__list-content-item ipc-metadata-list-item__list-content-item--link']")).getText();
    	System.out.println(IMDB_ReleaseDate);
    	driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
    	WebElement element1=driver.findElement(By.xpath("//div[text()='Release date' ]/parent::th/following-sibling::td//li"));
    	JavascriptExecutor j1 = (JavascriptExecutor)driver;
    	j1.executeScript("arguments[0].scrollIntoView(true)", element1);
    	String WIKI_ReleaseDate = driver.findElement(By.xpath("//div[text()='Release date' ]/parent::th/following-sibling::td//li")).getText();
    	System.out.println(WIKI_ReleaseDate);
    	String WIKI_CountryName = driver.findElement(By.xpath("//th[text()='Country']/following-sibling::td[@class='infobox-data']")).getText();
    	System.out.println(WIKI_CountryName);
    	
    	 Assert.assertEquals(IMDB_CountryName, WIKI_CountryName);
//		  if(WIKI_ReleaseDate.contains(IMDB_ReleaseDate))
//		  {
//			  System.out.println("The details present in both wiki and imdb is same");
//		  }
//		  else
//			  System.out.println("The details present in both wiki and imdb is not same");
    	
    	
    	
    	
    	
//		Set<String> allwh = driver.getWindowHandles();
//		for(String wh:allwh)
//		{
//			Thread.sleep(2000);
//			driver.switchTo().window(wh);
//			Thread.sleep(2000);
//			driver.close();
//		}

	}

}
