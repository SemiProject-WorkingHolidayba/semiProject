package home.model.vo;

public class HomeReservator {

	private int reservationNo;
	private String title;
	private String type;
	private String userName;
	private String period;
	private String email;
	
	public HomeReservator() {
		super();
	}
	public HomeReservator(int reservationNo, String title, String type, String userName, String period, String email) {
		super();
		this.reservationNo = reservationNo;
		this.title = title;
		this.type = type;
		this.userName = userName;
		this.period = period;
		this.email = email;
	}
	public int getReservationNo() {
		return reservationNo;
	}
	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "HomeReservator [reservationNo=" + reservationNo + ", title=" + title + ", type=" + type + ", userName="
				+ userName + ", period=" + period + ", email=" + email + "]";
	}
	
	
}
