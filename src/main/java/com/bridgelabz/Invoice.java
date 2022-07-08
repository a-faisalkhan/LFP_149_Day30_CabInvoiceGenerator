package com.bridgelabz;

public class Invoice {

	private double totalFare;
	private int totalRides;
	private double averageFare;

	public Invoice(double totalFare, int totalRides, double averageFare) {
		this.totalFare = totalFare;
		this.totalRides = totalRides;
		this.averageFare = averageFare;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(averageFare);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalFare);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + totalRides;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		if (Double.doubleToLongBits(averageFare) != Double.doubleToLongBits(other.averageFare))
			return false;
		if (Double.doubleToLongBits(totalFare) != Double.doubleToLongBits(other.totalFare))
			return false;
		if (totalRides != other.totalRides)
			return false;
		return true;
	}
	

}
