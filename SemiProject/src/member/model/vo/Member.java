package member.model.vo;

import java.sql.Date;

public class Member {
	private int tableNo;
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private Date userBirth;
	private String email;
	private int grade;
	private String sanction;
	private String status;
	private String gender;
	
	
	public Member() {
		
	}


	public Member(String userId, String userPw) {
		super();
		this.userId = userId;
		this.userPw = userPw;
	}




	public Member(String userId, String userPw, String userName, Date userBirth, String email, int grade,
			String gender) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userBirth = userBirth;
		this.email = email;
		this.grade = grade;
		this.gender = gender;
	}


	public Member(String userId, String userName, String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
	}

	



	public Member(int userNo, String userId, String userPw, String userName, Date userBirth, String email,
			int grade, String sanction, String status, String gender) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userBirth = userBirth;		
		this.email = email;
		this.grade = grade;
		this.sanction = sanction;
		this.status = status;
		this.gender = gender;
	}

	
	
	

	public Member(int tableNo, int userNo, String userId, String userPw, String userName, Date userBirth, String email,
			int grade, String sanction, String status, String gender) {
		this.tableNo = tableNo;
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userBirth = userBirth;
		this.email = email;
		this.grade = grade;
		this.sanction = sanction;
		this.status = status;
		this.gender = gender;
	}


	public int getTableNo() {
		return tableNo;
	}


	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPw() {
		return userPw;
	}


	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Date getUserBirth() {
		return userBirth;
	}


	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}


	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public String getSanction() {
		return sanction;
	}


	public void setSanction(String sanction) {
		this.sanction = sanction;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "Member [tableNo=" + tableNo + ", userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw
				+ ", userName=" + userName + ", userBirth=" + userBirth + ", email=" + email + ", grade=" + grade
				+ ", sanction=" + sanction + ", status=" + status + ", gender=" + gender + "]";
	}


	
	
	
	

}
