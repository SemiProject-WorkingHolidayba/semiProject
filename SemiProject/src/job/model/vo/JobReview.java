package job.model.vo;

import java.io.Serializable;

public class JobReview implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3973474003726363445L;
	
	private int reviewNo;
	private String content;
	private String wirteDate;
	private int report;
	private int jobNo;
	private int score;
	private int userNo;

	public JobReview() {
		super();
	}

	public JobReview(int reviewNo, String content, String wirteDate, int report, int jobNo, int score, int userNo) {
		super();
		this.reviewNo = reviewNo;
		this.content = content;
		this.wirteDate = wirteDate;
		this.report = report;
		this.jobNo = jobNo;
		this.score = score;
		this.userNo = userNo;
	}
	

	public JobReview(String content, int jobNo, int userNo) {
		super();
		this.content = content;
		this.jobNo = jobNo;
		this.userNo = userNo;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWirteDate() {
		return wirteDate;
	}

	public void setWirteDate(String wirteDate) {
		this.wirteDate = wirteDate;
	}

	public int getReport() {
		return report;
	}

	public void setReport(int report) {
		this.report = report;
	}

	public int getJobNo() {
		return jobNo;
	}

	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
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
		return "JobReview [reviewNo=" + reviewNo + ", content=" + content + ", wirteDate=" + wirteDate + ", report="
				+ report + ", jobNo=" + jobNo + ", score=" + score + ", userNo=" + userNo + "]";
	}
	

}
