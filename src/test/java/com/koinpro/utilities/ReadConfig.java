package com.koinpro.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		File src = new File(System.getProperty("user.dir")+"\\Configuration\\config.properties");
//		File src = new File("C:\\Users\\Mayank Morya\\eclipse-workspace\\koinpro\\Configuration\\config.properties");
		
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		}
		catch (Exception e) {
			System.out.println("Exception is " +e.getMessage());
		}
			
		
	}

	
	public String getapplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() {
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getpassword() {
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getsignUpURL() {
		String signUpURL=pro.getProperty("signUpURL");
		return signUpURL;
	}
		
}
