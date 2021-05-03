package PagesRepository;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.TestData;

public class Users {
	
	
	WebDriver driver;
	
	//Constructor
		public Users(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
	//Page constants
	@FindBy(xpath = "//button/span[@class='navbar-toggler-icon']")	
	public WebElement burgericon;
	
	@FindBy(xpath = "//input[@role='combobox']")	
	public WebElement searchbox;
	
	@FindBy(name="btnK")
	public WebElement searchBtn;
	
	
	@FindBy(xpath="//button")
	public List<WebElement> accessaspartner1;
	

	
	public void getpartneraccess(int i){

		accessaspartner1.get(i).click();
	}
}

