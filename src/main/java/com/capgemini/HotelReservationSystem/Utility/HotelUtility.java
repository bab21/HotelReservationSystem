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
import java.time.temporal.ChronoUnit;
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
		
		System.out.println("Enter rate");
		int rate=s.nextInt();
		
		
		Hotel hotel=new Hotel();
		hotel.setHotelName(hotelName);
		hotel.setRate(rate);
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
	
	public static void calculateCost() {
		System.out.println("Enter start day(YEAR-MONTH-DAY)");
		LocalDate startdate = LocalDate.parse(s.next());
		System.out.println("Enter end day(YEAR-MONTH-DAY)");
		LocalDate enddate = LocalDate.parse(s.next());
		enddate=enddate.plusDays(1);
		
		int min_cost=100000000;
		String cheapest_hotel=null;
		try {
			myReader=new FileReader(file);
			BufferedReader br = new BufferedReader(myReader);
		
			String line;
			while((line=br.readLine())!=null) {
				String[] hotel=line.split(",");
				int rate=Integer.parseInt(hotel[1]);
				int cost_of_the_hotel=0;
				long diffInDays = ChronoUnit.DAYS.between(startdate, enddate);
				cost_of_the_hotel=rate*(int)diffInDays;
				if(cost_of_the_hotel<min_cost) {
					min_cost=cost_of_the_hotel;
					cheapest_hotel=new String(hotel[0]);
				}
				
		    }
			System.out.println("Cheapest hotel is "+cheapest_hotel+" and cost is : "+min_cost);
		}
		catch(Exception e) {
			System.out.println("Error occured");
		}
	}
}
