package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date(dd/mm/yyyy): ");
			Date checkInDate = sdf.parse(sc.next());
			System.out.print("Check-out date(dd/mm/yyyy): ");		
			Date checkOutDate = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(roomNumber, checkInDate, checkOutDate);
			System.out.println("Reservation: " + reservation);			
			System.out.println();
			
			System.out.print("Enter data to update the reservation: ");
			System.out.print("Check-in date(dd/mm/yyyy): ");
			checkInDate = sdf.parse(sc.next());
			System.out.print("Check-out date(dd/mm/yyyy): ");
			checkOutDate = sdf.parse(sc.next());
			
			reservation.updateDates(checkInDate, checkOutDate);
			System.out.println("Reservation: " + reservation);
		}
		catch (ParseException e){
			System.out.println("Invalid date format");			
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());			
		}
		catch (RuntimeException e) {
			// TODO: handle exception
			System.out.println("Unexpected error");
		}

		sc.close();
	}

}
