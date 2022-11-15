package org.fork.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


/**
 * This class contains reusable method for csv file and property file
 * @author Sivasubramaniam.M
 *
 */
public final class FileUtility {
	Properties properties;
	/**
	 * This method is used for intiallize the property file
	 * @param filePath
	 */
	public void IntiallizePropertyFile(String filePath) {
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		properties=new Properties();
		try {
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	/**
	 * This method is used to fetch the data from property file
	 * @param key
	 * @return
	 */
	public String getDataFromProperty(String key) {

		return	properties.getProperty(key);
	}


}
