package com.crm.comcast.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	/**
	 * its used to read the data from vtigercredentials.properties File based on Key which you pass as an argument
	 * @param key
	 * @throws Throwable 
	 */
	public String getPropertyKeyValue(String Key)throws Throwable
	{
		FileInputStream file=new FileInputStream(IConstants.PROPERTYFILEPATH);
		Properties prop=new Properties();
		prop.load(file);
		String value=prop.getProperty(Key);
		return value;
		
	}


}
