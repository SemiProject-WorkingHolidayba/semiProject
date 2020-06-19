package home.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Review implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7180292135360067105L;
	private int reviewNo;
	private String img;
	private String content;
	private Date writeDate;
	private int report;
	private int houseNo;
	private int score;
	private int userNo;
	private String userName;
	
	public Review() {}
	
	
	public Review(String content, int houseNo, int score, int userNo) {
		this.content = content;
		this.houseNo = houseNo;
		this.score = score;
		this.userNo = userNo;
	}
	
	


	public Review(int reviewNo, String content, Date writeDate, int report, int houseNo, int score, int userNo,
			String userName) {
		this.reviewNo = reviewNo;
		this.content = content;
		this.writeDate = writeDate;
		this.report = report;
		this.houseNo = houseNo;
		this.score = score;
		this.userNo = userNo;
		this.userName = userName;
	}


	public Review(String img, String content, int houseNo, int userNo) {
		this.img = img;
		this.content = content;
		this.houseNo = houseNo;
		this.userNo = userNo;
	}


	public Review(String img, String content, int houseNo, int score, String userName) {
		this.img = img;
		this.content = content;
		this.houseNo = houseNo;
		this.score = score;
		this.userName = userName;
	}


	public Review(String content, int houseNo, int score, String userName) {
		this.content = content;
		this.houseNo = houseNo;
		this.score = score;
		this.userName = userName;
	}	
	
	

	public Review(String img, String content, int houseNo, int score, int userNo) {
		this.img = img;
		this.content = content;
		this.houseNo = houseNo;
		this.score = score;
		this.userNo = userNo;
	}

	public Review(int reviewNo, String img, String content, Date writeDate, int report, int houseNo, int score,
			int userNo, String userName) {
		this.reviewNo = reviewNo;
		this.img = img;
		this.content = content;
		this.writeDate = writeDate;
		this.report = report;
		this.houseNo = houseNo;
		this.score = score;
		this.userNo = userNo;
		this.userName = userName;
	}


	public Review(int reviewNo, String img, String content, Date writeDate, int report, int houseNo, int score,
			int userNo) {
		this.reviewNo = reviewNo;
		this.img = img;
		this.content = content;
		this.writeDate = writeDate;
		this.report = report;
		this.houseNo = houseNo;
		this.score = score;
		this.userNo = userNo;
	}
	
	

	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getReport() {
		return report;
	}

	public void setReport(int report) {
		this.report = report;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", img=" + img + ", content=" + content + ", report=" + report
				+ ", houseNo=" + houseNo + ", score=" + score + ", userNo=" + userNo + "]";
	}
	
}
