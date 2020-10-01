package com.capgemini.HotelReservationSystem.Utility;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.*;
import com.capgemini.HotelReservationSystem.Models.*;
public class HotelUtility {
	
	public static List<Hotel> hotel_List=new ArrayList<Hotel>();
	public static File file = new File("reservation.txt");
	public static FileWriter myWriter ;
	public static FileReader myReader ;
	public static Scanner s=new Scanner(System.in);
	
	public static void addHotel() {
		
		
		System.out.println("Enter hotel Name");
		String hotelName=s.next();
		
		System.out.println("Enter weekday rate for regular customer");
		int weekdayRateRegularCustomer=s.nextInt();
		
		System.out.println("Enter weekend rate for regular customer");
		int weekendRateRegularCustomer=s.nextInt();
		
		System.out.println("Enter rating for the hotel(1-5)");
		int rating=s.nextInt();
		
		Hotel hotel=new Hotel();
		hotel.setHotelName(hotelName);
		hotel.setWeekdayRateRugularCustomer(weekdayRateRegularCustomer);
		hotel.setWeekendRateRgularCustomer(weekendRateRegularCustomer);
		hotel.setRating(rating);
		hotel_List.add(hotel);
		
		try {
		myWriter=new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(myWriter);
	    bw.write(hotel.toString());
	    bw.newLine();
	    bw.close();
        myWriter.close();
		}
		catch(Exception e) {
			System.out.println("exception occured");
		}
		System.out.println("Added successfully");
		
	}
		
	
}
