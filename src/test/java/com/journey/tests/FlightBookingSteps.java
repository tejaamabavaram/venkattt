package com.journey.tests;

import org.testng.annotations.Test;
import com.journey.generic.BaseTest;
import com.journey.pages.HomePage;

public class FlightBookingSteps extends BaseTest {
	

	@Test(priority=1)
	public void testFlightBookingSteps() throws InterruptedException {
		HomePage homepage = new HomePage(driver);
		homepage.selectMenuCategory("Flights");
		homepage.selectTripType("One way");
		homepage.selectJourney("Pune", "Mumbai");
		//homepage.selectJourneyDate();
		//homepage.selectAdultsCount(2);
		//homepage.selectChildrenCount(2);
		//homepage.clickOnSearchButton();
	
		
	}
}
