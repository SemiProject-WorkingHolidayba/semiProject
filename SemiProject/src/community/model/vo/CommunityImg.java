package community.model.vo;

import java.sql.Date;

public class CommunityImg {
	private int imgNo;	
	private int communityNo;
	private String originName;
	private String changeName;
	private String filePath;
	private Date uploadDate;
	public CommunityImg() {
		super();
	}
	public CommunityImg(int imgNo, int communityNo, String originName, String changeName, String filePath,
			Date uploadDate) {
		super();
		this.imgNo = imgNo;
		this.communityNo = communityNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
	}
	
	public int getImgNo() {
		return imgNo;
	}
	public void setImgNo(int imgNo) {
		this.imgNo = imgNo;
	}
	public int getCommunityNo() {
		return communityNo;
	}
	public void setCommunityNo(int communityNo) {
		this.communityNo = communityNo;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	@Override
	public String toString() {
		return "CommunityImg [imgNo=" + imgNo + ", communityNo=" + communityNo + ", originName=" + originName
				+ ", changeName=" + changeName + ", filePath=" + filePath + ", uploadDate=" + uploadDate + "]";
	}
	


}
