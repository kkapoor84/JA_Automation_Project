package com.ja.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class Property_File_Reader {

	public static String propertyfilepath = System.getProperty("user.dir")
			+ "/src/test/java/com/ja/config/config.properties";
	static Properties P;

	public Property_File_Reader() throws Exception {
		File F = new File(propertyfilepath);
		try {
			FileInputStream FIS = new FileInputStream(F);
			P = new Properties();
			P.load(FIS);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getvalue(String key) {
		String value = P.getProperty(key);
		return value;
	}

	/*
	 * public String GetKeyValue(String key) { Map<String,String> map = new
	 * HashMap<String,String>();
	 * 
	 * Iterator keys = P.keySet().iterator();
	 * 
	 * while (keys.hasNext()) { Object key = keys.next(); map.put(key,
	 * P.get(key)); }
	 * 
	 * } String KeyValue =P.getProperty(key); System.out.println(
	 * "chromedriver key value is" +KeyValue); return KeyValue; }
	 */

}
