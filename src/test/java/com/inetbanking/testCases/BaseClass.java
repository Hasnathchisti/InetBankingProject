package com.inetbanking.testCases;


import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();
	public String baseURL = readConfig.getApplicationUrl();
    public String username = readConfig.getUserName();
	public String password = readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger = LogManager.getLogger(BaseClass.class);
	

@Parameters("browser")
@BeforeClass
public void setup(String browser) {
	if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", readConfig.getChromeDriverPath());
		driver = new ChromeDriver();
	}
	else if(browser.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxDriverPath());
		driver = new FirefoxDriver();
	}
	driver.get(baseURL);
	
	

}
@AfterClass
public void tearDown() {
	driver.quit();
	
}

public void getScreenShot(String tname) throws IOException{
	
	File SrcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(SrcFile, new File(System.getProperty("user.dir")+"/Screenshot/"+tname+".png"));
	    System.out.println("Screensot Taken");
	    
	
	}

public String randomestring() {
	String generatedstring=RandomStringUtils.randomAlphabetic(8);
	return(generatedstring);
	
}


}
