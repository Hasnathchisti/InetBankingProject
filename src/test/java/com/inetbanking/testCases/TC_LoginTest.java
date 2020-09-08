package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;



public class TC_LoginTest extends BaseClass {
	
	public static Logger logger = LogManager.getLogger(BaseClass.class);
	
	@Test
	public void loginTest() throws IOException {
		
		logger.info("URL opened");
		
		System.out.println(driver.getTitle());
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
	
		lp.setPassword(password);
	
		lp.clickSubmit();
		
		//System.out.println(driver.getTitle());
		
		if(driver.getTitle().equals("Guru99 Bank Home Page")) {
			Assert.assertTrue(true);
		}
		else {
			getScreenShot("loginTest");
			Assert.assertTrue(false);
		}
	
	}

}
