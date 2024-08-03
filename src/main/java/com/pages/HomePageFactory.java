package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {
 
	private WebDriver driver;
	
	@FindBy(xpath = "//div[contains(text(),'Revenue Calculator')]")
	WebElement revenueElement;
	
	
	
	public HomePageFactory(WebDriver d) {
			driver=d;
			PageFactory.initElements(d, this);
			}
	
	public void revenuePage(){
	revenueElement.click();
	}
	
	
}
