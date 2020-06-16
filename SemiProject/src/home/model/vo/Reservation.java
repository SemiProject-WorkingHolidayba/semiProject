package home.model.vo;

import java.io.Serializable;

public class Reservation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7211922726304426895L;
	private int reservationNo;
	private int houseNo;
	private int userNo;
	
	public Reservation() {}

	public Reservation(int reservationNo, int houseNo, int userNo) {
		this.reservationNo = reservationNo;
		this.houseNo = houseNo;
		this.userNo = userNo;
	}
	
	
	public Reservation(int houseNo, int userNo) {
		this.houseNo = houseNo;
		this.userNo = userNo;
	}

	public int getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Reservation [reservationNo=" + reservationNo + ", houseNo=" + houseNo + ", userNo=" + userNo + "]";
	}
	
	
	
}
