package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/*
 * @author Priya Pal
 * Used to read the data from Property File
 */
public class FileUtility {
 /*
  * Used to read the data from common  data.property file 
  * based on Key which you pass as an argument
  * @Parameter key
  * @throws Throwable
  */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("./Data/Data.properties");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;		
	}
}
