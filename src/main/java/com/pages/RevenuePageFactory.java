package com.pages;

import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





public class RevenuePageFactory {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//input[@type='range']")
	WebElement slider;
	
	@FindBy(xpath = "//input[contains(@type,'number')]")
	WebElement sliderText;
	
	@FindBy(xpath = "//span[contains(@class,'MuiTypography-root MuiTy')]")
	List<WebElement> click;
	
	@FindBy(xpath = "(//p[contains(@class,'MuiTypography-root MuiTy')])[8]")
	WebElement trr;
	
	 public RevenuePageFactory(WebDriver d) {
		// TODO Auto-generated constructor stub
	
		driver=d;
		PageFactory.initElements(d, this);
		}
	
	public String SlideSlider() {
		
		Actions action=new Actions(driver);
		action.moveToElement(sliderText);
		action.clickAndHold(slider).moveByOffset(93,0).release().perform();
		String s=	sliderText.getAttribute("value");
		
		return s;
	}
	
	public void	EnterValue(String k) {

		Actions action=new Actions(driver);

		action.moveToElement(sliderText).build().perform();
		sliderText.clear();
		 sliderText.sendKeys(k);
		 Point point=slider.getLocation();
		int x= point.getX();
		int y=point.getY();
	  System.out.println(x+"-"+y);
		
	}
	
	public void CheckBox() {
		
	Actions action=new Actions(driver);
		for (WebElement ele : click) {
			String x=ele.getText();
			if(x.equals("57")|| x.equals("19.19")|| x.equals("63")||x.equals("15")) {
				action.moveToElement(ele);
				ele.click();
			}
		}	
	}
	public String VerifyTRR() {
	return	trr.getText();
	}
	
	
}
//