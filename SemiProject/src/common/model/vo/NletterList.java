package common.model.vo;

import java.sql.Date;

public class NletterList {
	private int letterNo;
	private int typeNo;
	private String typeName;
	private int title;
	private Date writeDate;
	public NletterList() {
		super();
	}
	public NletterList(int letterNo, int typeNo, String typeName, int title, Date writeDate) {
		super();
		this.letterNo = letterNo;
		this.typeNo = typeNo;
		this.typeName = typeName;
		this.title = title;
		this.writeDate = writeDate;
	}
	public int getLetterNo() {
		return letterNo;
	}
	public void setLetterNo(int letterNo) {
		this.letterNo = letterNo;
	}
	public int getTypeNo() {
		return typeNo;
	}
	public void setTypeNo(int typeNo) {
		this.typeNo = typeNo;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getTitle() {
		return title;
	}
	public void setTitle(int title) {
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
		return "NletterList [letterNo=" + letterNo + ", typeNo=" + typeNo + ", typeName=" + typeName + ", title="
				+ title + ", writeDate=" + writeDate + "]";
	}

	
}
