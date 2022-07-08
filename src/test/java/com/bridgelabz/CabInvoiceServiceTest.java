package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceServiceTest {

	@Test
	void givenDistanceAndTime_ShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.5;
		int time = 2;
		double totalFare = invoiceGenerator.calculateFare(distance, time);

		Assertions.assertEquals(27, totalFare);
	}

	@Test
	void givenDistanceAndTime_ShouldReturnMinimumFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double totalFare = invoiceGenerator.calculateFare(distance, time);

		Assertions.assertEquals(5, totalFare);
	}

	@Test
	void givenMultipleRides_ShouldReturnAggregateFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = { new Ride(3, 4), new Ride(6, 9), new Ride(0.1, 1) };
		double aggregateTotal = invoiceGenerator.calculateFare(rides);
		Assertions.assertEquals(108.0, aggregateTotal);
	}

	@Test
	void givenMultipleRides_ShouldReturnInvoice() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = { new Ride(3, 4), new Ride(6, 9), new Ride(0.1, 1) };
		Invoice invoice = invoiceGenerator.generateInvoice(rides);
		Invoice invoice1 = new Invoice(108.0, 3, 36.0);
		Assertions.assertEquals(invoice1, invoice);
	}

	@Test
	void givenUserID_ShouldReturnInvoiceForParticularUser() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		String userId = "Alok";
		String userId1 = "Rahul";
		Ride[] rides = { new Ride(2, 5), new Ride(5, 10) };
		Ride[] rides1 = { new Ride(5, 15), new Ride(7.0, 50) };
		invoiceGenerator.addRide(userId, rides);
		invoiceGenerator.addRide(userId1, rides1);
		Invoice invoice = invoiceGenerator.getInvoice(userId);
		//Invoice invoice1 = invoiceGenerator.getInvoice(userId1);
		Invoice expectedInvoice = new Invoice(84.0, 2, 42.5);
		//Invoice expectedInvoice1 = new Invoice(185, 2, 92.5);
		Assertions.assertEquals(expectedInvoice, invoice);
		//Assertions.assertEquals(expectedInvoice1, invoice1);
	}
}