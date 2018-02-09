package com.journey.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.journey.generic.BaseTest;

public class HomePage extends BaseTest {
	/*@FindBy(id="flight-origin")
	private WebElement source;
	
	@FindBy(id="flight-destination")
	private WebElement destination;*/
	
	public HomePage(WebDriver driver)
	{
		 this.driver=driver;
	}

	public void selectMenuCategory(String menu)
	{
		driver.findElement(By.xpath("//span[text()='"+menu+"']")).click();
	}
	
	public void selectTripType(String tripType)
	{
		 WebElement trip = driver.findElement(By.xpath("//span[text()='"+tripType+"']"));
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();",trip);
	}
	
	public void selectJourney(String source , String destination) 
	{
		driver.findElement(By.id("flight-origin")).sendKeys(source);
		//driver.findElement(By.id("aria-option-0")).click();
		driver.findElement(By.id("flight-destination")).sendKeys(destination);
		//driver.findElement(By.id("aria-option-0")).click();
		
	}
	
	
	/*WebElement date=driver.findElement(By.id("flight-departing"));
	String dateval="01/29/2018";
	public static void selectDate(WebDriver driver, String date2, String dateval)

	{ 
		
				
				JavascriptExecutor js = (JavascriptExecutor)driver;
				 js.executeScript("arguments[0].setAttribute('value','"+dateval+"')",date2);
	}*/
	
	public void selectJourneyDate() throws InterruptedException
	{
		driver.findElement(By.id("flight-departing")).click();
		List<WebElement> activeDeparttureDateList = driver.findElements(By.xpath(
				"//div[@id='flight-departing-wrapper']/div/div/div[2]/table/tbody//tr//td/button[@class != 'datepicker-cal-date disabled']"));

		 //Click on first active date from the list 
		//Thread.sleep(3000);
		
		activeDeparttureDateList.get(1).click();
		WebElement checkbox = driver.findElement(By.id("flexibleDate-label"));
		if(!checkbox.isSelected())
		{
			checkbox.click();
		}
		
	}
	
	public void selectAdultsCount(int value)
	{
	
		Select select = new Select(driver.findElement(By.id("flight-adults")));
		select.selectByIndex(value);
		
		
	}
	public void selectChildrenCount(int value)
	{
		Select select1 = new Select(driver.findElement(By.id("flight-children")));
		select1.selectByIndex(value);
		Select select2 = new Select(driver.findElement(By.id("flight-age-select-1")));
		select2.selectByIndex(10);
		Select select3 = new Select(driver.findElement(By.id("flight-age-select-2")));
		select3.selectByIndex(8);
	}
	public void clickOnSearchButton()
	{
		WebElement searchBtn = driver.findElement(By.xpath("//span[text()='Search']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();",searchBtn);
	}
	
}
