package com.journey.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

@Listeners(CustomListener.class)

public class BaseTest implements InterfaceConstants {
	public WebDriver driver;
	ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;
	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		
		}
	@BeforeSuite
	public void createReport()
	{
		extent = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(REPORT_PATH1);
       
        extent.attachReporter(htmlReporter);
	}
	@AfterSuite
	public void flush()
	{
		extent.flush();
	}
	@Parameters("browser")
	@BeforeMethod(alwaysRun=true)
	public void openApplication(String browser)
	{
		//driver = new ChromeDriver();
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName(browser);
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		//driver.manage().window().maximize();
		driver.get("https://www.orbitz.com");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeApplication(ITestResult result)
	{
		
		String testName = result.getName();
		System.out.println(testName);
		 test = extent.createTest(testName);
		if(result.getStatus()==1)
		{
			test.pass("pass");
		}
		else
		{
			
		}test.fail("fail");
		
		driver.quit();
	}

}
