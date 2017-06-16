//package com.weightwatchers.test;

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

	@Test //This tests the MotleyFool site as per Excercise #1
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
			driver.findElement(By.className("ticker-input-input")).sendKeys("AA");
			System.out.println("Entered search text (First Part");
			//wait a bit and enter the second part of the search string
			Thread.sleep(5000);
			//enter the second part of the search string
			driver.findElement(By.className("ticker-input-input")).sendKeys("PL");
		} catch (Throwable e) {
			System.out.println("Could not enter search text");
		}
		
		//hold on for a few seconds to catch up
		Thread.sleep(5000);
		
		//then select an item from the results
		try {
			//Select Apple from the list of results
			driver.findElement(By.className("ticker-input-results-symbol")).click();
			//driver.findElement(By.name("AAPL")).click();
			System.out.println("Clicked Apple from the list of results");
		} catch (Throwable e) {
			System.out.println("Could not click Apple from the list of results");
		}
		
		
		//find the price quote container, to verify it's there
		try {
			assertEquals("price-quote-container", driver.findElement(By.className("price-quote-container")).getAttribute("price-quote-container"));
			System.out.println("Found the price quote container");
		} catch (Throwable e) {
			System.out.println("Could not find the price quote container");
		}
		
		
		
		//on the details screen, find the current price of the stock, and display it via println statement
		try {
			//driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/section/section[2]/aside/h2[2]"));
			driver.findElement(By.className("current-price"));
			System.out.println("Found the current price of the stock");
			System.out.println("Current Price of the stock is " + driver.findElement(By.className("current-price")));
		} catch (Throwable e) {
			System.out.println("Couldn't find the current stock price");
		}
		
		//First find the data table for the stock info
		try {
			driver.findElement(By.className("key-data-points data-table key-data-table1"));
			System.out.println("Found the data table");
		} catch (Throwable e) {
			System.out.println("Couldn't find the data table");
		}
		
		
		//Print the 52wk high for the stock
		//traverse through the table
		//find the 52 week range entry
		//then print the 52 week entry
		
		//Compare current price to high-low in range and display it via println statement
		//get the current price and make it a int ("int aaplCurrPrice")
		//Note there is no low price
		
		
		//get the EPS for apple stock and save it
		//traverse through the table
		//find the EPS entry
		//print the EPS entry
		//get the EPS entry and make it a int ("int aaplEPS")
		
		//search for another stock (i.e.: Citi)
		//click to open the search field
		try {
			driver.findElement(By.className("header-search-wrapper-toggle")).click();
			System.out.println("clicked to open search");
		} catch (Throwable e) {
			System.out.println("search was not opened");
			
		}
		
		//Enter the search text for the next stock
		try {
			driver.findElement(By.className("ticker-input-input")).sendKeys("CI");
			System.out.println("Entered search text (First Part");
			//wait a bit and enter the second part of the search string
			Thread.sleep(5000);
			//enter the second part of the search string
			driver.findElement(By.className("ticker-input-input")).sendKeys("TI");
		} catch (Throwable e) {
			System.out.println("Could not enter search text");
		}
		
		//select CITI from list of results
		try {
			//Select Apple from the list of results
			driver.findElement(By.className("ticker-input-results-symbol")).click();
			System.out.println("Clicked Citi from the list of results");
		} catch (Throwable e) {
			System.out.println("Could not click Citi from the list of results");
		}
		
		//get the eps for citi stock and display it via println statement
		//traverse through the table
		//find the EPS entry
		//print the EPS entry
		//get the EPS entry and make it a int ("int citiEPS")
		
		
		//compare eps for citi stock to apple stock and display which is higher via println statement
		//set an int value for the result ("int compResult")
		//then do the comparison and print out the value
		//int compResult
		// if (aaplEPS > citiEPS) {
				//compResult = aaplEPS;
			//}
			//else
			//{
			// compResult = citiEPS;
			//then print out the results
			//System.out.println("Largest of the two is " + compResult);
			//}
	}
	
	public void tearDown() throws Throwable {
		driver.closeApp();//closes simulator
		System.out.println("Done for now");
	}
}
