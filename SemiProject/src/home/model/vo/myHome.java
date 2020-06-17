package home.model.vo;

import java.io.Serializable;

public class myHome implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7254449400761577005L;
	private int userNo;
	private int houseNo;
	private String type;
	private String period;
	private String title;
	private String fee;
	private String address;
	private String essentialItem;
	private String wifi;
	private String television;
	private String heater;
	private String airConditional;
	private String livingroom;
	private String bathroom;
	private String pet;
	private String userName;
	private String email;
	private int reservationNo;
	
	public myHome() {
		super();
	}

	public myHome(int userNo, int houseNo, String type, String period, String title, String fee, String address,
			String essentialItem, String wifi, String television, String heater, String airConditional,
			String livingroom, String bathroom, String pet, String userName, String email, int reservationNo) {
		super();
		this.userNo = userNo;
		this.houseNo = houseNo;
		this.type = type;
		this.period = period;
		this.title = title;
		this.fee = fee;
		this.address = address;
		this.essentialItem = essentialItem;
		this.wifi = wifi;
		this.television = television;
		this.heater = heater;
		this.airConditional = airConditional;
		this.livingroom = livingroom;
		this.bathroom = bathroom;
		this.pet = pet;
		this.userName = userName;
		this.email = email;
		this.reservationNo = reservationNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEssentialItem() {
		return essentialItem;
	}

	public void setEssentialItem(String essentialItem) {
		this.essentialItem = essentialItem;
	}

	public String getWifi() {
		return wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public String getTelevision() {
		return television;
	}

	public void setTelevision(String television) {
		this.television = television;
	}

	public String getHeater() {
		return heater;
	}

	public void setHeater(String heater) {
		this.heater = heater;
	}

	public String getAirConditional() {
		return airConditional;
	}

	public void setAirConditional(String airConditional) {
		this.airConditional = airConditional;
	}

	public String getLivingroom() {
		return livingroom;
	}

	public void setLivingroom(String livingroom) {
		this.livingroom = livingroom;
	}

	public String getBathroom() {
		return bathroom;
	}

	public void setBathroom(String bathroom) {
		this.bathroom = bathroom;
	}

	public String getPet() {
		return pet;
	}

	public void setPet(String pet) {
		this.pet = pet;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}

	@Override
	public String toString() {
		return "Home [userNo=" + userNo + ", houseNo=" + houseNo + ", type=" + type + ", period=" + period + ", title="
				+ title + ", fee=" + fee + ", address=" + address + ", essentialItem=" + essentialItem + ", wifi="
				+ wifi + ", television=" + television + ", heater=" + heater + ", airConditional=" + airConditional
				+ ", livingroom=" + livingroom + ", bathroom=" + bathroom + ", pet=" + pet + ", userName=" + userName
				+ ", email=" + email + ", reservationNo=" + reservationNo + "]";
	}
	
}
