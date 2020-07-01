package safeInfo.model.vo;

import java.sql.Date;

public class Safe {
	private int safeNo;
	private String title;
	private String content;
	private int viewCount;
	private Date writeDate;
	private String img;
	private String countryNo;

	public Safe() {}

	public Safe(int safeNo, String title, String content, int viewCount, Date writeDate, String img, String countryNo) {
		this.safeNo = safeNo;
		this.title = title;
		this.content = content;
		this.viewCount = viewCount;
		this.writeDate = writeDate;
		this.img = img;
		this.countryNo = countryNo;
	}

	public int getSafeNo() {
		return safeNo;
	}

	public void setSafeNo(int safeNo) {
		this.safeNo = safeNo;
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

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getCountryNo() {
		return countryNo;
	}

	public void setCountryNo(String countryNo) {
		this.countryNo = countryNo;
	}

	@Override
	public String toString() {
		return "Safe [safeNo=" + safeNo + ", title=" + title + ", content=" + content + ", viewCount=" + viewCount
				+ ", writeDate=" + writeDate + ", img=" + img + ", countryNo=" + countryNo + "]";
	}
	
}
