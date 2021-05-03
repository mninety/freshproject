package init;

import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import init.clear;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.FlushAPIresponse;
import utils.TestData;

public class SeleniumWebTest {
	
	public WebDriver driver;

	public String OS = "windows";

	public String uploadFilelocation = "D:\\AutomationImage.JPG";
	public String adminusername = "admin-automation@gmail.com";
	public String adminpassword = "Automation@123";
	
	

	@BeforeMethod
	public void setUp() 
	{
		try {
			TestData testdata = new TestData();
			String browserName = testdata.properties.getProperty("browserName");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		else if(browserName.equalsIgnoreCase("headless")) {
			ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--disable-features=VizDisplayCompositor");
			chromeOptions.addArguments("--window-size=1920,1080");
			chromeOptions.addArguments("--start-maximized");
			chromeOptions.addArguments("--always-authorize-plugins");
		    chromeOptions.addArguments("--allow-running-insecure-content");
		    //chromeOptions.addArguments("--remote-debugging-port=9222");
		    chromeOptions.addArguments("--whitelisted-ips"); 
		    chromeOptions.setBinary("/usr/bin/google-chrome");
		    chromeOptions.addArguments("--disable-extensions"); // disabling extensions
		    chromeOptions.addArguments("--disable-gpu"); // applicable to windows os only
		    chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		    chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
			driver = new ChromeDriver(chromeOptions);

			
		}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Here we are quitting the driver
	@AfterMethod
	public void afterTest(ITestResult result) {
		clear clear= new clear();
		
		try {
			clear.clearDB_afterTest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		   if (result.getStatus() == ITestResult.FAILURE) {
			   System.out.println(result.getMethod().getMethodName()+ " is failed");
		   }
		   else {
			   System.out.println(result.getMethod().getMethodName()+ " is passed");
		   }
		
		   driver.quit();
	}
}
