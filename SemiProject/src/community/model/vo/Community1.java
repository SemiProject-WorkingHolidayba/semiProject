package community.model.vo;

import java.sql.Date;


public class Community1 {
	private int communityNo;
	private String title;
	private String content;
	private Date writeDate;
	private int viewCount;
	private int report;
	private String countryNo;
	private String categoryNo;
	private int userNo;
	private String status;
	private String typeNo;
	public Community1() {
		
	}
	public Community1(int communityNo, String title, String content, Date writeDate, int viewCount, int report,
			String countryNo, String categoryNo, int userNo, String status, String typeNo) {
		super();
		this.communityNo = communityNo;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
		this.viewCount = viewCount;
		this.report = report;
		this.countryNo = countryNo;
		this.categoryNo = categoryNo;
		this.userNo = userNo;
		this.status = status;
		this.typeNo = typeNo;
	}
	public int getCommunityNo() {
		return communityNo;
	}
	public void setCommunityNo(int communityNo) {
		this.communityNo = communityNo;
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
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getReport() {
		return report;
	}
	public void setReport(int report) {
		this.report = report;
	}
	public String getCountryNo() {
		return countryNo;
	}
	public void setCountryNo(String countryNo) {
		this.countryNo = countryNo;
	}
	public String getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTypeNo() {
		return typeNo;
	}
	public void setTypeNo(String typeNo) {
		this.typeNo = typeNo;
	}
	@Override
	public String toString() {
		return "Community1 [communityNo=" + communityNo + ", title=" + title + ", content=" + content + ", writeDate="
				+ writeDate + ", viewCount=" + viewCount + ", report=" + report + ", countryNo=" + countryNo
				+ ", categoryNo=" + categoryNo + ", userNo=" + userNo + ", status=" + status + ", typeNo=" + typeNo
				+ "]";
	}
	
	
	
}
