package com.bridgelabz;

public class InvoiceGenerator {
	final static double COST_PER_KM = 10;
	final static double MINIMUM_FARE = 5;
	final static double COST_PER_MINUTE = 1;

	double calculateFare(double distance, int time) {
		double totalFare = (distance * COST_PER_KM) + (time * COST_PER_MINUTE);
		if(totalFare < MINIMUM_FARE)
			totalFare = MINIMUM_FARE;
		return totalFare;
	}

	public double calculateFare(Ride[] rides) {
		double aggregateTotal = 0;
		for(Ride ride: rides) {
			aggregateTotal += this.calculateFare(ride.getDistance(), ride.getTime());
		}
		return aggregateTotal;
	}

	public Invoice generateInvoice(Ride[] rides) {
		double totalFare = this.calculateFare(rides);
		int totalRides = rides.length;
		double averageFare = totalFare/totalRides;
		return new Invoice(totalFare, totalRides, averageFare);
		
	}

	public void addRide(String userId, Ride[] rides) {
		RideRepository rideRepository = new RideRepository();
		rideRepository.addRide(userId, rides);
	}

	public Invoice getInvoice(String userId) {
		//RideRepository rideRepository = new RideRepository();
		Ride[] rides = RideRepository.getRides(userId);
		
       // return calculateFare(rides);
		return generateInvoice(rides);
	}
}
