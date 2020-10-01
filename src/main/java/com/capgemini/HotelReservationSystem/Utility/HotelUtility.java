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
		
		Hotel hotel=new Hotel();
		hotel.setHotelName(hotelName);
		hotel.setWeekdayRateRugularCustomer(weekdayRateRegularCustomer);
		hotel.setWeekendRateRgularCustomer(weekendRateRegularCustomer);
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
	public static void cheapest_hotel_given_range() {
		
		System.out.println("Enter start day(YEAR-MONTH-DAY)");
		String input_date_start=s.next();
		System.out.println("Enter end day(YEAR-MONTH-DAY)");
		String input_date_end=s.next();
		
		LocalDate startdate = LocalDate.parse(input_date_start);
		LocalDate enddate = LocalDate.parse(input_date_end);
		
		LocalDate tempstartdate=startdate;
		LocalDate tempenddate=enddate;
		
		int min_cost=100000000;
		String cheapest_hotel=null;
		try {
			myReader=new FileReader(file);
			BufferedReader br = new BufferedReader(myReader);
			
			String line;
			while((line=br.readLine())!=null) {
				startdate=tempstartdate;
				enddate=tempenddate.plusDays(1);
				String[] hotel=line.split(",");
				int weekendrate=Integer.parseInt(hotel[1]);
				int weekdayrate=Integer.parseInt(hotel[2]);
				
				
				
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
