package com.ustglobal.filehandling;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesFileReader {
	
	public static void main(String[] args) {
		 String path ="db.properties";
		 FileReader reader = null;
		 try {
			 
			 reader = new FileReader(path);
			 Properties properties = new Properties();
			 properties.load(reader);
			 
			 String url = properties.getProperty("url");
			 String user = properties.getProperty("user");
			 String password = properties.getProperty("password");
			 
			 System.out.println("Name: "+url);
			 System.out.println("comapny: "+user);
			 System.out.println("gf: "+password);
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}

}
