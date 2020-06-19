package common.model.vo;

import java.sql.Date;

public class NletterList {

	private int jobNo;
	private int houseNo;
	private int communityNo;
	private String typeNo;
	private String typeName;
	private String title;
	private Date writeDate;
	public NletterList() {
		super();
	}
	
	
	
	public NletterList(int jobNo, String typeName, String title, Date writeDate) {
		super();
		this.jobNo = jobNo;
		this.typeName = typeName;
		this.title = title;
		this.writeDate = writeDate;
	}



	public NletterList(int jobNo, String typeNo, String typeName, String title, Date writeDate) {
		super();
		this.jobNo = jobNo;
		this.typeNo = typeNo;
		this.typeName = typeName;
		this.title = title;
		this.writeDate = writeDate;
	}

	public NletterList(int jobNo, int houseNo, int communityNo, String typeNo, String typeName, String title,
			Date writeDate) {
		super();
		this.jobNo = jobNo;
		this.houseNo = houseNo;
		this.communityNo = communityNo;
		this.typeNo = typeNo;
		this.typeName = typeName;
		this.title = title;
		this.writeDate = writeDate;
	}
	public int getJobNo() {
		return jobNo;
	}
	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public int getCommunityNo() {
		return communityNo;
	}
	public void setCommunityNo(int communityNo) {
		this.communityNo = communityNo;
	}
	public String getTypeNo() {
		return typeNo;
	}
	public void setTypeNo(String typeNo) {
		this.typeNo = typeNo;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	@Override
	public String toString() {
		return "NletterList [jobNo=" + jobNo + ", houseNo=" + houseNo + ", communityNo=" + communityNo + ", typeNo="
				+ typeNo + ", typeName=" + typeName + ", title=" + title + ", writeDate=" + writeDate + "]";
	}
	

	
}
