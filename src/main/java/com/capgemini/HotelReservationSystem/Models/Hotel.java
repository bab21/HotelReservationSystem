package com.capgemini.HotelReservationSystem.Models;

public class Hotel {
	String hotelName;
	int weekendRateRegularCustomer;
	int weekdayRateRegularCustomer;
	int weekdayRateRewardCustomer;
	int weekendRateRewardCustomer;
	int rating;
	
	public Hotel(String hotelName,int weekendRateRegularCustomer,int weekdayRateRegularCustomer,int weekdayRateRewardCustomer,int  weekendRateRewardCustomer,int rating) {
		this.hotelName=hotelName;
		this.weekendRateRegularCustomer=weekendRateRegularCustomer;
		this.weekdayRateRegularCustomer=weekdayRateRegularCustomer;
		this.weekendRateRewardCustomer=weekendRateRewardCustomer;
		this.weekdayRateRewardCustomer=weekdayRateRewardCustomer;
		this.rating=rating;
	}
	public void setHotelName(String hotelName) {
		this.hotelName=hotelName;
	}
	public void setWeekendRateRgularCustomer(int weekendRateRegularCustomer ) {
		this.weekendRateRegularCustomer=weekendRateRegularCustomer;
	}
	public void setWeekdayRateRugularCustomer(int weekdayRateRegularCustomer) {
		this.weekdayRateRegularCustomer=weekdayRateRegularCustomer;
	}
	public void setWeekendRateRewardCustomer(int weekendRateRewardCustomer) {
		this.weekendRateRewardCustomer= weekendRateRewardCustomer;
	}
	public void setweekdayRateRewardCustomer(int weekdayRateRewardCustomer) {
		this.weekdayRateRewardCustomer=weekdayRateRewardCustomer;
	}
	public void setRating(int rating) {
		this.rating=rating;
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
	public int getWeedendRateRewardCustomer() {
		return this.weekendRateRewardCustomer;
	}
	public int getWeekdayRateRewardCustomer() {
		return this.weekdayRateRewardCustomer;
	}
	public int getRating() {
		return this.rating;
	}
	public String toString() {
		return hotelName+","+weekendRateRegularCustomer+","+weekdayRateRegularCustomer+","+weekendRateRewardCustomer+","+weekdayRateRewardCustomer+","+rating;
	}
}