package com.weightwatchers.test;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

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
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;

public class WWExternalMethods {
	
/*			public void loginOptions(AppiumDriver driver, String serviceEnv, String feedEnv) {
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]")).click();//Debug Settings 
			//driver.findElement(By.name("OK")).click();//Alert Pop-up
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]")).click();//Service Env:
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAPicker[1]/UIAPickerWheel[1]")).sendKeys(serviceEnv);
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]")).click();//Feed Env:
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAPicker[1]/UIAPickerWheel[1]")).sendKeys(feedEnv);	
			driver.findElement(By.name("Nav_Back")).click();
			
		}*/
	

	

	
	public static void startAppium (AppiumDriver driver) throws Exception {
		Process p;
		//p = Runtime.getRuntime().exec("/usr/bin/open -a Terminal " + WWExternalMethods.DataFileDirectory + "WebMDCL.sh");
		p = Runtime.getRuntime().exec("/usr/bin/open -a Terminal " + "WebMDCL.sh");
	}
	
	public static void killAppium (AppiumDriver driver) throws Exception {
		Process p;
		//p = Runtime.getRuntime().exec("/usr/bin/open -a Terminal " + WWExternalMethods.DataFileDirectory + "killAppium.sh");
		p = Runtime.getRuntime().exec("usr/bin/open -a Terminal " + "killAppium.sh");
	}
}

	

