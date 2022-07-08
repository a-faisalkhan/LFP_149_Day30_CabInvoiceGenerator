package com.bridgelabz;

import java.util.LinkedHashMap;
import java.util.Map;

public class RideRepository {
	static Map<String, Ride[]> userRideList = new LinkedHashMap<String, Ride[]>();

	public static void addRide(String userId, Ride[] rides) {
		userRideList.put(userId, rides);

	}

	public static Ride[] getRides(String userId) {
		return userRideList.get(userId);
	}

}
