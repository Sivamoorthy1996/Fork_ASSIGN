package DetailValidation;

import org.fork.genericUtility.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;


public class validation extends BaseClass
{
	  @Test
		public void verifingDetails() 
		{
		    
		  String IMDB_CountryName = commonpage.GetCountryName(movieName,driver) ;
		  String IMDB_ReleaseDate = commonpage.GetReleaseDate() ; 
		
		  String WIKI_CountryName = wikipage.GetCountryName(url1, driver, webdriver);
		  String WIKI_ReleaseDate = wikipage.GetReleaseDate() ; 
		  
		  Assert.assertEquals(IMDB_CountryName, WIKI_CountryName);
//		  if(WIKI_ReleaseDate.contains(IMDB_ReleaseDate))
//		  {
//			  System.out.println("The details present in both wiki and imdb is same");
//		  }
//		  else
//			  System.out.println("The details present in both wiki and imdb is not same");
			  
		  
		 
		  
		}
}
