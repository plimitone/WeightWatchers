package com.weightwatchers.test;

import com.weightwatchers.test.WWObjectMap;
import com.weightwatchers.test.WWExternalMethods;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.AppiumDriver.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Properties;


public class PriceCompareTest {
	private AppiumDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	public Properties props = new Properties();
	public int failed = 0;
	public char Return = 13;
	
	@Before
	public void setUp() throws Throwable {
		//start the appium server
		WWExternalMethods.startAppium(driver);
		Thread.sleep(20000);
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "9.0");
		capabilities.setCapability("deviceName", "iPhone 6");
		capabilities.setCapability("browserName", "safari");
		//capabilities.setCapability("app",WWObjectMap.AppDirectory);
		capabilities.setCapability("waitForAppScript", "$.delay(1000);");
		driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.switchTo().alert().accept();		
		//System.out.println("start");
		}

	@Test //This test verifies that drugs and medications articles are properly displayed with the proper headings
	public void SafHome() throws Throwable {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//write the start time of execution at the top of the log file
		//SimpleDateFormat date = new SimpleDateFormat("d_yy_hh_mm_ss_SSS_a");
		//String formattedDate = date.format(new Date());
		//log.write(formattedDate);
		
		//Should be at the home screen
		String url = ("http://www.fool.com");
		driver.get("http://www.fool.com");
		driver.get(url);
		System.out.println("Should now be at the specified URL");
		
		//check that we're at the right url
		//Store the title name into the String variable
		String title = driver.getTitle();
		
		//Store the title length into the int variable
		int titleLength = driver.getTitle().length();
		
		//Print the title and length to the Console window
		System.out.println("The title of the page is, " + title);
		System.out.println("The length of the title is, " + titleLength);
		
		//Store the URL in String variable
		String actualUrl = driver.getCurrentUrl();
		
		if (actualUrl.equals(url)){
			System.out.println("Verification is successful --- The correct URL was opened");
		}else{
			System.out.println("Verification has failed -- Incorrect URL has opened");
			//IN CASE OF FAILURE
			System.out.println("Actual URL is " + actualUrl);
			System.out.println("Expected URL is " + url);
		}
		
		//check that the top search is displayed
		try {
			//assertEquals("lookup", driver.findElement(By.name("lookup")).getAttribute("name"));
			assertEquals("header-search-wrapper-toggle", driver.findElement(By.className("header-search-wrapper-toggle")).getAttribute("header-search-wrapper-toggle"));
			System.out.println("found the search at the top");
		} catch (Throwable e) {
			System.out.println("Didn't find the search at the top");
			
		}
		
		//click to open the search field
		try {
			driver.findElement(By.className("header-search-wrapper-toggle")).click();
			System.out.println("clicked to open search");
		} catch (Throwable e) {
			System.out.println("search was not opened");
			
		}
		
		//hold on for a few seconds to catch up
		Thread.sleep(5000);
		
		//then enter search text into the search field (ie: Aapl)
		try {
			driver.findElement(By.className("ticker-input-input")).sendKeys("Aapl");
			System.out.println("Entered search text");
		} catch (Throwable e) {
			System.out.println("Could not enter search text");
		}
		
		//hold on for a few seconds to catch up
		Thread.sleep(5000);
		
		//then select an item from the results
		try {
			//Select Apple from the list of results
			driver.findElement(By.className("ticker-input-results-symbol")).click();
			System.out.println("Clicked Apple from the list of results");
		} catch (Throwable e) {
			System.out.println("Could not click Apple from the list of results");
		}
		
		//on the details screen, find the current price of the stock, and display it via println
		try {
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/section/section[2]/aside/h2[2]"));
			System.out.println("Found the current price of the stock");
			System.out.println("Current Price of the stock is " + driver.findElement(By.className("current-price")));
		} catch (Throwable e) {
			System.out.println("Couldn't find the current stock price");
		}
		
		
		//add a failing test here to verify that the checks are working
		//check for the lifestyle video tab
		/*
		try {
			assertEquals("Video", driver.findElement(By.name("Video")).getAttribute("name"));
			log.write("Found the lifestyle video tab on the home screen", "test", true);
			log.takeSnapshot(driver);// This is a screenshot of the application
			} catch (Throwable e){
				log.write("Video tab could not be found on the home screen, failure test passes", "test", false);
				log.takeSnapshot(driver);// This is a screenshot of the application
			   	verificationErrors.append(WebMDObjMap.BuildNumber + " PERF " + "Video tab could not be found on the home screen, failure test passes");
			    verificationErrors.append(Return);
			}
		*/
	}
	
	public void tearDown() throws Throwable {
		driver.closeApp();//closes simulator
		System.out.println("Done for now");
	}
	
}