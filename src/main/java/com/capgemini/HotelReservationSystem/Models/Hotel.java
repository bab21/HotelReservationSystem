package com.capgemini.HotelReservationSystem.Models;

public class Hotel {
	String hotelName;
	int weekendRateRegularCustomer;
	int weekdayRateRegularCustomer;
	
	public void setHotelName(String hotelName) {
		this.hotelName=hotelName;
	}
	
	public void setWeekendRateRgularCustomer(int weekendRateRegularCustomer ) {
		this.weekendRateRegularCustomer=weekendRateRegularCustomer;
	}
	
	public void setWeekdayRateRugularCustomer(int weekdayRateRegularCustomer) {
		this.weekdayRateRegularCustomer=weekdayRateRegularCustomer;
	}
	
	public String getHotelName() {
		return this.hotelName;
	}
	
	public int getWeekendRateRegularCustomer() {
		return this.weekendRateRegularCustomer;
	}
	
	public int getWeekdayRateRegularCustomer() {
		return this.weekdayRateRegularCustomer;
	}
	public String toString() {
		return hotelName+","+weekendRateRegularCustomer+","+weekdayRateRegularCustomer;
	}
}
