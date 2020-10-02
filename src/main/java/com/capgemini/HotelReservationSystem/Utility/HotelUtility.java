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
import java.util.stream.Collectors;

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
		
		System.out.println("Enter weekday rate for reward customer");
		int weekdayRateRewardCustomer=s.nextInt();
		
		System.out.println("Enter weekend rate for reward customer");
		int weekendRateRewardCustomer=s.nextInt();
		
		Hotel hotel=new Hotel(hotelName,weekendRateRegularCustomer,weekdayRateRegularCustomer,weekendRateRewardCustomer,weekdayRateRewardCustomer,rating);
		
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
	public static void getCheapestBestRatedHotel(String type) {
		System.out.println("Enter start day(YEAR-MONTH-DAY)");
		LocalDate startdate = LocalDate.parse(s.next());
		System.out.println("Enter end day(YEAR-MONTH-DAY)");
		LocalDate enddate = LocalDate.parse(s.next());
		
		ArrayList<Hotel> hotel_list=new ArrayList<Hotel>();
		
		int min_cost;
		String best_rated_cheapest_hotel_name=null;
		try {
			myReader=new FileReader(file);
			BufferedReader br = new BufferedReader(myReader);
			
			String line;
			while((line=br.readLine())!=null) {
				String[] hotel=line.split(",");
				Hotel hotelobject=new Hotel(hotel[0],Integer.parseInt(hotel[1]),Integer.parseInt(hotel[2]),Integer.parseInt(hotel[3]),Integer.parseInt(hotel[4]),Integer.parseInt(hotel[5]));
				hotel_list.add(hotelobject);
		    }
			
			min_cost=hotel_list.stream().map(hotel->compute_cost(hotel,type,startdate,enddate)).min(Integer::compare).get(); 
			List<Hotel> hotel_with_minimum_cost= hotel_list.stream()
				                                            .filter(hotel->compute_cost(hotel,type,startdate,enddate)==min_cost)
				                                            .collect(Collectors.toList());
			
			Hotel hotel_with_max_rating_minimum_cost=hotel_with_minimum_cost.stream()
					                                 .max((hotel1,hotel2)->hotel1.getRating()> hotel2.getRating() ? 1: -1).get(); 
			
			best_rated_cheapest_hotel_name=hotel_with_max_rating_minimum_cost.getHotelName();
			System.out.println("Cheapest and best rated hotel is "+best_rated_cheapest_hotel_name+" and cost is : "+min_cost);
		}
		catch(Exception e) {
			System.out.println("Error occured");
		}
		
	}
	public static int compute_cost(Hotel hotel,String customerType,LocalDate startdate,LocalDate enddate) {
		
		int weekendrate=0,weekdayrate=0;
		
		if(customerType.equals("regular")) {
		 weekendrate=hotel.getWeekendRateRegularCustomer();
		 weekdayrate=hotel.getWeekdayRateRegularCustomer();
		}
		else if(customerType.equals("reward")) {
		 weekendrate=hotel.getWeedendRateRewardCustomer();
		 weekdayrate=hotel.getWeekdayRateRewardCustomer();
		}
		enddate=enddate.plusDays(1);
		
		
		int cost_of_the_hotel=0;
		while(startdate.compareTo(enddate)!=0) {
			
			DayOfWeek day = DayOfWeek.of(startdate.get(ChronoField.DAY_OF_WEEK));
		      switch (day) {
		         case SATURDAY:
		            cost_of_the_hotel=cost_of_the_hotel+weekendrate;
		            break;
		         case SUNDAY:
		        	 cost_of_the_hotel=cost_of_the_hotel+weekendrate;
		            break;
		         default:
		        	 cost_of_the_hotel=cost_of_the_hotel+weekdayrate;
		      }
		    startdate=startdate.plusDays(1);  
		      
		}
		return cost_of_the_hotel;
		
	}
	
}
