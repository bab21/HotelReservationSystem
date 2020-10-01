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
	public static void getCheapestBestRatedHotel() {
		System.out.println("Enter start day(YEAR-MONTH-DAY)");
		LocalDate startdate = LocalDate.parse(s.next());
		System.out.println("Enter end day(YEAR-MONTH-DAY)");
		LocalDate enddate = LocalDate.parse(s.next());
		
		
		LocalDate tempstartdate=startdate;
		LocalDate tempenddate=enddate;
		
		int min_cost=100000000;
		String cheapest_hotel=null;
		try {
			myReader=new FileReader(file);
			BufferedReader br = new BufferedReader(myReader);
			
			String line;
			int best_rating=0;
			while((line=br.readLine())!=null) {
				startdate=tempstartdate;
				enddate=tempenddate.plusDays(1);
				String[] hotel=line.split(",");
				int weekendrate=Integer.parseInt(hotel[1]);
				int weekdayrate=Integer.parseInt(hotel[2]);
				int curr_rating=Integer.parseInt(hotel[3]);
				
				
				
				
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
				
				
				if(cost_of_the_hotel<min_cost ) {
					min_cost=cost_of_the_hotel;
					cheapest_hotel=new String(hotel[0]);
					
				}
				else if(cost_of_the_hotel==min_cost && curr_rating>best_rating) {
					min_cost=cost_of_the_hotel;
					cheapest_hotel=new String(hotel[0]);
					best_rating=curr_rating;
				}

			
		    }
			System.out.println("Cheapest and best rated hotel is "+cheapest_hotel+" and cost is : "+min_cost);
			
		
		}
		catch(Exception e) {
			System.out.println("Error occured");
		}
		
	}
		
	
}
