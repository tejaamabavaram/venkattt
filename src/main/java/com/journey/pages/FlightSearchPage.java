package com.journey.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage {

	static WebElement date;
	
	@FindBy(xpath="//span[.='Flight Only']")
	private WebElement FlightOnlyLink;
	
	@FindBy(xpath="//span[.='Flight + Hotel']")
	private WebElement flight_HotelLink;
	
	@FindBy(xpath="//span[.='Flight + Hotel + Car']")
	private WebElement flight_Hotel_CarLink;
	
	@FindBy(xpath="//span[.='Flight + Car']")
	private WebElement flight_CarLink;
	
	@FindBy(xpath="//span[.='Roundtrip']")
	private WebElement roundtripLink;
	
	@FindBy(xpath="//span[.='One way']")
	private WebElement oneWayLink;
	
	@FindBy(xpath="//span[.='Multi-city']")
	private WebElement multiCityLink;
	
	@FindBy(css="input[id='flight-origin']")
	private WebElement flightOriginTextBox;
	
	@FindBy(css="input[id='flight-destination']")
	private WebElement flightDestinationTesxtBox;
	
	@FindBy(id="flight-departing")
	private WebElement flightDepartureLink;
	
	@FindBy(id="flight-returning")
	private WebElement flightReturnLink;
	
	@FindBy(xpath="//select[@id='flight-adults']")
	private WebElement adultsCountDropdown;
	
	@FindBy(xpath="//select[@id='flight-children']")
	private WebElement childrensCountDropdown;
	
	@FindBy(css="button[id='search-button']")
	private WebElement searchButton;
	
	@FindBy(css="div[id='flight-errors']")
	private WebElement errorMsg;
	
	@FindBy(xpath="//div[@id='flight-departing-wrapper']/div/div/div[2]/table/tbody//tr//td/button[@class != 'datepicker-cal-date disabled']")
	private List<WebElement> datepicker;
	
	@FindBy(id="flight-departing")
	private WebElement flightdepart;

	/*Page Factory Method */
	public FlightSearchPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/* Getter methods */
	public WebElement getFlightOnlyLink() {
		return FlightOnlyLink;
	}

	public WebElement getFlight_HotelLink() {
		return flight_HotelLink;
	}

	public WebElement getFlight_Hotel_CarLink() {
		return flight_Hotel_CarLink;
	}

	public WebElement getFlight_CarLink() {
		return flight_CarLink;
	}
	
	public void clickFlightOnly()
	{
		getFlightOnlyLink().click();
	}

	public WebElement getOneWayLink() {
		return oneWayLink;
	}

	public WebElement getMultiCityLink() {
		return multiCityLink;
	}

	public WebElement getFlightOriginTextBox() {
		return flightOriginTextBox;
	}

	public WebElement getFlightDestinationTesxtBox() {
		return flightDestinationTesxtBox;
	}

	public WebElement getFlightDepartureLink() {
		return flightDepartureLink;
	}

	public WebElement getFlightReturnLink() {
		return flightReturnLink;
	}

	public WebElement getAdultsCountDropdown() {
		return adultsCountDropdown;
	}

	public WebElement getChildrensCountDropdown() {
		return childrensCountDropdown;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	public WebElement getErrorMsg() {
		return errorMsg;
	}
	
	/* user implementation Methods */
	
	public void clickFlight_Hotel()
	{
		getFlight_HotelLink().click();
	}
	public void clickFlight_Hotel_Car()
	{
		getFlight_Hotel_CarLink().click();
	}
	
	public void clickOnFlight_Car()
	{
		getFlight_CarLink().click();
	}

	public WebElement getRoundtripLink() {
		return roundtripLink;
	}

	
	public List<WebElement> getDatepicker() {
		return datepicker;
	}

	public void clickOnRoundTrip(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",roundtripLink);
	}
	
	public void clickOnOneWay(WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",oneWayLink);
	
	}
	
	public void clickOnMultiCity(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",multiCityLink);
	}
	
	public void selectOrigin(String origin) 
	{
		getFlightOriginTextBox().sendKeys(origin);
	}
	
	public void selectDestination(String destination)
	{
		getFlightDestinationTesxtBox().sendKeys(destination);
	}
	
	public void selectAdultsCount(String value)
	{
		Select select = new Select(adultsCountDropdown);
		select.selectByValue(value);
	}

	public void selectChildrenCount(String value)
	{
		Select select = new Select(childrensCountDropdown);
		select.selectByValue(value);
		
	}
	
	public void pickDepartureDate(int index)
	{
	
		/*flightdepart.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",datepicker);
		datepicker.get(index).click();
		Date d = new Date();
		String str = d.toString();
		String[] v= str.split(" ");
		String today = v[2];
		System.out.println(today);
		getDatepicker().sendKeys(today);
		System.out.println("selected");*/
		
		
		
	}
	
	public static void selectDate(WebDriver driver, WebElement element,String dateval)
	{
		
		date = driver.findElement(By.id("flight-departing"));
		date.click();
		//String dateval="02/05/2018";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value', '" +dateval+"')",element);
	}
	
	public void clickOnSearchButton(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",searchButton);
	}
	
	public void getErrorMessage()
	{
		//Reporter.log("ErrorMessage:"+getErrorMsg().getText(),true);
		System.out.println("ErrorMessage:"+getErrorMsg().getText());
	}
}

