package AdminPanelTests;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import PagesRepository.Users;
import utils.Timing;
import utils.Verify;
import WebRepo.WebRepos;
import init.SeleniumWebTest;
import utils.FlushAPIresponse;
import utils.Randomgenerator;
import utils.TestData;



@Listeners(utils.TestMethodListener.class)
public class Admin_Users extends SeleniumWebTest{
	
	//Total 12 test cases
	
	TestData testdata;
	WebRepos waitingObj = new WebRepos();
	

	@Test(description="Hello World!")
	public void HelloWorld() throws IOException
	{
		testdata = new TestData();


		String url = testdata.properties.getProperty("env");
		Users users = new Users(driver);
		driver.get(url);
		String title= driver.getTitle();
		users.searchbox.sendKeys("Test Automation");
		users.searchbox.sendKeys(Keys.ENTER);

		//users.searchBtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Verify.verifyEquals(title, "Google", "Page title is not matched");
		
	}

	
	
}
