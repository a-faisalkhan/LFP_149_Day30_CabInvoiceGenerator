package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class PremiumRidesTest {

	@Test
	public void givenDistanceAndTime_whenPremiumCalculateFare_ShouldReturnTotalFare() {
		PremiumRides invoiceService = new PremiumRides();
		double totalFare = invoiceService.premiumCalculateFare(10.0, 20);
		System.out.println("Total Fare = " + totalFare);
		Assert.assertEquals(240.0, totalFare, 0.0);
	}
	
	@Test
	public void givenDistanceAndTime_whenPremiumCalculateFareIsLessThan20_ShouldReturnTotalFareAs5() {
		InvoiceGenerator invoiceService = new InvoiceGenerator();
		double totalFare = invoiceService.calculateFare(5.0, 5);
		System.out.println("Total Fare = " + totalFare);
		Assert.assertEquals(55, totalFare, 0.0);
	}
}
