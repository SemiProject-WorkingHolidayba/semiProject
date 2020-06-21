package community.model.vo;

import java.sql.Date;

public class Comment {
	private int commentNo;
	private String content;
	private Date writeDate;
	private int communityNo;
	private int report;
	private int userNo;
	private String userName;
	public Comment() {
		super();
	}
	public Comment(int commentNo, String content, Date writeDate, int communityNo, int report, int userNo,
			String userName) {
		super();
		this.commentNo = commentNo;
		this.content = content;
		this.writeDate = writeDate;
		this.communityNo = communityNo;
		this.report = report;
		this.userNo = userNo;
		this.userName = userName;
	}

	
	
	public Comment(String content, int communityNo, int userNo) {
		super();
		this.content = content;
		this.communityNo = communityNo;
		this.userNo = userNo;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
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
	public int getCommunityNo() {
		return communityNo;
	}
	public void setCommunityNo(int communityNo) {
		this.communityNo = communityNo;
	}
	public int getReport() {
		return report;
	}
	public void setReport(int report) {
		this.report = report;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "Comment [commentNo=" + commentNo + ", content=" + content + ", writeDate=" + writeDate
				+ ", communityNo=" + communityNo + ", report=" + report + ", userNo=" + userNo + ", userName="
				+ userName + "]";
	}
	
	

}

