package home.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Home implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2880659629435214871L;
	private int hNo;		// 집 게시글 번호
	private String type;	// 유형
	private String period;	// 기간
	private int fee;		// 요금
	private String title;	// 제목
	private String content;	// 내용
	private int report;		// 신고횟수
	private String address;	// 주소
	private Date writeDate;	// 작성날짜
	private String countryNo;	// 나라번호
	private String country;

	private String userName;
	private String essentialitem;
	private String wifi;
	private String television;
	private String heater;
	private String airconditional;
	private String livingroom;
	private String diningroom;
	private String bathroom;
	private String pet;
	private int writerNo;	// 작성자번호

	public Home() {}

	public Home(int hNo, String type, String period, int fee, String title, String content, int report, String address,
			Date writeDate, String countryNo, int writerNo) {
		this.hNo = hNo;
		this.type = type;
		this.period = period;
		this.fee = fee;
		this.title = title;
		this.content = content;
		this.report = report;
		this.address = address;
		this.writeDate = writeDate;
		this.countryNo = countryNo;
		this.writerNo = writerNo;
	}
	
	
	
	
	public Home(int hNo, String type, String period, int fee, String title, String content, String address, Date writeDate,
			String country, String userName, String essentialitem, String wifi, String television, String heater,
			String airconditional, String livingroom, String diningroom, String bathroom, String pet, int writerNo) {
		this.hNo = hNo;
		this.type = type;
		this.period = period;
		this.fee = fee;
		this.title = title;
		this.content = content;
		this.address = address;
		this.writeDate = writeDate;
		this.country = country;
		this.userName = userName;
		this.essentialitem = essentialitem;
		this.wifi = wifi;
		this.television = television;
		this.heater = heater;
		this.airconditional = airconditional;
		this.livingroom = livingroom;
		this.diningroom = diningroom;
		this.bathroom = bathroom;
		this.pet = pet;
		this.writerNo = writerNo;
	}

	public Home(int hNo, String type, String period, int fee, String title, String content, String address,
			Date writeDate, String country, String userName, String essentialitem, String wifi, String television,
			String heater, String airconditional, String livingroom, String diningroom, String bathroom, String pet) {
		super();
		this.hNo = hNo;
		this.type = type;
		this.period = period;
		this.fee = fee;
		this.title = title;
		this.content = content;
		this.address = address;
		this.writeDate = writeDate;
		this.country = country;
		this.userName = userName;
		this.essentialitem = essentialitem;
		this.wifi = wifi;
		this.television = television;
		this.heater = heater;
		this.airconditional = airconditional;
		this.livingroom = livingroom;
		this.diningroom = diningroom;
		this.bathroom = bathroom;
		this.pet = pet;
	}

	public int gethNo() {
		return hNo;
	}

	public void sethNo(int hNo) {
		this.hNo = hNo;
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

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReport() {
		return report;
	}

	public void setReport(int report) {
		this.report = report;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getCountryNo() {
		return countryNo;
	}

	public void setCountryNo(String countryNo) {
		this.countryNo = countryNo;
	}

	public int getWriterNo() {
		return writerNo;
	}

	public void setWriterNo(int writerNo) {
		this.writerNo = writerNo;
	}

	public String getEssentialitem() {
		return essentialitem;
	}

	public void setEssentialitem(String essentialitem) {
		this.essentialitem = essentialitem;
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

	public String getAirconditional() {
		return airconditional;
	}

	public void setAirconditional(String airconditional) {
		this.airconditional = airconditional;
	}

	public String getLivingroom() {
		return livingroom;
	}

	public void setLivingroom(String livingroom) {
		this.livingroom = livingroom;
	}

	public String getDiningroom() {
		return diningroom;
	}

	public void setDiningroom(String diningroom) {
		this.diningroom = diningroom;
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
	
	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Home [hNo=" + hNo + ", type=" + type + ", period=" + period + ", fee=" + fee + ", title=" + title
				+ ", content=" + content + ", report=" + report + ", address=" + address + ", writeDate=" + writeDate
				+ ", countryNo=" + countryNo + ", writerNo=" + writerNo + ", userName=" + userName + ", essentialitem="
				+ essentialitem + ", wifi=" + wifi + ", television=" + television + ", heater=" + heater
				+ ", airconditional=" + airconditional + ", livingroom=" + livingroom + ", diningroom=" + diningroom
				+ ", bathroom=" + bathroom + ", pet=" + pet + "]";
	}
	
	



}
