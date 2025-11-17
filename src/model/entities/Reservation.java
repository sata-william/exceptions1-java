package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date    checkIn;
	private Date    chekOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		super();
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date chekOut) {
		super();
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.chekOut = chekOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkIn;
	}

	public Date getChekout() {
		return chekOut;
	}
	
	public long duration() {
		long diff = chekOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);		 
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Error in reservation: Reservation dates for update must be future dates";			
		}
		if (!checkOut.after(checkIn) ) {
			return "Error in reservation: Check-out date must be after check-in date";			
		}
		this.checkIn = checkIn;
		this.chekOut = checkOut;
		return null;
	}
	
	@Override
	public String toString( ) {
		return "Room "
				+ roomNumber
				+ ", check-In: "
				+ sdf.format(checkIn)
				+ ", check-Out: "
				+ sdf.format(chekOut)
				+ ", "
				+ duration()
				+ " nights";
				
	}
	
}
