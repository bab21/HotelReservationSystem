package com.capgemini.HotelReservationSystem.Main;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

import com.capgemini.HotelReservationSystem.Utility.HotelUtility;
import java.util.Scanner;

public class HotelReservation {
	public static void main(String[] args) throws IOException {
		Scanner s=new Scanner(System.in);
		System.out.println("Welcome to Hotel Reservation Program");
		
		do {
			System.out.println("Enter your choice");
			System.out.println("1.Add a new Hotel.");
			System.out.println("2.Get cheapest best rated Hotel");
			System.out.println("3.Get Best Rated Hotel");
			System.out.println("4.Exit.");
			int choice=s.nextInt();
			if(choice==4)
				break;
			switch(choice) {
			case 1:HotelUtility.addHotel();
				   break;
			case 2:HotelUtility.getCheapestBestRatedHotel();
			       break;
			case 3:HotelUtility.getBestRatedHotel();
			       break;
		    default:System.out.println("Do nothing");
			}
			
		}while(true);	
	}
}
