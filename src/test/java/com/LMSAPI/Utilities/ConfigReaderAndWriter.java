package com.LMSAPI.Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderAndWriter {
	
	public static Properties prop;
	public Properties init_prop() {
	System.out.println("executing LoadProperties.....");
	try {
	/* System.out.println(System.getProperty("user.dir") +
	 "//src//test//resources//config.properties");*/
	prop = new Properties();
	FileInputStream ip = new FileInputStream( System.getProperty("user.dir") +"\\src\\test\\resources\\LMSAPICofig.properties");
	prop.load(ip);
	} catch (FileNotFoundException e)
	{ e.printStackTrace();
	} catch (IOException e)
	{ e.printStackTrace(); }
	return prop;
	}
	public static Properties loadConfig() {
	System.out.println("executing LoadProperties....."); try {
	System.out.println(System.getProperty("user.dir") +
	"//src//test//resources//config.properties");
	FileInputStream ip = new FileInputStream( System.getProperty("user.dir") +
	"\\src\\test\\resources\\LMSAPICofig.properties");
	 prop.load(ip);
	} catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException
	e) { e.printStackTrace(); }
	return prop;
	}
	public static void storeConfig(String key, String value) throws IOException {
	prop = loadConfig();
	//Populating the properties file props.put(key, value); //Instantiating the
	String path = System.getProperty("user.dir") +
	"\\src\\test\\resources\\LMSAPICofig.properties";
	FileOutputStream outputStream
	= new FileOutputStream(path); //Storing the properties file
	prop.store(outputStream, "This is a sample properties file");
	System.out.println("Properties file created......"); }
}