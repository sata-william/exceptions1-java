package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date(dd/mm/yyyy): ");
		Date checkInDate = sdf.parse(sc.next());
		System.out.print("Check-out date(dd/mm/yyyy): ");
		Date checkOutDate = sdf.parse(sc.next());
		
		if (!checkOutDate.after(checkInDate) ) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");			
		}
		else {
			Reservation reservation = new Reservation(roomNumber, checkInDate, checkOutDate);
			System.out.println("Reservation: " + reservation);			
			System.out.println();
			
			System.out.print("Enter data to update the reservation: ");
			System.out.print("Check-in date(dd/mm/yyyy): ");
			checkInDate = sdf.parse(sc.next());
			System.out.print("Check-out date(dd/mm/yyyy): ");
			checkOutDate = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkInDate.before(now) || checkOutDate.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
				
			}
			else if (!checkOutDate.after(checkInDate) ) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");			
			}else {
				reservation.updateDates(checkInDate, checkOutDate);
				System.out.println("Reservation: " + reservation);				
		
			}
		}
		
		sc.close();
	}

}
