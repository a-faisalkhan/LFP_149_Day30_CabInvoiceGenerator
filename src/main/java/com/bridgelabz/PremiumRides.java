package com.bridgelabz;

public class PremiumRides {

	private final double PRE_COST_PER_KM = 20.0;
    private final int PRE_COST_PER_MIN = 2;
    private final double PRE_MIN_FARE = 20.0;
    

    
    public double premiumCalculateFare(double distance, int time) {
        double totalFare = distance * PRE_COST_PER_KM + time * PRE_COST_PER_MIN;
        return Math.max(totalFare, PRE_MIN_FARE);
    }
    
    public PremiumInvoice premiumCalculateFare(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            totalFare += premiumCalculateFare(ride.getDistance(), ride.getTime());
        }
        System.out.println("length "+rides.length +" fare" +totalFare);
        return new PremiumInvoice(rides.length, totalFare);
    }
}
