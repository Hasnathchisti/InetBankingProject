package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fls = new FileInputStream(src);
			pro= new Properties();
			pro.load(fls);
		
	}
	catch(Exception e) {
		
		System.out.println("Exception is "+ e.getMessage());
		}
	}
	
	
	public String getApplicationUrl() {
		
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUserName() {
		
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromeDriverPath() {
		String chromePath = pro.getProperty("chromepath");
		return chromePath;
	}
	public String getFirefoxDriverPath() {
		String fireFoxPath = pro.getProperty("firefoxpath");
		return fireFoxPath;
	}
	
	

}
