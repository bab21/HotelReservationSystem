package com.capgemini.HotelReservationSystem.Models;

public class Hotel {
	String hotelName;
	int rate;
	
	
	public void setHotelName(String hotelName) {
		this.hotelName=hotelName;
	}
	
	public void setRate(int rate ) {
		this.rate=rate;
	}
	
	
	
	public String getHotelName() {
		return this.hotelName;
	}
	
	public int getRate() {
		return this.rate;
	}
	
	public String toString() {
		return hotelName+","+rate;
	}
}
